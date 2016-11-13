package sceinox.atragmx;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator = new Calculator(0d,0d,0d,0d,0d,0d,0d,0d,0d,0d,0d,0d,0d);

    @Test
    public void calculateSolution0() throws Exception {
        assertTrue(false);
    }

    @Test
    public void calculateSolution1() throws Exception {
        assertTrue(false);
    }

    @Test
    public void calculateSolution2() throws Exception {
        assertTrue(false);
    }

    @Test
    public void calculateSolution3() throws Exception {
        assertTrue(false);
    }

    @Test
    public void calculateSolution4() throws Exception {
        assertTrue(false);
    }

    @Test
    public void calculateSolution5() throws Exception {
        assertTrue(false);
    }

    @Test
    public void calculateSolution6() throws Exception {
        assertTrue(false);
    }

    @Test
    public void calculateSolution7() throws Exception {
        assertTrue(false);
    }

    @Test
    public void calculateSolution8() throws Exception {
        assertTrue(false);
    }

    @Test
    public void calculateSolution9() throws Exception {
        assertTrue(false);
    }

    @Test
    public void vectorMagnetude() throws Exception {

        assertTrue(Math.sqrt(14) == calculator.vectorMagnetude(new double[]{1, 2, 3}));
        assertTrue(3 == calculator.vectorMagnetude(new double[]{1,2,2}));
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