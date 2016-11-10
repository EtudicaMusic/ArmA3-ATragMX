package sceinox.atragmx;

import android.app.Activity;
import android.content.Context;

import android.widget.TextView;

import static sceinox.atragmx.R.id.*;

class Calculator {

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

    Calculator(Context context){
        this.context = context;

        this.gunBoreHeight = getInputOfText(Text_BHNumber);
        this.gunBulletWeight = getInputOfText(Text_BWNumber);
        this.gunBallisticCoefficient = getInputOfText(Text_C1Number);
        this.gunZeroRange = getInputOfText(Text_ZRNumber);
        this.gunMuzzleVelocity = getInputOfText(Text_MVNumber);

        this.atmsphrTemperature = getInputOfText(Text_TmpNumber);
        this.atmsphrBarometricPressure = getInputOfText(Text_BPNumber);
        this.atmsphrRelativeHumidity = getInputOfText(Text_RHNumber);

        this.targetWindStrength = getInputOfText(Text_WSNumber);
        this.targetWindDirection = getInputOfText(Text_WDNumber);
        this.targetInclinationAngle = getInputOfText(Text_IANumber);
        this.targetTargetSpeed = getInputOfText(Text_TSNumber);
        this.targetTargetRange = getInputOfText(Text_TRNumber);
    }
    //endregion

    //region private methods
    private double getInputOfText(int id){
        return Double.parseDouble(((TextView) ((Activity) context).findViewById(id)).getText().toString());
    }

    //ToDo: Implement
    public double calculateSolution(){

        return 0;
    }
    //endregion
}