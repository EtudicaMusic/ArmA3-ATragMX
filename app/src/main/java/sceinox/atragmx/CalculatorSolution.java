package sceinox.atragmx;

class CalculatorSolution {

    private double elevation;
    private double wind;
    private double lead;

    CalculatorSolution(double elevation, double wind, double lead){
        this.elevation = elevation;
        this.wind = wind;
        this.lead = lead;
    }

    public double getElevation() {
        return elevation;
    }

    public double getWind() {
        return wind;
    }

    public double getLead() {
        return lead;
    }
}
