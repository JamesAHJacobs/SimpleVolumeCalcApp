package project1.sqm;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.view.animation.Transformation;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by James on 20/11/2017.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {

        mainActivity = mainActivityTestRule.getActivity();

    }

    @Test
    public void lauchActivityTest()
    {
        View view = mainActivity.findViewById(R.id.textView);

        assertNotNull(view);
    }

    @Test
    public void testTriangleLaunch()
    {
        assertNotNull(mainActivity.findViewById(R.id.button6));

        onView(withId(R.id.button6)).perform(click());

        Activity TriangleActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 1000);

        assertNotNull(TriangleActivity);

        TriangleActivity.finish();
    }

    @Test
    public void testSquareLaunch()
    {
        assertNotNull(mainActivity.findViewById(R.id.squareButton));

        onView(withId(R.id.squareButton)).perform(click());

        Activity SquareActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 1000);

        assertNotNull(SquareActivity);

        SquareActivity.finish();
    }

    @Test
    public void testCircleLaunch()
    {
        assertNotNull(mainActivity.findViewById(R.id.circleButton));

        onView(withId(R.id.circleButton)).perform(click());

        Activity CircleActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 1000);

        assertNotNull(CircleActivity);

        CircleActivity.finish();
    }


    @After
    public void tearDown() throws Exception {

        mainActivity = null;

    }

}