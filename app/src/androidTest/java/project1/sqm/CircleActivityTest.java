package project1.sqm;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.widget.Button;

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
public class CircleActivityTest {

    @Rule
    public ActivityTestRule<CircleActivity> circleActivityTestRule = new ActivityTestRule<CircleActivity>(CircleActivity.class);

    private CircleActivity circleActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

    /////////////////////////////////////////////////////////////////////////////////////////////////
    //inputs to be tested and expected results
    private String radiusString = "1";
    private String area = "3.14";

    private String radiusString2 = "60.6.8";
    private String area2 = "error";
    /////////////////////////////////////////////////////////////////////////////////////////////////

    @Before
    public void setUp() throws Exception {

        circleActivity = circleActivityTestRule.getActivity();

    }

    @Test
    public void testInputPass()
    {
        //these inputs are ones that should pass the tests

        Espresso.onView(withId(R.id.radInput)).perform(typeText(radiusString));
        //this line types the specified string from above into the radInput box
        Espresso.closeSoftKeyboard();
        //this line closes the soft keyboard (not essential)
        Espresso.onView(withId(R.id.calcButton)).perform(click());
        //this line of code above performs the button click for the calculation
        Espresso.onView(withId(R.id.outputField)).check(matches(withText(area)));
        //this line of code checks that the output diplayed in the output field
        //matches with the expected output string after the calculation

        Espresso.onView(withId(R.id.outputField)).perform(clearText());
        //this line of code clears the text from the output field so you can
        //easily see when it's changed and that the calculation and code works
        //properly or you may be testing a previous result

        Espresso.onView(withId(R.id.radInput)).perform(clearText());
        //this code clears the input box just for clarity
    }

    @Test
    public void testInputFail()
    {
        //code is essentially the same as the code above but we are performing negative
        //testing, expecting an error to occur and that is the expected output.
        Espresso.onView(withId(R.id.radInput)).perform(typeText(radiusString2));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.calcButton)).perform(click());
        Espresso.onView(withId(R.id.outputField)).check(matches(withText(area2)));
    }

    @Test
    public void closeButton()
    {
        //code to test the close button works

        assertNotNull(circleActivity.findViewById(R.id.CloseButton));
        //checks that there is a close button in the view with the ID
        //'closeButton'

        onView(withId(R.id.CloseButton)).perform(click());
        //performs a click of the button

        assertTrue(circleActivity.isFinishing());
        //checks to see whether the current activity goes to the finishing state and ends

    }


    @After
    public void tearDown() throws Exception {

        circleActivity = null;
    }

}