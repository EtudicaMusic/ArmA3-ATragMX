package sceinox.atragmx.logic;

public class CalculatorSolution {

    private double elevation;
    private double[] wind;
    private double lead;
    private double TOF;
    private double bulletSpeed;
    private double kineticEnergy;
    private double verticalCoriolis;
    private double horizontalCoriolis;
    private double spinDrift;

    public CalculatorSolution(double elevation, double[] wind, double lead, double TOF, double bulletSpeed, double kineticEnergy, double verticalCoriolis, double horizontalCoriolis, double spinDrift) {
        this.elevation = elevation;
        this.wind = wind;
        this.lead = lead;
        this.TOF = TOF;
        this.bulletSpeed = bulletSpeed;
        this.kineticEnergy = kineticEnergy;
        this.verticalCoriolis = verticalCoriolis;
        this.horizontalCoriolis = horizontalCoriolis;
        this.spinDrift = spinDrift;
    }

    public double getElevation() {
        return elevation;
    }

    public double[] getWind() {
        return wind;
    }

    public double getLead() {
        return lead;
    }

    public double getTOF() {
        return TOF;
    }

    public double getBulletSpeed() {
        return bulletSpeed;
    }

    public double getKineticEnergy() {
        return kineticEnergy;
    }

    public double getVerticalCoriolis() {
        return verticalCoriolis;
    }

    public double getHorizontalCoriolis() {
        return horizontalCoriolis;
    }

    public double getSpinDrift() {
        return spinDrift;
    }
}
