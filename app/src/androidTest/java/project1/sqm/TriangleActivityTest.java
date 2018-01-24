package project1.sqm;

import android.app.Instrumentation;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by James on 20/11/2017.
 */
public class TriangleActivityTest {

    @Rule
    public ActivityTestRule<TriangleActivity> triangleActivityActivityTestRule = new ActivityTestRule<TriangleActivity>(TriangleActivity.class);

    private TriangleActivity triangleActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);


    private String widthString = "5.5";
    private String heightString = "999999";
    private String area = "2749997.25";

    private String widthStringFail = "-1";
    private String heightStringFail = "999999";
    private String areaFail = "error";

    private String widthStringFail2 = "10";
    private String heightStringFail2 = "0";
    private String areaFail2 = "error";

    private String widthStringFail3 = "1000000";
    private String heightStringFail3 = "h";
    private String areaFail3 = "error";


    @Before
    public void setUp() throws Exception {

        triangleActivity = triangleActivityActivityTestRule.getActivity();

    }

    @Test
    public void testInputPass()
    {
        Espresso.onView(withId(R.id.widthInput)).perform(typeText(widthString));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.heightInput)).perform(typeText(heightString));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.calcButton)).perform(click());
        Espresso.onView(withId(R.id.outputField)).check(matches(withText(area)));

        Espresso.onView(withId(R.id.widthInput)).perform(clearText());
        Espresso.onView(withId(R.id.heightInput)).perform(clearText());
    }

    @Test
    public void testInputFail() {

        Espresso.onView(withId(R.id.widthInput)).perform(typeText(widthStringFail));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.heightInput)).perform(typeText(heightStringFail));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.calcButton)).perform(click());
        Espresso.onView(withId(R.id.outputField)).check(matches(withText(areaFail)));

        Espresso.onView(withId(R.id.outputField)).perform(clearText());

        Espresso.onView(withId(R.id.widthInput)).perform(clearText());
        Espresso.onView(withId(R.id.heightInput)).perform(clearText());

    }

    @Test
    public void testInputFail2() {

        Espresso.onView(withId(R.id.widthInput)).perform(typeText(widthStringFail2));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.heightInput)).perform(typeText(heightStringFail2));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.calcButton)).perform(click());
        Espresso.onView(withId(R.id.outputField)).check(matches(withText(areaFail2)));

        Espresso.onView(withId(R.id.outputField)).perform(clearText());

        Espresso.onView(withId(R.id.widthInput)).perform(clearText());
        Espresso.onView(withId(R.id.heightInput)).perform(clearText());
    }

    @Test
    public void testInputFail3()
    {

        Espresso.onView(withId(R.id.widthInput)).perform(typeText(widthStringFail3));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.heightInput)).perform(typeText(heightStringFail3));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.calcButton)).perform(click());
        Espresso.onView(withId(R.id.outputField)).check(matches(withText(areaFail3)));

    }

    @Test
    public void closeButton()
    {
        assertNotNull(triangleActivity.findViewById(R.id.closeButton));

        onView(withId(R.id.closeButton)).perform(click());

        assertTrue(triangleActivity.isFinishing());

    }

    @After
    public void tearDown() throws Exception {


    }

}