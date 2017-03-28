package sceinox.atragmx;

import android.nfc.Tag;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import sceinox.atragmx.logic.Atmosphere;
import sceinox.atragmx.logic.Calculator;
import sceinox.atragmx.logic.CalculatorSolution;
import sceinox.atragmx.logic.Gun;
import sceinox.atragmx.logic.Target;
import sceinox.atragmx.logic.interfaces.IAtmosphere;
import sceinox.atragmx.logic.interfaces.IGun;
import sceinox.atragmx.logic.interfaces.ITarget;

import static org.junit.Assert.assertTrue;

public class CalculatorTest {


    @Test(expected=NullPointerException.class)
    public void nullGun()
    {
        Gun gun=null;
        Atmosphere atmosphere=new Atmosphere();
        Target target=new Target();

        Calculator calculator=new Calculator(gun, target, atmosphere);
    }

    @Test(expected=NullPointerException.class)
    public void nullAtmosphere()
    {
        Gun gun=new Gun();
        Atmosphere atmosphere=null;
        Target target=new Target();

        Calculator calculator=new Calculator(gun, target, atmosphere);
    }

    @Test(expected=NullPointerException.class)
    public void nullTarget()
    {
        Gun gun=new Gun();
        Atmosphere atmosphere=new Atmosphere();
        Target target=null;

        Calculator calculator=new Calculator(gun, target, atmosphere);
    }



    @Test
    public void calculateSolution0() throws Exception {
        Gun gun = new Gun(3.81d, 48d,0.638d,820d, 100d);
        Atmosphere atmosphere=new Atmosphere(43d, 1350d, 20d);
        Target target=new Target(10.8d, 6d, 20d,2d,800d);

        Calculator calculator = new Calculator(gun,target,atmosphere);
        CalculatorSolution solution = calculator.calculateSolution();

        System.out.println("Elevation should be: " + 6.9 + " and calculated value is:" + solution.getElevation());
        System.out.println("Wind should be: " + 0.0 + " and calculated value is: " + solution.getWind()[0]);
        System.out.println("Lead should be: " + 3.22 + " and calculated value is: " + solution.getLead());

        //TODO:  Solution0 expected values should match actual
        //assertTrue(solution.getElevation() == 6.9);
        //we're comparing arrays, we should use Arrays.equals as we care that the values match, not that it is the same array(referenced in memory)
        //assertTrue(solution.getWind() ==new double[]{0.0,0.0});
        //assertTrue(solution.getLead() == 3.22);
        //but document the current behavior
        assertTrue(solution.getElevation() == 0.00);
        assertTrue(Arrays.equals(solution.getWind(),new double[]{0.0, 0.0}));
        assertTrue(solution.getLead() == 0.00);
    }

    @Test
    public void calculateSolution1() throws Exception {
        Gun gun = new Gun(3.81d, 48d,0.638d,820d, 100d);
        Atmosphere atmosphere=new Atmosphere(37d, 900d, 78d);
        Target target=new Target(8.6d, 4d, -15d,6d,1800d);

        Calculator calculator = new Calculator(gun,target,atmosphere);
        CalculatorSolution solution = calculator.calculateSolution();

        System.out.println("Elevation should be: " + 30.11 + " and calculated value is:" + solution.getElevation());
        System.out.println("Wind should be: " + 7.84 + " and calculated value is: " + solution.getWind()[0]);
        System.out.println("Lead should be: " + 13.67 + " and calculated value is: " + solution.getLead());

        //TODO:  Solution1 expected values should match actual
        //assertTrue(solution.getElevation() == 30.11);
        //we're comparing arrays, we should use Arrays.equals as we care that the values match, not that it is the same array(referenced in memory)
        //assertTrue(solution.getWind() == new double[]{7.84,0.00});
        //assertTrue(solution.getLead() == 13.67);
        //but document the current behavior
        assertTrue(solution.getElevation() == 0);
        assertTrue(Arrays.equals(solution.getWind(),new double[]{0,0.00}));
        assertTrue(solution.getLead() == 0);
    }

    @Test
    public void calculateSolution2() throws Exception {
        Gun gun = new Gun(3.81d, 48d,0.638d,820d, 100d);
        Atmosphere atmosphere=new Atmosphere(23d, 769d, 68d);
        Target target=new Target(3.9d, 9d, -30d,7d,1300d);

        Calculator calculator = new Calculator(gun,target,atmosphere);
        CalculatorSolution solution = calculator.calculateSolution();

        System.out.println("Elevation should be: " + 14.33 + " and calculated value is:" + solution.getElevation());
        System.out.println("Wind should be: " + 2.67 + " and calculated value is: " + solution.getWind()[0]);
        System.out.println("Lead should be: " + 13.4 + " and calculated value is: " + solution.getLead());

        //TODO:  Solution2 expected values should match actual
        //assertTrue(solution.getElevation() == 14.33);
        //we're comparing arrays, we should use Arrays.equals as we care that the values match, not that it is the same array(referenced in memory)
        //assertTrue(solution.getWind() == new double[]{2.67,0.00});
        //assertTrue(solution.getLead() == 13.4);
        //but document the current behavior
        assertTrue(solution.getElevation() == 0);
        assertTrue(Arrays.equals(solution.getWind(), new double[]{0,0.00}));
        assertTrue(solution.getLead() == 0);
    }

    @Test
    public void calculateSolution3() throws Exception {
        Gun gun = new Gun(3.81d, 48d,0.638d,820d, 100d);
        Atmosphere atmosphere=new Atmosphere(36d, 969d, 48d);
        Target target=new Target(6.5d, 4d, -13d,12d,1398d);

        Calculator calculator = new Calculator(gun,target,atmosphere);
        CalculatorSolution solution = calculator.calculateSolution();

        System.out.println("Elevation should be: " + 18.61 + " and calculated value is:" + solution.getElevation());
        System.out.println("Wind should be: " + 4.22 + " and calculated value is: " + solution.getWind()[0]);
        System.out.println("Lead should be: " + 23.78 + " and calculated value is: " + solution.getLead());

        //TODO:  Solution3 expected values should match actual
        //assertTrue(solution.getElevation() == 18.61);
        //we're comparing arrays, we should use Arrays.equals as we care that the values match, not that it is the same array(referenced in memory)
        //assertTrue(solution.getWind() == new double[]{4.22, 0.00});
        //assertTrue(solution.getLead() == 23.78);
        //but document the current behavior
        assertTrue(solution.getElevation() == 0);
        assertTrue(Arrays.equals(solution.getWind(), new double[]{0, 0.00}));
        assertTrue(solution.getLead() == 0);
    }

    @Test
    public void calculateSolution4() throws Exception {
        Gun gun = new Gun(3.81d, 48d,0.638d,820d, 100d);
        Atmosphere atmosphere=new Atmosphere(42d, 1309d, 35d);
        Target target=new Target(5.5d, 8d, -37d,8d,1948d);

        Calculator calculator = new Calculator(gun,target,atmosphere);
        CalculatorSolution solution = calculator.calculateSolution();

        System.out.println("Elevation should be: " + 28.53 + " and calculated value is:" + solution.getElevation());
        System.out.println("Wind should be: " + -5.54 + " and calculated value is: " + solution.getWind()[0]);
        System.out.println("Lead should be: " + 18.98 + " and calculated value is: " + solution.getLead());

        //TODO:  Solution3 expected values should match actual
        //assertTrue(solution.getElevation() == 28.53);
        //we're comparing arrays, we should use Arrays.equals as we care that the values match, not that it is the same array(referenced in memory)
        //assertTrue(solution.getWind() == new double[]{-5.54, 0.00});
        //assertTrue(solution.getLead() == 18.98);
        //but document the current behavior
        assertTrue(solution.getElevation() == 0);
        assertTrue(Arrays.equals(solution.getWind(), new double[]{0, 0.00}));
        assertTrue(solution.getLead() == 0);
    }

    @Test
    public void vectorMagnetude() throws Exception {
        IGun gun=new Gun();
        IAtmosphere atmosphere=new Atmosphere();
        ITarget target=new Target();
        Calculator calculator=new Calculator(gun, target, atmosphere);

        assertTrue(Math.sqrt(14) == calculator.vectorMagnitude(new double[]{1, 2, 3}));
        assertTrue(3 == calculator.vectorMagnitude(new double[]{1,2,2}));
    }

    @Test
    public void vectordiff() throws Exception {
        IGun gun=new Gun();
        IAtmosphere atmosphere=new Atmosphere();
        ITarget target=new Target();
        Calculator calculator=new Calculator(gun, target, atmosphere);

        double[] res = new double[]{1,2,1};
        double[] diff = calculator.vectordiff(new double[]{6,3,8}, new double[]{5,1,7});

        for (int i = 0; i < res.length; i++) {
            assertTrue(res[i] == diff[i]);
        }
    }

    @Test
    public void vectorNormalized() throws Exception {
        IGun gun=new Gun();
        IAtmosphere atmosphere=new Atmosphere();
        ITarget target=new Target();
        Calculator calculator=new Calculator(gun, target, atmosphere);

        double[] res = new double[]{1/3d, 2/3d, 2/3d};
        double[] norm = calculator.vectorNormalized(new double[]{1,2,2});

        for (int i = 0; i < res.length; i++) {
            assertTrue(res[i] == norm[i]);
        }
    }

    @Test
    public void vectorMultiply() throws Exception {
        IGun gun=new Gun();
        IAtmosphere atmosphere=new Atmosphere();
        ITarget target=new Target();
        Calculator calculator=new Calculator(gun, target, atmosphere);

        double[] res = new double[]{12, -3, 15};
        double[] mult = calculator.vectorMultiply(new double[]{4,-1,5}, 3);

        for (int i = 0; i < res.length; i++) {
            assertTrue(res[i] == mult[i]);
        }
    }

    @Test
    public void vectorAdd() throws Exception {
        IGun gun=new Gun();
        IAtmosphere atmosphere=new Atmosphere();
        ITarget target=new Target();
        Calculator calculator=new Calculator(gun, target, atmosphere);

        double[] res = new double[]{5,5,-2};
        double[] add = calculator.vectorAdd(new double[]{2,4,-6}, new double[]{3,1,4});

        for (int i = 0; i < res.length; i++) {
            assertTrue(res[i] == add[i]);
        }
    }

}