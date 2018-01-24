package project1.sqm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class TriangleActivity extends AppCompatActivity {

    EditText width;
    EditText height;
    TextView areaOutput;
    Button calculate;
    double h,w,area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
    }

    public void calcClick(View v) {

        width = (EditText) findViewById(R.id.widthInput);
        height = (EditText) findViewById(R.id.heightInput);
        areaOutput = (TextView) findViewById(R.id.outputField);
        calculate = (Button) findViewById(R.id.calcButton);

        String h1 = height.getText().toString();
        String h2 = width.getText().toString();
        //initialise references and variables

        if(isDouble(h1) && isDouble(h2))
        {
            h = Double.parseDouble(h1);
            w = Double.parseDouble(h2);
            if(h <= 0 || w <= 0 || h > 999999 || w > 999999)
            {
                //tests inputs between bounds
                areaOutput.setText("error");
            }
            else
            {
                calcTriangle(h, w);
                areaOutput.setText(Double.toString(area));
            }

        }
        else
        {
            areaOutput.setText("error");
        }
    }

    public double calcTriangle(double h, double w)
    {
        //calculation method
        area = h * w / 2;
        return area;
    }

    public boolean isDouble(String str) {
        //tests for doubles
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // On click of close button, returns to main activity
    public void closeClick(View v)
    {
        finish();
    }




    double num1,num2,sum;
}