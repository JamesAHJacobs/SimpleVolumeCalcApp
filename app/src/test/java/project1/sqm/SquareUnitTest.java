package project1.sqm;

/**
 * Created by James on 28/11/2017.
 */
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SquareUnitTest {

    @Test
    public void testPass() throws Exception {
        SquareActivity squareActivity = new SquareActivity();
        double area = squareActivity.calcSquare(5.5,999999);
        assertEquals(5499994.5, area, 0);
    }
    @Test
    public void testFail() throws Exception {
        SquareActivity squareActivity = new SquareActivity();
        double area = squareActivity.calcSquare(3,2);
        assertEquals(1, area, 0);
    }
    @Test
    public void testZeroPass() throws Exception {
        SquareActivity squareActivity = new SquareActivity();
        double area = squareActivity.calcSquare(0,2);
        assertEquals(0, area, 0);
    }

}