package UnitTests;

import org.testng.annotations.Test;

import sceinox.atragmx.Calculator;

public class Calculator_Test {

    @Test
    public void calculateSolution1() throws Exception {
        double gunBoreHeight = 0;
        double gunBulletWeight = 0;
        double gunBallisticCoefficient = 0;
        double gunMuzzleVelocity = 0;
        double gunZeroRange = 0;

        double atmsphrTemperature = 0;
        double atmsphrBarometricPressure = 0;
        double atmsphrRelativeHumidity = 0;

        double targetWindStrength = 0;
        double targetWindDirection = 0;
        double targetInclinationAngle = 0;
        double targetTargetSpeed = 0;
        double targetTargetRange = 0;

        double res = 0;

        Calculator calculator = new Calculator(gunBoreHeight, gunBulletWeight, gunBallisticCoefficient, gunMuzzleVelocity, gunZeroRange,
        atmsphrTemperature, atmsphrBarometricPressure, atmsphrRelativeHumidity,
        targetWindStrength, targetWindDirection, targetInclinationAngle, targetTargetSpeed, targetTargetRange);

        assert 0 == calculator.calculateSolution();
    }

    @Test
    public void calculateSolution2() throws Exception {

    }

    @Test
    public void calculateSolution3() throws Exception {

    }

    @Test
    public void calculateSolution4() throws Exception {

    }

    @Test
    public void calculateSolution5() throws Exception {

    }

    @Test
    public void calculateSolution6() throws Exception {

    }

    @Test
    public void calculateSolution7() throws Exception {

    }

    @Test
    public void calculateSolution8() throws Exception {

    }

    @Test
    public void calculateSolution9() throws Exception {

    }
}
