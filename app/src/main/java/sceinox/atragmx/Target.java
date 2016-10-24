package sceinox.atragmx;

class Target {
    private int lat;
    private int dirOfShot;
    private float wind1;
    private float wind2;
    private int dirWind;
    private float incAngle;
    private float speed;
    private int range;

    public Target(int lat, int dirOfShot, float wind1, float wind2, int dirWind, float incAngle, float speed, int range) {
        this.lat = lat;
        this.dirOfShot = dirOfShot;
        this.wind1 = wind1;
        this.wind2 = wind2;
        this.dirWind = dirWind;
        this.incAngle = incAngle;
        this.speed = speed;
        this.range = range;
    }

    public int getLat() {
        return lat;
    }

    public int getDirOfShot() {
        return dirOfShot;
    }

    public float getWind1() {
        return wind1;
    }

    public float getWind2() {
        return wind2;
    }

    public int getDirWind() {
        return dirWind;
    }

    public float getIncAngle() {
        return incAngle;
    }

    public float getSpeed() {
        return speed;
    }

    public int getRange() {
        return range;
    }
}
