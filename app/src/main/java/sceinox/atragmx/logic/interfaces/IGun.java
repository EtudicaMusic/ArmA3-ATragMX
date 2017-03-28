package sceinox.atragmx.logic.interfaces;

/**
 * Created by etudicamusic on 3/28/2017.
 */

public interface IGun {
    double getBoreHeight();

    void setBoreHeight(double boreHeight);

    double getBulletWeight();

    void setBulletWeight(double bulletWeight);

    double getBallisticCoefficient();

    void setBallisticCoefficient(double ballisticCoefficient);

    double getMuzzleVelocity();

    void setMuzzleVelocity(double muzzleVelocity);

    double getZeroRange();

    void setZeroRange(double zeroRange);
}
