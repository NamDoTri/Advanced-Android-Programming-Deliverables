package com.school.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        final Button gameButton = new Button(this);
        gameButton.setText("You have pressed " + String.valueOf(counter) + " times.");
        setContentView(gameButton);

        gameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                counter++;
                gameButton.setText("You have pressed " + String.valueOf(counter) + " times.");
            }
        });
    }
}
