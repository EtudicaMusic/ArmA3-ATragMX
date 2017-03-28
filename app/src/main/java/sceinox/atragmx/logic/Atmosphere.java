package sceinox.atragmx.logic;

/**
 * Created by etudicamusic on 3/28/2017.
 */

public class Atmosphere implements sceinox.atragmx.logic.interfaces.IAtmosphere {
    private double temperature;
    private double barometricPressure;
    private double relativeHumidity;

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double getBarometricPressure() {
        return barometricPressure;
    }

    @Override
    public void setBarometricPressure(double barometricPressure) {
        this.barometricPressure = barometricPressure;
    }

    @Override
    public double getRelativeHumidity() {
        return relativeHumidity;
    }

    @Override
    public void setRelativeHumidity(double relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }
}
