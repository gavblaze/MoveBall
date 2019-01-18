package com.gavblaze.android.moveball;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawBallCustomView drawBallCustomView = findViewById(R.id.drawBallView);

        drawBallCustomView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                float xTouchPosition = event.getX();
                float yTouchPosition = event.getY();
                float circleRadius = drawBallCustomView.getmRadius();

                float xCurrentCirclePosition = drawBallCustomView.getmCirclePositionX();
                float yCurrentCirclePosition = drawBallCustomView.getmCirclePositionY();

                // Is touch inside the circle?
                float touchRadius = (float) Math.sqrt(Math.pow(xTouchPosition - xCurrentCirclePosition, 2) + Math.pow(yTouchPosition - yCurrentCirclePosition, 2));

                if (touchRadius < circleRadius) {
                    // TOUCH INSIDE THE CIRCLE!

                    //set the position of the circle to wherever it is moved to
                    drawBallCustomView.setmCirclePositionX(event.getX());
                    drawBallCustomView.setmCirclePositionY(event.getY());

                    drawBallCustomView.setmCircleColor(Color.BLUE);

                    drawBallCustomView.invalidate();

                    return true;
                }
                return false;
            }
        });
    }
}



