package sceinox.atragmx;



public class Weapon {
    public final float BORE_HEIGHT= (float) 3.81;
    private float bw;
    private float c1;
    private float mv;
    private float zr;

    public Weapon(float bw, float c1, float mv, float zr) {
        this.bw = bw;
        this.c1 = c1;
        this.mv = mv;
        this.zr = zr;
    }


    public float getBw() {
        return bw;
    }

    public float getC1() {
        return c1;
    }

    public float getMv() {
        return mv;
    }

    public float getZr() {
        return zr;
    }
}
