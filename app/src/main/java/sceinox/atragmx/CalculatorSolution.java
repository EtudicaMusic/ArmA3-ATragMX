package sceinox.atragmx;

class CalculatorSolution {

    private double elevation;
    private double wind;
    private double wind2;
    private double lead;

    CalculatorSolution(double elevation, double wind, double wind2, double lead){
        this.elevation = elevation;
        this.wind = wind;
        this.wind2 = wind2;
        this.lead = lead;
    }

    public double getElevation() {
        return elevation;
    }

    public double getWind() {
        return wind;
    }

    public double getWind2() {
        return wind2;
    }

    public double getLead() {
        return lead;
    }
}
