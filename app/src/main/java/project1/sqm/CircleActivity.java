package project1.sqm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CircleActivity extends AppCompatActivity {

    EditText radius;
    TextView areaOutput;
    Button calculate;
    double pi,area;
    //initialise variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
    }

    // On click of close button, returns to main activity
    public void closeClick(View v) {
        finish();
    }


    public void calcClick (View v) {

        radius = (EditText) findViewById(R.id.radInput);
        areaOutput = (TextView) findViewById(R.id.outputField);
        //get reference to text boxes

        pi = 3.14;
        String rad = radius.getText().toString();
        //gets the string from the text box

        if(isDouble(rad))
        //checks to see if the input can be parsed to a double
        {
            Log.d("works", "yes");
            double r = Double.parseDouble(rad);
            if(r < 0 || r>999999)
            {
                areaOutput.setText("error");
            }
            else
            {
                calcCircle(r);
                areaOutput.setText(Double.toString(area));
            }
            //checks the input values are between 0 and 999999

        }
        else
        {
            Log.d("works", "no");
            areaOutput.setText("error");
            //if input isn't a double, display error message
        }
    }

    public double calcCircle(double r)
    {
        area = 3.14 * (r * r);
        return area;
        //method to perform the calculation
    }

    public boolean isDouble(String str) {
        //method tries to parse the string from the text box to a double, if it is possible
        //it returns the boolean 'true' and if not the error is caught and false is retuned
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}