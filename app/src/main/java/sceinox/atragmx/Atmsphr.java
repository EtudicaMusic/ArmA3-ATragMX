package sceinox.atragmx;

class Atmsphr {
    private int tmp;
    private int bp;
    private int rh;

    public Atmsphr(int tmp, int bp, int rh) {
        this.tmp = tmp;
        this.bp = bp;
        this.rh = rh;
    }

    public int getTmp() {
        return tmp;
    }

    public int getBp() {
        return bp;
    }

    public int getRh() {
        return rh;
    }

}
