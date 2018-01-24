package project1.sqm;

/**
 * Created by James on 29/11/2017.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleUnitTest {
    @Test
    public void testPass() throws Exception {
        TriangleActivity triangleActivity = new TriangleActivity();
        double area = triangleActivity.calcTriangle(5.5, 999999);
        assertEquals(2749997.25, area, 0);
    }

    @Test
    public void testFail() throws Exception {
        TriangleActivity triangleActivity = new TriangleActivity();
        double area = triangleActivity.calcTriangle(2, 3);
        assertEquals(2, area, 0);
    }

    @Test
    public void testZeroPass() throws Exception {
        TriangleActivity triangleActivity = new TriangleActivity();
        double area = triangleActivity.calcTriangle(0, 3);
        assertEquals(0, area, 0);
    }
}

