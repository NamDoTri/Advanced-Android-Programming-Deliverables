package com.school.lab3_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.start_button){
            int seconds = Integer.valueOf(((EditText)findViewById(R.id.input_seconds)).getText().toString());

            Intent countDownIntent = new Intent(this, CountDownActivity.class);
            countDownIntent.putExtra("NUMBER_OF_SECONDS", String.valueOf(seconds));
            startActivity(countDownIntent);
        }
    }
}
