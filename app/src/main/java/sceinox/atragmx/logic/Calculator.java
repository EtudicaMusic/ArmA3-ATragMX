package sceinox.atragmx.logic;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

public class Calculator {

    //region private fields
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

    //region public getters
    public void setContext(Context context) {
        this.context = context;
    }

    public void setGunBoreHeight(double gunBoreHeight) {
        this.gunBoreHeight = gunBoreHeight;
    }

    public void setGunBulletWeight(double gunBulletWeight) {
        this.gunBulletWeight = gunBulletWeight;
    }

    public void setGunBallisticCoefficient(double gunBallisticCoefficient) {
        this.gunBallisticCoefficient = gunBallisticCoefficient;
    }

    public void setGunMuzzleVelocity(double gunMuzzleVelocity) {
        this.gunMuzzleVelocity = gunMuzzleVelocity;
    }

    public void setGunZeroRange(double gunZeroRange) {
        this.gunZeroRange = gunZeroRange;
    }

    public void setAtmsphrTemperature(double atmsphrTemperature) {
        this.atmsphrTemperature = atmsphrTemperature;
    }

    public void setAtmsphrBarometricPressure(double atmsphrBarometricPressure) {
        this.atmsphrBarometricPressure = atmsphrBarometricPressure;
    }

    public void setAtmsphrRelativeHumidity(double atmsphrRelativeHumidity) {
        this.atmsphrRelativeHumidity = atmsphrRelativeHumidity;
    }

    public void setTargetWindStrength(double targetWindStrength) {
        this.targetWindStrength = targetWindStrength;
    }

    public void setTargetWindDirection(double targetWindDirection) {
        this.targetWindDirection = targetWindDirection;
    }

    public void setTargetInclinationAngle(double targetInclinationAngle) {
        this.targetInclinationAngle = targetInclinationAngle;
    }

    public void setTargetTargetSpeed(double targetTargetSpeed) {
        this.targetTargetSpeed = targetTargetSpeed;
    }

    public void setTargetTargetRange(double targetTargetRange) {
        this.targetTargetRange = targetTargetRange;
    }
    //endregion

    //region c'tors
    /*
    this c'tor is only used for unit tests.
     */
    public Calculator(double gunBoreHeight, double gunBulletWeight, double gunBallisticCoefficient, double gunMuzzleVelocity, double gunZeroRange,
                      double atmsphrTemperature, double atmsphrBarometricPressure, double atmsphrRelativeHumidity,
                      double targetWindStrength, double targetWindDirection, double targetInclinationAngle, double targetTargetSpeed, double targetTargetRange) {
        this.gunBoreHeight = gunBoreHeight;
        this.gunBulletWeight = gunBulletWeight;
        this.gunBallisticCoefficient = gunBallisticCoefficient;
        this.gunMuzzleVelocity = gunMuzzleVelocity;
        this.gunZeroRange = gunZeroRange;

        this.atmsphrTemperature = atmsphrTemperature;
        this.atmsphrBarometricPressure = atmsphrBarometricPressure;
        this.atmsphrRelativeHumidity = atmsphrRelativeHumidity;

        this.targetWindStrength = targetWindStrength;
        this.targetWindDirection = targetWindDirection;
        this.targetInclinationAngle = targetInclinationAngle;
        this.targetTargetSpeed = targetTargetSpeed;
        this.targetTargetRange = targetTargetRange;
    }

    public Calculator(Context context) {
        this.context = context;

        this.gunBoreHeight = getInputOfText(Text_BHVal);
        this.gunBulletWeight = getInputOfText(Text_BWVal);
        this.gunBallisticCoefficient = getInputOfText(Text_C1Val);
        this.gunZeroRange = getInputOfText(Text_ZRVal);
        this.gunMuzzleVelocity = getInputOfText(Text_MVVal);

        this.atmsphrTemperature = getInputOfText(Text_TmpVal);
        //this.atmsphrBarometricPressure = getInputOfText(Text_B);
        //this.atmsphrRelativeHumidity = getInputOfText(Text_RHVal);

        this.targetWindStrength = getInputOfText(Text_WSVal);
        this.targetWindDirection = getInputOfText(Text_WDVal);
        this.targetInclinationAngle = getInputOfText(Text_IAVal);
        this.targetTargetSpeed = getInputOfText(Text_TSVal);
        this.targetTargetRange = getInputOfText(Text_TRVal);
    }
    //endregion

    //region private methods
    private double getInputOfText(int id) {
        return Double.parseDouble(((TextView) ((Activity) context).findViewById(id)).getText().toString());
    }

    //ToDo: Implement
    public CalculatorSolution calculateSolution() {
        double scopeBaseAngle = 0;
        double simStep = 0;
        double dragModel = 0;
        double athmospereModel = 0;

        // res variables
        double elevation = 0;
        double windage = 0;
        double lead = 0;
        double TOF = 0;
        double[] trueVelocity = new double[2];
        double trueSpeed = 0;
        double kineticEnergy;


        // math. helper variables
        double[] bulletPos = new double[]{
                0,
                0,
                -(gunBoreHeight / 100)
        };
        double[] bulletVelocity = new double[]{
                0,
                Math.cos(scopeBaseAngle) * gunMuzzleVelocity,
                Math.sin(scopeBaseAngle) * gunMuzzleVelocity
        };
        double[] bulletAccel;
        double bulletSpeed = 0;
        double[] gravity = new double[]{
                0,
                Math.sin(scopeBaseAngle + targetInclinationAngle) * -9.80665,
                Math.cos(scopeBaseAngle + targetInclinationAngle) * -9.80665d
        };
        double deltaT = 1 / simStep;
        double[] wind = new double[]{
                Math.cos(270 - targetWindDirection * 30) * targetWindStrength,
                Math.sin(270 - targetWindDirection * 30) * targetWindStrength,
                0
        };
        double bc = calculateAthmosphericCorrection(atmsphrTemperature, atmsphrBarometricPressure, atmsphrRelativeHumidity, athmospereModel);

        // RangeCard helper
        double n = 0;
        double range = 0;
        double rangeFactor = 1.0936133;
        double rangeIncrement = 0;
        double endRange = 0;
        List<Double> rangeCardData = new ArrayList<>();


        while (TOF < 15 && bulletPos[1] < targetTargetRange) {
            bulletSpeed = vectorMagnitude(bulletVelocity);

            trueVelocity = vectordiff(bulletVelocity, wind);
            trueSpeed = vectorMagnitude(trueVelocity);

            double drag = -1 * calculateRetardation(dragModel, bc, trueSpeed);
            bulletAccel = vectorMultiply(vectorNormalized(trueVelocity), drag);

            bulletAccel = vectorAdd(bulletAccel, gravity);

            bulletVelocity = vectorAdd(bulletVelocity, vectorMultiply(bulletAccel, deltaT));
            bulletPos = vectorAdd(bulletPos, vectorMultiply(bulletVelocity, deltaT));

            TOF = TOF + deltaT;

            /* RangeCardData */
            //ToDo: save results to RangeCard
            range = targetTargetRange + n * rangeIncrement;
            if (bulletPos[1] * rangeFactor >= range && range < endRange) {
                elevation = Math.atan(bulletPos[2] / bulletPos[1]);
                windage = Math.atan(bulletPos[0] / bulletPos[1]);
            }
            if (range != 0) {
                lead = (targetTargetSpeed * TOF) / (Math.tan(3.38 / 60) * range);
            }
            kineticEnergy = 0.5 * (gunBulletWeight / 1000 * Math.pow(bulletSpeed, 2));
            kineticEnergy = kineticEnergy * 0.737562149;
            // Ragecard[n] = range, elevation * 60, windage * 60, lead, TOF, bulletSpeed, kineticEnergy
            // n++;
            /* RangeCardData end */
        }

        if (bulletPos[1] > 0) {
            elevation = -Math.atan(bulletPos[2] / bulletPos[1]);
            windage = -Math.atan(bulletPos[0] / bulletPos[1]);
        }

        if (targetTargetSpeed != 0) {
            lead = (targetTargetSpeed * TOF) / (Math.tan(3.38 / 60) * targetTargetRange);
        }

        kineticEnergy = 0.5 * (gunBulletWeight / 1000 * Math.pow(bulletSpeed, 2));
        kineticEnergy = kineticEnergy * 0.737562149;

        return null;
    }

    private double calculateRetardation(double dragModel, double bc, double trueSpeed) {
        //ToDo: Implement
        throw new IllegalArgumentException();
    }


    private double calculateAthmosphericCorrection(double atmsphrTemperature, double atmsphrBarometricPressure, double atmsphrRelativeHumidity, double athmospereModel) {
        //ToDo: Implement
        throw new IllegalArgumentException();
    }

    public double vectorMagnitude(double[] vector) {
        return Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2) + Math.pow(vector[2], 2));
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
            res[i] = x[i] / (Math.sqrt(Math.pow(x[0], 2) + Math.pow(x[1], 2) + Math.pow(x[2], 2)));
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