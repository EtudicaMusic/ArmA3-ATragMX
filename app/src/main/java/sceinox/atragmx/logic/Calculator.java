package sceinox.atragmx.logic;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

import sceinox.atragmx.logic.interfaces.IAtmosphere;
import sceinox.atragmx.logic.interfaces.IGun;
import sceinox.atragmx.logic.interfaces.ITarget;

import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.floor;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
import static sceinox.atragmx.R.id.Text_BHVal;
import static sceinox.atragmx.R.id.Text_BWVal;
import static sceinox.atragmx.R.id.Text_C1Val;
import static sceinox.atragmx.R.id.Text_IAVal;
import static sceinox.atragmx.R.id.Text_MVVal;
import static sceinox.atragmx.R.id.Text_TRVal;
import static sceinox.atragmx.R.id.Text_TSVal;
import static sceinox.atragmx.R.id.Text_TmpVal;
import static sceinox.atragmx.R.id.Text_WDVal;
import static sceinox.atragmx.R.id.Text_WSVal;
import static sceinox.atragmx.R.id.Text_ZRVal;
import static sceinox.atragmx.logic.FireProfiles.getSelectedProfile;

public class Calculator {

    //region constants
    private final float DELTA_T=0.02f;
    private final float GRAVITY=9.80665f;
    private final float ABSOLUTE_ZERO_IN_CELSIUS=-273.15F;
    private final float EARTH_ANGULAR_SPEED=0.00007292f;
    private final float UNIVERSAL_GAS_CONSTANT=8.314f;
    private final float WATER_VAPOR_MOLAR_MASS=0.018016f;
    private final float DRY_AIR_MOLAR_MASS=0.028964f;
    private final float SPECIFIC_GAS_CONSTANT_DRY_AIR=287.058f;
    private final float STD_AIR_DENSITY_ICAO=1.22498f;
    private final float STD_AIR_DENSITY_ASM=1.20885f;

    private double KELVIN(double temperature){
        return temperature-ABSOLUTE_ZERO_IN_CELSIUS;
    }
    //end region
    //region private fields
    private IGun gun;
    private IAtmosphere atmosphere;
    private ITarget target;

    private Vector<Bullet> bulletDatabase;
    //not clear on the next section of code yet
    //original c++ code from https://github.com/acemod/ACE3/blob/master/extensions/advanced_ballistics/AdvancedBallistics.cpp
    //line 62ish
    /*
        std::unordered_map<std::string, Map> mapDatabase;
        std::string worldName = "";
        Map* map = &mapDatabase[""];
     */
    private LinkedHashMap<String, Map> mapDatabase;
    private String worldName;
    //no map pointer yet;

    private Context context;//is this needed??


    //endregion

    public Calculator(IGun gun, ITarget target, IAtmosphere atmosphere) throws NullPointerException{
        if(gun==null){
            throw new NullPointerException("Calculator requires a valid IGun.");
        }
        if(target==null){
            throw new NullPointerException("Calculator requires a valid ITarget.");
        }
        if(atmosphere==null){
            throw new NullPointerException("Calculator requires a valid IAtmosphere.");
        }

        this.gun=gun;
        this.target=target;
        this.atmosphere=atmosphere;


    }


    //unit testing should not require changing the class under test.
    //intent is to remove this c'tor after refactoring
    //(Use the Calculator(IGun, ITarget, IAtmosphere) instead)
    //region c'tors
    /*
    this c'tor is only used for unit tests.
     */
    public Calculator(double gunBoreHeight, double gunBulletWeight, double gunBallisticCoefficient, double gunMuzzleVelocity, double gunZeroRange,
                      double atmsphrTemperature, double atmsphrBarometricPressure, double atmsphrRelativeHumidity,
                      double targetWindStrength, double targetWindDirection, double targetInclinationAngle, double targetTargetSpeed, double targetTargetRange) {

        this(new Gun(),new Target(), new Atmosphere());

        this.gun.setBoreHeight(gunBoreHeight);
        this.gun.setBulletWeight(gunBulletWeight);
        this.gun.setBallisticCoefficient(gunBallisticCoefficient);
        this.gun.setMuzzleVelocity(gunMuzzleVelocity);
        this.gun.setZeroRange(gunZeroRange);

        this.atmosphere.setTemperature(atmsphrTemperature);
        this.atmosphere.setBarometricPressure(atmsphrBarometricPressure);
        this.atmosphere.setRelativeHumidity(atmsphrRelativeHumidity);

        this.target.setWindStrength(targetWindStrength);
        this.target.setWindDirection(targetWindDirection);
        this.target.setInclinationAngle(targetInclinationAngle);
        this.target.setSpeed(targetTargetSpeed);
        this.target.setRange(targetTargetRange);
    }

    public Calculator(Context context) {
        this.context = context;
    }
    //endregion

    //region private methods
    private double getInputOfText(int id) {
        return Double.parseDouble(((TextView) ((Activity) context).findViewById(id)).getText().toString());
    }

    //ToDo: Implement
    //a lot referenced from https://github.com/acemod/ACE3/blob/master/extensions/advanced_ballistics/AdvancedBallistics.cpp
    public CalculatorSolution calculateSolution() {


        /* variables from already exisiting data */
        double scopeBaseAngle=0;//todo: where does this come from
        double bulletMass = getSelectedProfile().getBulletWeight();
        double boreHeight = getSelectedProfile().getBoreHeight();
        double airFriction;
        double muzzleVelocity = getSelectedProfile().getMuzzleVelocity();
        double temperature = getSelectedProfile().getTemperature();
        double barometricPressure = getSelectedProfile().getBarometricPressure();
        double relativeHumidity = getSelectedProfile().getHumidity();
        double simSteps=1;

        double windDirection = getSelectedProfile().getWindDirection();
        double inclinationAngle = getSelectedProfile().getInclinationAngleDegree();
        double targetSpeed = getSelectedProfile().getTargetSpeed();
        //double targetRange = getSelectedProfile().getZeroRange();
        double targetRange=this.target.getRange();
        //todo: which is correct?
        //double bc = getSelectedProfile().getC1Coefficient();
        double bc=calculateAtmosphericCorrection(this.gun.getBallisticCoefficient(),this.atmosphere.getTemperature(),
                this.atmosphere.getBarometricPressure(), this.atmosphere.getRelativeHumidity(),"ICAO");//todo: make model variable
        double dragModel=1;//TODO: default
        String atmosphericModel="ICAO";
        double stabilityFactor=1;//TODO: where does this come from
        double twistDirection = getSelectedProfile().getRifleTwist();
        double latitude = getSelectedProfile().getLatitude();
        double directionOfFire=0;//TODO: default?

        double[] windSpeed = new double[2];

        /* helper variables block 1*/
        double tx = 0;
        double tz = 0;
        double[] lastBulletPos = {0,0,0};
        double[] bulletPos = {0,0,0};
        //double[] bulletVelocity = {0,0,0};
        Vector<Double> bulletVelocity=new Vector<Double>();
        double[] bulletAccel = {0,0,0};
        double bulletSpeed = 0;
        double[] gravity = {0, sin(scopeBaseAngle + inclinationAngle) * -9.80665, cos(scopeBaseAngle + inclinationAngle) * -9.80665};
        double deltaT = 1/simSteps;

        /* helper variables block 2 */
        double elevation = 0;
        double windage1 = 0;
        double windage2 = 0;
        double lead = 0;
        Double TOF = 0d;
        double[] trueVelocity = {0,0,0};
        double trueSpeed = 0;
        double verticalCoriolis = 0;
        double verticalDeflection = 0;
        double horizontalCoriolis = 0;
        double horizontalDeflection = 0;
        double spinDrift = 0;
        double spinDeflection = 0;

        /* helper variables block 3 */
        double n = 0;
        double range = 0;
        double trueRange = 0;
        double rangeFactor = 1.0936133;

        /* helper variables block 4 */
        double[] wind1 = {cos(270 - windDirection * 30) * windSpeed[0], sin(270 - windDirection * 30) * windSpeed[0], 0};
        double[] wind2 = {cos(270 - windDirection * 30) * windSpeed[1], sin(270 - windDirection * 30) * windSpeed[1], 0};
        double windDrift = 0;
        bc = calculateAtmosphericCorrection(bc, temperature, barometricPressure, relativeHumidity, atmosphericModel);

        /* helper variables block 5 */
        double eoetvoesMultiplier = 2 * (0.0000729 * muzzleVelocity / -9.80665) * cos(latitude) * sin(directionOfFire);

        /* helper variables block 6 */
        double rangeCardStartRange = 100;
        double rangeCardIncrement = 50;
        double rangeCardEndRange = 2000;

        /*need to set bullet velocity and position prior to starting the loop?*/
        bulletVelocity.add(0,0d);
        bulletVelocity.add(1,Math.cos(scopeBaseAngle)*muzzleVelocity);
        bulletVelocity.add(2, Math.sin(scopeBaseAngle)*muzzleVelocity);

        while (TOF < 15 && bulletPos[1] < targetRange) {
            bulletSpeed = vectorMagnitude(bulletVelocity);

            trueVelocity = vectordiff(bulletVelocity, wind1);
            trueSpeed = vectorMagnitude(trueVelocity);

            double drag = calculateDrag(dragModel, bc, trueSpeed);
            //bulletAccel = vectorMultiply(vectorNormalized(trueVelocity), -1 * drag);
            Vector<Double> bulletAccelTemp = vectorMultiply(vectorNormalized(trueVelocity), -1 * drag);
            //bulletAccel=bulletAccelTemp.toArray(new double[]);
            Object[] a=bulletAccelTemp.toArray();

            bulletAccel = vectorAdd(bulletAccel, gravity);

            lastBulletPos = bulletPos;
            bulletPos = vectorAdd(bulletPos, vectorMultiply(bulletVelocity, deltaT * 0.5));
            Vector<Double> bulletAccelDelta=vectorMultiply(bulletAccel, deltaT);
            //bulletVelocity = vectorAdd(bulletVelocity, bulletAccelDelta);
            bulletPos = vectorAdd(bulletPos, vectorMultiply(bulletVelocity, deltaT * 0.5));

            TOF += deltaT;
        }

        if (targetRange != 0) {
            tx = lastBulletPos[0] + (targetRange - lastBulletPos[1]) * (bulletPos[0] - lastBulletPos[0]) / (bulletPos[1] - lastBulletPos[1]);
            tz = lastBulletPos[2] + (targetRange - lastBulletPos[1]) * (bulletPos[2] - lastBulletPos[2]) / (bulletPos[1] - lastBulletPos[1]);
            elevation = - atan(tz / targetRange);
            windage1 = - atan(tx / targetRange);
            windDrift = wind2[0] * (TOF - targetRange / muzzleVelocity);
            windage2 = - atan(windDrift / targetRange);
            lead = (targetSpeed * TOF) / (tan(3.38 / 60) * targetRange);
        }

        double kineticEnergy = 0.5 * (bulletMass / 1000 * Math.pow(bulletSpeed,2));
        kineticEnergy *= 0.737562149;

        if (bulletPos[1] > 0) {
            horizontalDeflection = 0.0000729 * bulletPos[1] * TOF * sin(latitude);
            horizontalCoriolis = - atan(horizontalDeflection / bulletPos[1]);
            windage1 = windage1 + horizontalCoriolis;
            windage2 = windage2 + horizontalCoriolis;

            verticalDeflection = bulletPos[2] * eoetvoesMultiplier;
            verticalCoriolis = - atan(verticalDeflection / bulletPos[1]);
            elevation += verticalCoriolis;

            //TODO: fix tof segment
            //spinDeflection = twistDirection * 0.0254 * 1.25 * (stabilityFactor + 1.2) * TOF ^ 1.83;
            spinDeflection = twistDirection * 0.0254 * 1.25 * (stabilityFactor + 1.2) * TOF;
            spinDrift = - atan(spinDeflection / bulletPos[1]);
            windage1 = windage1 + spinDrift;
            windage2 = windage2 + spinDrift;
        }

        //return new CalculatorSolution(0,new double[]{0,0},0,0,0,0,0,0,0);
        return new CalculatorSolution(elevation,new double[]{windage1, windage2}, lead,TOF, bulletSpeed, kineticEnergy, verticalCoriolis, horizontalCoriolis, spinDrift);
    }



    double calculateDrag(double dragModel, double bc, double trueSpeed) {
        //ToDo: Fill in formula

        return 0d;
    }

    double calculateRoughnessLength(double posX, double posY){
        //source:http://es.ucsc.edu/~jnoble/wind/extrap/index.html
        double[] roughness_lengths={0.0002, 0.0005, 0.0024, 0.03, 0.055, 0.1, 0.4, 0.8, 1.6};

        Integer gridX=((Double)Math.floor(posX/50)).intValue();
        Integer gridY=((Double)Math.floor(posY/50)).intValue();
        //todo: need c++ clarification
        //c++:  int gridCell = gridX * map->mapGrids + gridY;
        Integer gridCell=gridX+gridY;

        //todo: need c++ clarification
        //if (gridCell >= 0 && (std::size_t)gridCell < map->gridHeights.size() && (std::size_t)gridCell < map->gridBuildingNums.size()) {
        if(gridCell>=0){
            //c++: int nearBuildings = map->gridBuildingNums[gridCell];
            //c++: int surfaceIsWater = map->gridSurfaceIsWater[gridCell];
            Integer nearBuildings=0;
            Integer surfaceIsWater=0;
            if (nearBuildings == 0 && surfaceIsWater == 1) {
                return 0.0005;
            }

            if (nearBuildings >= 10) {
                return 1.6;
            }

            //c++: return roughness_lengths[2 + std::min(nearBuildings, 6)];
            return roughness_lengths[2 + Math.min(nearBuildings, 6)];

        }

        return 0.0024;
    }

    double calculateAirDensity(double temperature, double pressure, double relativeHumidity) {
        pressure = pressure * 100;

        if (relativeHumidity > 0) {
            double _pSat = 6.1078 * pow(10, ((7.5 * temperature) / (temperature + 237.3)));
            double vaporPressure = relativeHumidity * _pSat;
            double partialPressure = pressure - vaporPressure;

            return (partialPressure * DRY_AIR_MOLAR_MASS + vaporPressure * WATER_VAPOR_MOLAR_MASS) / (UNIVERSAL_GAS_CONSTANT * KELVIN(temperature));
        } else {
            return pressure / (SPECIFIC_GAS_CONSTANT_DRY_AIR * KELVIN(temperature));
        }
    }

    double calculateAtmosphericCorrection(double ballisticCoefficient, double temperature, double pressure, double relativeHumidity, String atmosphereModel) {
        double airDensity = calculateAirDensity(temperature, pressure, relativeHumidity);

        if (atmosphereModel.equalsIgnoreCase("ICAO")) {
            return (STD_AIR_DENSITY_ICAO / airDensity) * ballisticCoefficient;
        } else {
            return (STD_AIR_DENSITY_ASM / airDensity) * ballisticCoefficient;
        }
    }

    double calculateRetard(int DragFunction, double DragCoefficient, double Velocity) {
        double vel = Velocity * 3.2808399;
        double val = -1;
        double A = -1;
        double M = -1;

        switch (DragFunction) {
            case 1:
                if (vel> 4230) { A = 1.477404177730177e-04; M = 1.9565; }
                else if (vel> 3680) { A = 1.920339268755614e-04; M = 1.925; }
                else if (vel> 3450) { A = 2.894751026819746e-04; M = 1.875; }
                else if (vel> 3295) { A = 4.349905111115636e-04; M = 1.825; }
                else if (vel> 3130) { A = 6.520421871892662e-04; M = 1.775; }
                else if (vel> 2960) { A = 9.748073694078696e-04; M = 1.725; }
                else if (vel> 2830) { A = 1.453721560187286e-03; M = 1.675; }
                else if (vel> 2680) { A = 2.162887202930376e-03; M = 1.625; }
                else if (vel> 2460) { A = 3.209559783129881e-03; M = 1.575; }
                else if (vel> 2225) { A = 3.904368218691249e-03; M = 1.55; }
                else if (vel> 2015) { A = 3.222942271262336e-03; M = 1.575; }
                else if (vel> 1890) { A = 2.203329542297809e-03; M = 1.625; }
                else if (vel> 1810) { A = 1.511001028891904e-03; M = 1.675; }
                else if (vel> 1730) { A = 8.609957592468259e-04; M = 1.75; }
                else if (vel> 1595) { A = 4.086146797305117e-04; M = 1.85; }
                else if (vel> 1520) { A = 1.954473210037398e-04; M = 1.95; }
                else if (vel> 1420) { A = 5.431896266462351e-05; M = 2.125; }
                else if (vel> 1360) { A = 8.847742581674416e-06; M = 2.375; }
                else if (vel> 1315) { A = 1.456922328720298e-06; M = 2.625; }
                else if (vel> 1280) { A = 2.419485191895565e-07; M = 2.875; }
                else if (vel> 1220) { A = 1.657956321067612e-08; M = 3.25; }
                else if (vel> 1185) { A = 4.745469537157371e-10; M = 3.75; }
                else if (vel> 1150) { A = 1.379746590025088e-11; M = 4.25; }
                else if (vel> 1100) { A = 4.070157961147882e-13; M = 4.75; }
                else if (vel> 1060) { A = 2.938236954847331e-14; M = 5.125; }
                else if (vel> 1025) { A = 1.228597370774746e-14; M = 5.25; }
                else if (vel>  980) { A = 2.916938264100495e-14; M = 5.125; }
                else if (vel>  945) { A = 3.855099424807451e-13; M = 4.75; }
                else if (vel>  905) { A = 1.185097045689854e-11; M = 4.25; }
                else if (vel>  860) { A = 3.566129470974951e-10; M = 3.75; }
                else if (vel>  810) { A = 1.045513263966272e-08; M = 3.25; }
                else if (vel>  780) { A = 1.291159200846216e-07; M = 2.875; }
                else if (vel>  750) { A = 6.824429329105383e-07; M = 2.625; }
                else if (vel>  700) { A = 3.569169672385163e-06; M = 2.375; }
                else if (vel>  640) { A = 1.839015095899579e-05; M = 2.125; }
                else if (vel>  600) { A = 5.71117468873424e-05; M = 1.950; }
                else if (vel>  550) { A = 9.226557091973427e-05; M = 1.875; }
                else if (vel>  250) { A = 9.337991957131389e-05; M = 1.875; }
                else if (vel>  100) { A = 7.225247327590413e-05; M = 1.925; }
                else if (vel>   65) { A = 5.792684957074546e-05; M = 1.975; }
                else if (vel>    0) { A = 5.206214107320588e-05; M = 2.000; }
                break;

            case 2:
                if (vel> 1674) { A = .0079470052136733;  M = 1.36999902851493; }
                else if (vel> 1172) { A = 1.00419763721974e-03;  M = 1.65392237010294; }
                else if (vel> 1060) { A = 7.15571228255369e-23;  M = 7.91913562392361; }
                else if (vel>  949) { A = 1.39589807205091e-10;  M = 3.81439537623717; }
                else if (vel>  670) { A = 2.34364342818625e-04;  M = 1.71869536324748; }
                else if (vel>  335) { A = 1.77962438921838e-04;  M = 1.76877550388679; }
                else if (vel>    0) { A = 5.18033561289704e-05;  M = 1.98160270524632; }
                break;

            case 5:
                if (vel> 1730) { A = 7.24854775171929e-03; M = 1.41538574492812; }
                else if (vel> 1228) { A = 3.50563361516117e-05; M = 2.13077307854948; }
                else if (vel> 1116) { A = 1.84029481181151e-13; M = 4.81927320350395; }
                else if (vel> 1004) { A = 1.34713064017409e-22; M = 7.8100555281422; }
                else if (vel>  837) { A = 1.03965974081168e-07; M = 2.84204791809926; }
                else if (vel>  335) { A = 1.09301593869823e-04; M = 1.81096361579504; }
                else if (vel>    0) { A = 3.51963178524273e-05; M = 2.00477856801111; }
                break;

            case 6:
                if (vel> 3236) { A = 0.0455384883480781; M = 1.15997674041274; }
                else if (vel> 2065) { A = 7.167261849653769e-02; M = 1.10704436538885; }
                else if (vel> 1311) { A = 1.66676386084348e-03; M = 1.60085100195952; }
                else if (vel> 1144) { A = 1.01482730119215e-07; M = 2.9569674731838; }
                else if (vel> 1004) { A = 4.31542773103552e-18; M = 6.34106317069757; }
                else if (vel>  670) { A = 2.04835650496866e-05; M = 2.11688446325998; }
                else if (vel>    0) { A = 7.50912466084823e-05; M = 1.92031057847052; }
                break;

            case 7:
                if (vel> 4200) { A = 1.29081656775919e-09; M = 3.24121295355962; }
                else if (vel> 3000) { A = 0.0171422231434847; M = 1.27907168025204; }
                else if (vel> 1470) { A = 2.33355948302505e-03; M = 1.52693913274526; }
                else if (vel> 1260) { A = 7.97592111627665e-04; M = 1.67688974440324; }
                else if (vel> 1110) { A = 5.71086414289273e-12; M = 4.3212826264889; }
                else if (vel>  960) { A = 3.02865108244904e-17; M = 5.99074203776707; }
                else if (vel>  670) { A = 7.52285155782535e-06; M = 2.1738019851075; }
                else if (vel>  540) { A = 1.31766281225189e-05; M = 2.08774690257991; }
                else if (vel>    0) { A = 1.34504843776525e-05; M = 2.08702306738884; }
                break;

            case 8:
                if (vel> 3571) { A = .0112263766252305; M = 1.33207346655961; }
                else if (vel> 1841) { A = .0167252613732636; M = 1.28662041261785; }
                else if (vel> 1120) { A = 2.20172456619625e-03; M = 1.55636358091189; }
                else if (vel> 1088) { A = 2.0538037167098e-16; M = 5.80410776994789; }
                else if (vel>  976) { A = 5.92182174254121e-12; M = 4.29275576134191; }
                else if (vel>    0) { A = 4.3917343795117e-05; M = 1.99978116283334; }
                break;

            default:
                break;

        }

        if (A != -1 && M != -1 && vel > 0 && vel < 10000) {
            val = A * pow(vel, M) / DragCoefficient;
            val = val / 3.2808399;
            return val;
        }

        return 0.0;
    }

    double calculateVanillaZeroAngle(double zeroRange, double muzzleVelocity, double airFriction, double boreHeight) {
        double zeroAngle = 0.0f;

        for (int i = 0; i < 10; i++) {
            double lx = 0.0f;
            double ly = 0.0f;

            double px = 0.0f;
            double py = -boreHeight / 100.0f;

            double gx = Math.sin(zeroAngle) * -GRAVITY;
            double gy = Math.cos(zeroAngle) * -GRAVITY;

            double vx = Math.cos(zeroAngle) * muzzleVelocity;
            double vy = Math.sin(zeroAngle) * muzzleVelocity;

            double tof = 0.0f;
            double v = 0.0f;

            while (tof < 8.0f && px < zeroRange) {
                lx = px;
                ly = py;

                v = Math.sqrt(vx*vx + vy*vy);

                double ax = vx * v * airFriction;
                double ay = vy * v * airFriction;
                ax += gx;
                ay += gy;

                px += vx * DELTA_T * 0.5;
                py += vy * DELTA_T * 0.5;
                vx += ax * DELTA_T;
                vy += ay * DELTA_T;
                px += vx * DELTA_T * 0.5;
                py += vy * DELTA_T * 0.5;

                tof += DELTA_T;
            }

            double y = ly + (zeroRange - lx) * (py - ly) / (px - lx);
            double offset = -Math.atan(y / zeroRange);
            zeroAngle += offset;

            if (Math.abs(offset) < 0.0001f) {
                break;
            }
        }

        return zeroAngle;
    }

    double calculateZeroAngle(double zeroRange, double muzzleVelocity, double boreHeight, double temperature, double pressure, double humidity, double ballisticCoefficient, int dragModel, String atmosphereModel) {
        double zeroAngle = 0.0f;

        ballisticCoefficient = calculateAtmosphericCorrection(ballisticCoefficient, temperature, pressure, humidity, atmosphereModel);

        for (int i = 0; i < 10; i++) {
            double lx = 0.0f;
            double ly = 0.0f;

            double px = 0.0f;
            double py = -boreHeight / 100.0f;

            double gx = Math.sin(zeroAngle) * -GRAVITY;
            double gy = Math.cos(zeroAngle) * -GRAVITY;

            double vx = Math.cos(zeroAngle) * muzzleVelocity;
            double vy = Math.sin(zeroAngle) * muzzleVelocity;

            double tof = 0.0f;
            double v = 0.0f;

            while (tof < 8.0f && px < zeroRange) {
                lx = px;
                ly = py;

                v = Math.sqrt(vx*vx + vy*vy);

                double retard = calculateRetard(dragModel, ballisticCoefficient, v);
                double ax = vx / v * -retard;
                double ay = vy / v * -retard;
                ax += gx;
                ay += gy;

                px += vx * DELTA_T * 0.5;
                py += vy * DELTA_T * 0.5;
                vx += ax * DELTA_T;
                vy += ay * DELTA_T;
                px += vx * DELTA_T * 0.5;
                py += vy * DELTA_T * 0.5;

                tof += DELTA_T;
            }

            double y = ly + (zeroRange - lx) * (py - ly) / (px - lx);
            double offset = -Math.atan(y / zeroRange);
            zeroAngle += offset;

            if (Math.abs(offset) < 0.0001f) {
                break;
            }
        }

        return zeroAngle;
    }

    //region clean up
    //todo: clean up vectors, this is messy
    public double vectorMagnitude(Vector<Double> vector){
        double magnitude=Math.sqrt(pow(vector.get(0),2)+pow(vector.get(1),2)+pow(vector.get(2),2));
        return magnitude;
    }

    public double vectorMagnitude(double[] vector) {
        return Math.sqrt(pow(vector[0], 2) + pow(vector[1], 2) + pow(vector[2], 2));
    }

    public double[] vectordiff(Vector<Double> x, double[] y) {
        if (x.size() != y.length) throw new ArithmeticException();

        double[] res = new double[x.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = x.get(i) - y[i];
        }

        return res;
    }

    public double[] vectordiff(double[] x, double[] y) {
        if (x.length != y.length) throw new ArithmeticException();

        double[] res = new double[x.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = x[i] - y[i];
        }

        return res;
    }

    public double[] vectorNormalized(double[] x) {
        double[] res = new double[x.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = x[i] / (Math.sqrt(pow(x[0], 2) + pow(x[1], 2) + pow(x[2], 2)));
        }

        return res;
    }

    public Vector<Double> vectorMultiply(Vector<Double> x, double a) {
        Vector<Double> res = new Vector<Double>();

        for (int i = 0; i < x.size(); i++) {
            res.add(x.get(i) * a);
        }

        return res;
    }

    public Vector<Double> vectorMultiply(Vector<Double> x, Vector<Double> a) {
        Vector<Double> res = new Vector<Double>();

        for (int i = 0; i < res.size(); i++) {
            res.add(x.get(i) * a.get(i));
        }

        return res;
    }

    public Vector<Double> vectorMultiply(double[] x, double a){
        Vector<Double> res=new Vector<Double>();

        for(int i=0; i<x.length;i++){
            res.add(x[i]*a);
        }
        return res;

    }


    public double[] vectorAdd(Vector<Double> x, double[] y) {
        if (x.size() != y.length) throw new ArithmeticException();

        double[] res = new double[x.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = x.get(i) + y[i];
        }

        return res;
    }

    public Vector<Double> vectorAdd(double[] x, double y){
        Vector<Double> res=new Vector<Double>();
        for(int i=0; i<x.length; i++){
            res.add(x[i]+y);
        }
        return res;
    }


    public double[] vectorAdd(Vector<Double> x, Vector<Double> y) {
        if (x.size() != y.size()) throw new ArithmeticException();

        double[] res = new double[x.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = x.get(i) + y.get(i);
        }

        return res;
    }


    public double[] vectorAdd(double[] x, double[] y) {
        if (x.length != y.length) throw new ArithmeticException();

        double[] res = new double[x.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = x[i] + y[i];
        }

        return res;
    }

    public double[] vectorAdd(double[] x, Vector<Double> y) {
        if (x.length != y.size()) throw new ArithmeticException();

        double[] res = new double[x.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = x[i] + y.get(i);
        }

        return res;
    }
    //end clean up region
    //endregion
}