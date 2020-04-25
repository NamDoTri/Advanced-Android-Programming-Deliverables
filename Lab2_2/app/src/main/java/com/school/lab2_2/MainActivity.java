package com.school.lab2_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        //input box
        final EditText inputName = new EditText(this);
        inputName.setHint("your name");

        inputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                username = inputName.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // button layout
        LinearLayout btnLayout = new LinearLayout(this);
        Button engBtn = new Button(this);
        Button finBtn = new Button(this);
        Button sweBtn = new Button(this);
        Button surpriseBtn = new Button(this);

        engBtn.setText("English");
        finBtn.setText("Suomeksi");
        sweBtn.setText("Sverige");
        surpriseBtn.setText("Surprise");

        btnLayout.addView(engBtn);
        btnLayout.addView(finBtn);
        btnLayout.addView(sweBtn);
        btnLayout.addView(surpriseBtn);

        //Text view
        final TextView greeting = new TextView(this);
        greeting.setText("Hello " + String.valueOf(username == null ? "" : username));

        //onClick handlers
        engBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                greeting.setText("Hi " + String.valueOf(username == null ? "" : username));
            }
        });
        finBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                greeting.setText("Terve " + String.valueOf(username == null ? "" : username));
            }
        });
        sweBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                greeting.setText("Hejjsan " + String.valueOf(username == null ? "" : username));
            }
        });
        surpriseBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                greeting.setText("Hola " + String.valueOf(username == null ? "" : username));
            }
        });

        container.addView(inputName);
        container.addView(btnLayout);
        container.addView(greeting);
        setContentView(container);
    }
}
