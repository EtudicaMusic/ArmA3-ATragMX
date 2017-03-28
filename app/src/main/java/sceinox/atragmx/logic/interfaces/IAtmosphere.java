package sceinox.atragmx.logic.interfaces;

/**
 * Created by etudicamusic on 3/28/2017.
 */

public interface IAtmosphere {
    double getTemperature();

    void setTemperature(double temperature);

    double getBarometricPressure();

    void setBarometricPressure(double barometricPressure);

    double getRelativeHumidity();

    void setRelativeHumidity(double relativeHumidity);
}
