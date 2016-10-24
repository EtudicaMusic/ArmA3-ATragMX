package sceinox.atragmx;



public class FireSolution {
    private float elevationCorr=0;
    private float windCorr=0;
    private float wind2Corr=0;
    private float lead=0;



    public FireSolution(Weapon wep,Atmsphr atm,Target trg) {

    }

    public float getElevationCorr() {
        return elevationCorr;
    }

    public float getWindCorr() {
        return windCorr;
    }

    public float getLead() {
        return lead;
    }

}
