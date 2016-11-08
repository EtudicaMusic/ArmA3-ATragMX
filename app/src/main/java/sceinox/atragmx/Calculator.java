package sceinox.atragmx;

import android.app.Activity;
import android.content.Context;

import android.widget.TextView;

import static sceinox.atragmx.R.id.*;

public class Calculator {

    //region private static fields
    private static Context context;

    private static double gunBoreHeight;
    private static double gunBulletWeight;
    private static double gunBallisticCoefficient;
    private static double gunMuzzleVelocity;
    private static double gunZeroRange;

    private static double atmsphrTemperature;
    private static double atmsphrBarometricPressure;
    private static double atmsphrRelativeHumidity;

    private static double targetWindStrength;
    private static double targetWindDirection;
    private static double targetInclinationAngle;
    private static double targetTargetSpeed;
    private static double targetTargetRange;
    //endregion

    //region public getters
    public static void setGunBoreHeight(double gunBoreHeight) {
        Calculator.gunBoreHeight = gunBoreHeight;
    }

    public static void setGunBulletWeight(double gunBulletWeight) {
        Calculator.gunBulletWeight = gunBulletWeight;
    }

    public static void setGunBallisticCoefficient(double gunBallisticCoefficient) {
        Calculator.gunBallisticCoefficient = gunBallisticCoefficient;
    }

    public static void setGunMuzzleVelocity(double gunMuzzleVelocity) {
        Calculator.gunMuzzleVelocity = gunMuzzleVelocity;
    }

    public static void setGunZeroRange(double gunZeroRange) {
        Calculator.gunZeroRange = gunZeroRange;
    }

    public static void setAtmsphrTemperature(double atmosphere_temperature) {
        Calculator.atmsphrTemperature = atmosphere_temperature;
    }

    public static void setAtmsphrBarometricPressure(double atmosphere_barometric_pressure) {
        Calculator.atmsphrBarometricPressure = atmosphere_barometric_pressure;
    }

    public static void setAtmsphrRelativeHumidity(double atmsphrRelativeHumidity) {
        Calculator.atmsphrRelativeHumidity = atmsphrRelativeHumidity;
    }

    public static void setTargetWindStrength(double targetWindStrength) {
        Calculator.targetWindStrength = targetWindStrength;
    }

    public static void setTargetWindDirection(double targetWindDirection) {
        Calculator.targetWindDirection = targetWindDirection;
    }

    public static void setTargetInclinationAngle(double targetInclinationAngle) {
        Calculator.targetInclinationAngle = targetInclinationAngle;
    }

    public static void setTargetTargetSpeed(double targetTargetSpeed) {
        Calculator.targetTargetSpeed = targetTargetSpeed;
    }

    public static void setTargetTargetRange(double targetTargetRange) {
        Calculator.targetTargetRange = targetTargetRange;
    }
    //endregion

    //region c'tors

    /*
    this c'tor is only used for unit tests.
    ToDo: Implement JUnit4 test suite
     */
    public Calculator(double gunBoreHeight, double gunBulletWeight, double gunBallisticCoefficient, double gunMuzzleVelocity, double gunZeroRange,
                      double atmsphrTemperature, double atmsphrBarometricPressure, double atmsphrRelativeHumidity,
                      double targetWindStrength, double targetWindDirection, double targetInclinationAngle, double targetTargetSpeed, double targetTargetRange) {
        Calculator.gunBoreHeight = gunBoreHeight;
        Calculator.gunBulletWeight = gunBulletWeight;
        Calculator.gunBallisticCoefficient = gunBallisticCoefficient;
        Calculator.gunMuzzleVelocity = gunMuzzleVelocity;
        Calculator.gunZeroRange = gunZeroRange;

        Calculator.atmsphrTemperature = atmsphrTemperature;
        Calculator.atmsphrBarometricPressure = atmsphrBarometricPressure;
        Calculator.atmsphrRelativeHumidity = atmsphrRelativeHumidity;

        Calculator.targetWindStrength = targetWindStrength;
        Calculator.targetWindDirection = targetWindDirection;
        Calculator.targetInclinationAngle = targetInclinationAngle;
        Calculator.targetTargetSpeed = targetTargetSpeed;
        Calculator.targetTargetRange = targetTargetRange;
    }

    public Calculator(Context context){
        Calculator.context = context;

        Calculator.gunBoreHeight = getInputOfText(Text_BHNumber);
        Calculator.gunBulletWeight = getInputOfText(Text_BWNumber);
        Calculator.gunBallisticCoefficient = getInputOfText(Text_C1Number);
        Calculator.gunMuzzleVelocity = getInputOfText(Text_MVNumber);
        Calculator.gunZeroRange = getInputOfText(Text_ZRNumber);

        Calculator.atmsphrTemperature = getInputOfText(Text_TmpNumber);
        Calculator.atmsphrBarometricPressure = getInputOfText(Text_BPNumber);
        Calculator.atmsphrRelativeHumidity = getInputOfText(Text_RHNumber);

        Calculator.targetWindStrength = getInputOfText(Text_WSNumber);
        Calculator.targetWindDirection = getInputOfText(Text_WDNumber);
        Calculator.targetInclinationAngle = getInputOfText(Text_IANumber);
        Calculator.targetTargetSpeed = getInputOfText(Text_TSNumber);
        Calculator.targetTargetRange = getInputOfText(Text_TRNumber);
    }
    //endregion

    //region private methods
    private static double getInputOfText(int id){
        return Double.parseDouble(((TextView) ((Activity) context).findViewById(id)).getText().toString());
    }

    public static double calculateSolution(){

        return 0;
    }


    //endregion
}