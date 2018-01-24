package project1.sqm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SquareActivity extends AppCompatActivity {

    EditText width;
    EditText height;
    TextView areaOutput;
    Button calculate;
    double h,w,area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
    }

    // On click of close button, returns to main activity
    public void closeClick(View v)
    {
        finish();
    }

    public void calcClick(View v) {

        width = (EditText) findViewById(R.id.widthInput);
        height = (EditText) findViewById(R.id.heightInput);
        areaOutput = (TextView) findViewById(R.id.outputField);
        calculate = (Button) findViewById(R.id.calcButton);

        String h1 = height.getText().toString();
        String w1 = width.getText().toString();
        //initialises references and variables

            if(isDouble(h1) && isDouble(w1))
            {
                double h = Double.parseDouble(h1);
                double w = Double.parseDouble(w1);
                //tests input are doubles and within the bounds allowed

                if(h <0 || w <0 || h > 999999 || w > 999999)
                {
                    area = -1;
                }
                else
                {
                    calcSquare(h, w);
                }
            }
            else
            {
                area = -1;
            }

            if(area <= 0 )
            {
                areaOutput.setText("error");
            }
            else
            {
                areaOutput.setText(Double.toString(area));
            }

    }

    public double calcSquare(double h, double w)
    {
        //does calculation
        area = h * w;
        return area;
    }

    public boolean isDouble(String str) {
        //tests strings are doubles
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}