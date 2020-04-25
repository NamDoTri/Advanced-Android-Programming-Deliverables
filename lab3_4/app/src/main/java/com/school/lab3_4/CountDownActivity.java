package com.school.lab3_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CountDownActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_down_clock);

        String numberOfSeconds = getIntent().getStringExtra("NUMBER_OF_SECONDS");
        Log.i("test", numberOfSeconds);

        new CountDownTimer(Long.valueOf(numberOfSeconds)*1000, 1000){
            public void onTick(long millisecondsLeft){
                ((TextView)findViewById(R.id.seconds_left)).setText(String.valueOf(millisecondsLeft/1000));
            }

            public void onFinish(){
                //play a sound
            }
        }.start();
    }
}
