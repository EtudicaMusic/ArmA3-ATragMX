package sceinox.atragmx.logic;

import sceinox.atragmx.logic.interfaces.IGun;

/**
 * Created by etudicamusic on 3/28/2017.
 */

public class Gun implements IGun {
    private double boreHeight;
    private double bulletWeight;
    private double ballisticCoefficient;
    private double muzzleVelocity;
    private double zeroRange;

    @Override
    public double getBoreHeight() {
        return boreHeight;
    }

    @Override
    public void setBoreHeight(double boreHeight) {
        this.boreHeight = boreHeight;
    }

    @Override
    public double getBulletWeight() {
        return bulletWeight;
    }

    @Override
    public void setBulletWeight(double bulletWeight) {
        this.bulletWeight = bulletWeight;
    }

    @Override
    public double getBallisticCoefficient() {
        return ballisticCoefficient;
    }

    @Override
    public void setBallisticCoefficient(double ballisticCoefficient) {
        this.ballisticCoefficient = ballisticCoefficient;
    }

    @Override
    public double getMuzzleVelocity() {
        return muzzleVelocity;
    }

    @Override
    public void setMuzzleVelocity(double muzzleVelocity) {
        this.muzzleVelocity = muzzleVelocity;
    }

    @Override
    public double getZeroRange() {
        return zeroRange;
    }

    @Override
    public void setZeroRange(double zeroRange) {
        this.zeroRange = zeroRange;
    }
}
