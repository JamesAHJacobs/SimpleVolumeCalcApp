package project1.sqm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void squareClick(View v) {
        //sends the user to a new activity when the button is clicked
        Intent squareIntent = new Intent(MainActivity.this,
                SquareActivity.class);
        startActivityForResult(squareIntent, 1);

    }

    public void circleClick(View v) {
        Intent circleIntent = new Intent(MainActivity.this,
                CircleActivity.class);
        startActivityForResult(circleIntent, 2);

    }

    public void triangleClick(View v) {
        Intent triangleIntent = new Intent(MainActivity.this,
                TriangleActivity.class);
        startActivityForResult(triangleIntent, 3);

    }

}