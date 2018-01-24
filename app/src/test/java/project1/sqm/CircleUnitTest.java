package project1.sqm;

/**
 * Created by James on 29/11/2017.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleUnitTest {

    @Test
    public void testPass() throws Exception {
        //cerates a new test which we want to pass

        CircleActivity circleActivity = new CircleActivity();
        //creates an object of the CircleActivity

        double area = circleActivity.calcCircle(2);
        //does a function call to the calculation method and passes in test parameters
        //puts the output of the calculation into the double variable 'area'

        assertEquals((3.14*(2*2)), area, 0);
        //checks to see whether the actual answer to that calculation ((3.14*(2*2))), matches
        //with the variable 'area' which contains the result of the function call. if it
        //does it will pass the test.
    }
    @Test
    public void testFail() throws Exception {
        //this is the same as the test above however we used test inputs that we know will fail the
        //test and we expect that. This proves the test doesn't just return true for any input. This
        //is positive testing
        CircleActivity circleActivity = new CircleActivity();
        double area = circleActivity.calcCircle(2);
        assertEquals(1, area, 0);
    }
    @Test
    public void testZeroPass() throws Exception {
        //another test to discover whether the outputn is 0 when the input is 0
        CircleActivity circleActivity = new CircleActivity();
        double area = circleActivity.calcCircle(0);
        assertEquals(0, area, 0);
    }

}
