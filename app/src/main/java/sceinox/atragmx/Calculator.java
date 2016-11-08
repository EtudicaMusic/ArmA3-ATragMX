package sceinox.atragmx;

import android.view.View;
import android.widget.TextView;

import static sceinox.atragmx.R.id.*;

class Calculator {

    //region private static fields
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
    Calculator(double gunBoreHeight, double gunBulletWeight, double gunBallisticCoefficient, double gunMuzzleVelocity, double gunZeroRange,
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

    Calculator(View view){
        Calculator.gunBoreHeight = getInputOfText(view, Text_BHNumber);
        Calculator.gunBulletWeight = getInputOfText(view, Text_BWNumber);
        Calculator.gunBallisticCoefficient = getInputOfText(view, Text_C1Number);
        Calculator.gunMuzzleVelocity = getInputOfText(view, Text_MVNumber);
        Calculator.gunZeroRange = getInputOfText(view, Text_ZRNumber);

        Calculator.atmsphrTemperature = getInputOfText(view, Text_Atmsphr);
        Calculator.atmsphrBarometricPressure = getInputOfText(view, Text_BPNumber);
        Calculator.atmsphrRelativeHumidity = getInputOfText(view, Text_RHNumber);

        Calculator.targetWindStrength = getInputOfText(view, Text_WSNumber);
        Calculator.targetWindDirection = getInputOfText(view, Text_WDNumber);
        Calculator.targetInclinationAngle = getInputOfText(view, Text_IANumber);
        Calculator.targetTargetSpeed = getInputOfText(view, Text_TSNumber);
        Calculator.targetTargetRange = getInputOfText(view, Text_TRNumber);

        testInput();

    }
    //endregion

    //region private methods
    private static double getInputOfText(View view, int id){
        TextView output =(TextView) view.findViewById(id);
        System.out.println(output.getText());
        return 3.0;
    }

    private static void testInput(){
        System.out.println(gunBoreHeight);
        System.out.println(targetWindDirection);
    }
    //endregion
}
