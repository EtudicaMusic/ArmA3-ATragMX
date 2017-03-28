package sceinox.atragmx.logic;

/**
 * Created by etudicamusic on 3/28/2017.
 */

public class Target implements sceinox.atragmx.logic.interfaces.ITarget {
    private double windStrength;
    private double windDirection;
    private double inclinationAngle;
    private double speed;
    private double range;

    public Target(double windStrength, double windDirection, double inclinationAngle, double speed, double range){
        this.setWindStrength(windStrength);
        this.setWindDirection(windDirection);
        this.setInclinationAngle(inclinationAngle);
        this.setSpeed(speed);
        this.setRange(range);
    }

    public Target()
    {
        this(0d,0d,0d,0d,0d);
    }

    @Override
    public double getWindStrength() {
        return windStrength;
    }

    @Override
    public void setWindStrength(double windStrength) {
        this.windStrength = windStrength;
    }

    @Override
    public double getWindDirection() {
        return windDirection;
    }

    @Override
    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    @Override
    public double getInclinationAngle() {
        return inclinationAngle;
    }

    @Override
    public void setInclinationAngle(double inclinationAngle) {
        this.inclinationAngle = inclinationAngle;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public double getRange() {
        return range;
    }

    @Override
    public void setRange(double range) {
        this.range = range;
    }
}
