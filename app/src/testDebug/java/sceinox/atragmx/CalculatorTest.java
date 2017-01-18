package sceinox.atragmx;

import org.junit.Test;

import sceinox.atragmx.logic.Calculator;
import sceinox.atragmx.logic.CalculatorSolution;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator = new Calculator(0,0,0,0,0,0,0,0,0,0,0,0,0);

    //// TODO: 20.12.2016 Wind2
    @Test
    public void calculateSolution0() throws Exception {
        calculator = new Calculator(3.81, 48, 0.638, 820, 100, 43, 1350, 20, 10.8, 6, 20, 2, 800);
        CalculatorSolution solution = calculator.calculateSolution();

        assertTrue(solution.getElevation() == 6.9);
        assertTrue(solution.getWind() == 0.0);
        assertTrue(solution.getLead() == 3.22);
    }

    @Test
    public void calculateSolution1() throws Exception {
        calculator = new Calculator(3.81, 48, 0.638, 820, 100, 37, 900, 78, 8.6, 4, -15, 6, 1800);
        CalculatorSolution solution = calculator.calculateSolution();

        assertTrue(solution.getElevation() == 30.11);
        assertTrue(solution.getWind() == 7.84);
        assertTrue(solution.getLead() == 13.67);
    }

    @Test
    public void calculateSolution2() throws Exception {
        calculator = new Calculator(3.81, 48, 0.638, 820, 100, 23, 769, 68, 3.9, 9, -30, 7, 1300);
        CalculatorSolution solution = calculator.calculateSolution();

        assertTrue(solution.getElevation() == 14.33);
        assertTrue(solution.getWind() == 2.67);
        assertTrue(solution.getLead() == 13.4);
    }

    @Test
    public void calculateSolution3() throws Exception {
        calculator = new Calculator(3.81, 48, 0.638, 820, 100, 36, 969, 48, 6.5, 4, -13, 12, 1398);
        CalculatorSolution solution = calculator.calculateSolution();

        assertTrue(solution.getElevation() == 18.61);
        assertTrue(solution.getWind() == 4.22);
        assertTrue(solution.getLead() == 23.78);
    }

    @Test
    public void calculateSolution4() throws Exception {
        calculator = new Calculator(3.81, 48, 0.638, 820, 100, 42, 1309, 35, 5.5, 8, -37, 8, 1948);
        CalculatorSolution solution = calculator.calculateSolution();

        assertTrue(solution.getElevation() == 28.53);
        assertTrue(solution.getWind() == -5.54);
        assertTrue(solution.getLead() == 18.98);
    }

    @Test
    public void vectorMagnetude() throws Exception {

        assertTrue(Math.sqrt(14) == calculator.vectorMagnitude(new double[]{1, 2, 3}));
        assertTrue(3 == calculator.vectorMagnitude(new double[]{1,2,2}));
    }

    @Test
    public void vectordiff() throws Exception {
        double[] res = new double[]{1,2,1};
        double[] diff = calculator.vectordiff(new double[]{6,3,8}, new double[]{5,1,7});

        for (int i = 0; i < res.length; i++) {
            assertTrue(res[i] == diff[i]);
        }
    }

    @Test
    public void vectorNormalized() throws Exception {
        double[] res = new double[]{1/3d, 2/3d, 2/3d};
        double[] norm = calculator.vectorNormalized(new double[]{1,2,2});

        for (int i = 0; i < res.length; i++) {
            assertTrue(res[i] == norm[i]);
        }
    }

    @Test
    public void vectorMultiply() throws Exception {
        double[] res = new double[]{12, -3, 15};
        double[] mult = calculator.vectorMultiply(new double[]{4,-1,5}, 3);

        for (int i = 0; i < res.length; i++) {
            assertTrue(res[i] == mult[i]);
        }
    }

    @Test
    public void vectorAdd() throws Exception {
        double[] res = new double[]{5,5,-2};
        double[] add = calculator.vectorAdd(new double[]{2,4,-6}, new double[]{3,1,4});

        for (int i = 0; i < res.length; i++) {
            assertTrue(res[i] == add[i]);
        }
    }

}