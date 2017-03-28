package sceinox.atragmx.logic.interfaces;

/**
 * Created by etudicamusic on 3/28/2017.
 */

public interface ITarget {
    double getWindStrength();

    void setWindStrength(double windStrength);

    double getWindDirection();

    void setWindDirection(double windDirection);

    double getInclinationAngle();

    void setInclinationAngle(double inclinationAngle);

    double getSpeed();

    void setSpeed(double speed);

    double getRange();

    void setRange(double range);
}
