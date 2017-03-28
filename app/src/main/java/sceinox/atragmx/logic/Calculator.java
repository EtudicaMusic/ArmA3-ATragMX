package sceinox.atragmx.logic;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sceinox.atragmx.logic.interfaces.IAtmosphere;
import sceinox.atragmx.logic.interfaces.IGun;
import sceinox.atragmx.logic.interfaces.ITarget;

import static java.lang.Math.atan;
import static java.lang.Math.cos;
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

    //region private fields
    private IGun gun;
    private IAtmosphere atmosphere;
    private ITarget target;
    private Context context;

    private double gunBoreHeight;
    private double gunBulletWeight;
    private double gunBallisticCoefficient;
    private double gunMuzzleVelocity;
    private double gunZeroRange;

    private double atmsphrTemperature;
    private double atmsphrBarometricPressure;
    private double atmsphrRelativeHumidity;

    private double targetWindStrength;
    private double targetWindDirection;
    private double targetInclinationAngle;
    private double targetTargetSpeed;
    private double targetTargetRange;
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
    public CalculatorSolution calculateSolution() {
//        /* variables from already exisiting data */
//        double scopeBaseAngle;
//        double bulletMass = getSelectedProfile().getBulletWeight();
//        double boreHeight = getSelectedProfile().getBoreHeight();
//        double airFriction;
//        double muzzleVelocity = getSelectedProfile().getMuzzleVelocity();
//        double temperature = getSelectedProfile().getTemperature();
//        double barometricPressure = getSelectedProfile().getBarometricPressure();
//        double relativeHumidity = getSelectedProfile().getHumidity();
//        double simSteps;
//
//        double windDirection = getSelectedProfile().getWindDirection();
//        double inclinationAngle = getSelectedProfile().getInclinationAngleDegree();
//        double targetSpeed = getSelectedProfile().getTargetSpeed();
//        double targetRange = getSelectedProfile().getZeroRange();
//        double bc = getSelectedProfile().getC1Coefficient();
//        double dragModel;
//        double atmosphericModel;
//        double stabilityFactor;
//        double twistDirection = getSelectedProfile().getRifleTwist();
//        double latitude = getSelectedProfile().getLatitude();
//        double directionOfFire;
//
//        double[] windSpeed = new double[2];
//
//        /* helper variables block 1*/
//        double tx = 0;
//        double tz = 0;
//        double[] lastBulletPos = {0,0,0};
//        double[] bulletPos = {0,0,0};
//        double[] bulletVelocity = {0,0,0};
//        double[] bulletAccel = {0,0,0};
//        double bulletSpeed = 0;
//        double[] gravity = {0, sin(scopeBaseAngle + inclinationAngle) * -9.80665, cos(scopeBaseAngle + inclinationAngle) * -9.80665};
//        double deltaT = 1/simSteps;
//
//        /* helper variables block 2 */
//        double elevation = 0;
//        double windage1 = 0;
//        double windage2 = 0;
//        double lead = 0;
//        double TOF = 0;
//        double[] trueVelocity = {0,0,0};
//        double trueSpeed = 0;
//        double verticalCoriolis = 0;
//        double verticalDeflection = 0;
//        double horizontalCoriolis = 0;
//        double horizontalDeflection = 0;
//        double spinDrift = 0;
//        double spinDeflection = 0;
//
//        /* helper variables block 3 */
//        double n = 0;
//        double range = 0;
//        double trueRange = 0;
//        double rangeFactor = 1.0936133;
//
//        /* helper variables block 4 */
//        double[] wind1 = {cos(270 - windDirection * 30) * windSpeed[0], sin(270 - windDirection * 30) * windSpeed[0], 0};
//        double[] wind2 = {cos(270 - windDirection * 30) * windSpeed[1], sin(270 - windDirection * 30) * windSpeed[1], 0};
//        double windDrift = 0;
//        bc = calculateAthmosphericCorrection(bc, temperature, barometricPressure, relativeHumidity, atmosphericModel);
//
//        /* helper variables block 5 */
//        double eoetvoesMultiplier = 2 * (0.0000729 * muzzleVelocity / -9.80665) * cos(latitude) * sin(directionOfFire);
//
//        /* helper variables block 6 */
//        double rangeCardStartRange = 100;
//        double rangeCardIncrement = 50;
//        double rangeCardEndRange = 2000;
//
//        while (TOF < 15 && bulletPos[1] < targetRange) {
//            bulletSpeed = vectorMagnitude(bulletVelocity);
//
//            trueVelocity = vectordiff(bulletVelocity, wind1);
//            trueSpeed = vectorMagnitude(trueVelocity);
//
//            double drag = calculateDrag(dragModel, bc, trueSpeed);
//            bulletAccel = vectorMultiply(vectorNormalized(trueVelocity), -1 * drag);
//
//            bulletAccel = vectorAdd(bulletAccel, gravity);
//
//            lastBulletPos = bulletPos;
//            bulletPos = vectorAdd(bulletPos, vectorMultiply(bulletVelocity, deltaT * 0.5));
//            bulletVelocity = vectorAdd(bulletVelocity, vectorMultiply(bulletAccel, deltaT));
//            bulletPos = vectorAdd(bulletPos, vectorMultiply(bulletVelocity, deltaT * 0.5));
//
//            TOF += deltaT;
//        }
//
//        if (targetRange != 0) {
//            tx = lastBulletPos[0] + (targetRange - lastBulletPos[1]) * (bulletPos[0] - lastBulletPos[0]) / (bulletPos[1] - lastBulletPos[1]);
//            tz = lastBulletPos[2] + (targetRange - lastBulletPos[1]) * (bulletPos[2] - lastBulletPos[2]) / (bulletPos[1] - lastBulletPos[1]);
//            elevation = - atan(tz / targetRange);
//            windage1 = - atan(tx / targetRange);
//            windDrift = wind2[0] * (TOF - targetRange / muzzleVelocity);
//            windage2 = - atan(windDrift / targetRange);
//            lead = (targetSpeed * TOF) / (tan(3.38 / 60) * targetRange);
//        }
//
//        double kineticEnergy = 0.5 * (bulletMass / 1000 * Math.pow(bulletSpeed,2));
//        kineticEnergy *= 0.737562149;
//
//        if (bulletPos[1] > 0) {
//            horizontalDeflection = 0.0000729 * bulletPos[1] * TOF * sin(latitude);
//            horizontalCoriolis = - atan(horizontalDeflection / bulletPos[1]);
//            windage1 = windage1 + horizontalCoriolis;
//            windage2 = windage2 + horizontalCoriolis;
//
//            verticalDeflection = bulletPos[2] * eoetvoesMultiplier;
//            verticalCoriolis = - atan(verticalDeflection / bulletPos[1]);
//            elevation += verticalCoriolis;
//
//            spinDeflection = twistDirection * 0.0254 * 1.25 * (stabilityFactor + 1.2) * TOF ^ 1.83;
//            spinDrift = - atan(spinDeflection / bulletPos[1]);
//            windage1 = windage1 + spinDrift;
//            windage2 = windage2 + spinDrift;
//        }

        return new CalculatorSolution(0,new double[]{0,0},0,0,0,0,0,0,0);
    }

    double calculateAthmosphericCorrection(double bc, double temperature, double barometricPressure, double relativeHumidity, double atmosphericModel) {
        //ToDo: Fill in formula

        return 0d;
    }

    double calculateDrag(double dragModel, double bc, double trueSpeed) {
        //ToDo: Fill in formula

        return 0d;
    }

    public double vectorMagnitude(double[] vector) {
        return Math.sqrt(pow(vector[0], 2) + pow(vector[1], 2) + pow(vector[2], 2));
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

    public double[] vectorMultiply(double[] x, double a) {
        double[] res = new double[x.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = x[i] * a;
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
    //endregion
}