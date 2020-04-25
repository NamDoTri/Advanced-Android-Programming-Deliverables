package com.school.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> countries = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_coord);
        final String[] COUNTRIES = new String[] {
                "Afghanistan", "Albania", "Australia", "Andorra"
        };

        final LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        // top buttons
        LinearLayout btnLayout = new LinearLayout(this);

        Button addBtn = new Button(this);
        addBtn.setText("Add");
        btnLayout.addView(addBtn);

        Button editBtn = new Button(this);
        editBtn.setText("Edit");
        btnLayout.addView(editBtn);

        Button removeBtn = new Button(this);
        removeBtn.setText("Remove");
        btnLayout.addView(removeBtn);

        // edit text
        final EditText inputBox = new EditText(this);
        inputBox.setHint("Country name");

        //List View
        countries.addAll(Arrays.asList(COUNTRIES));
        final ListView listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, countries));

        //Event handlers
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String input = inputBox.getText().toString();
                countries.add(input);
                listView.setAdapter(new ArrayAdapter<String>(view.getContext(),
                        android.R.layout.simple_list_item_1, countries));
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String input = inputBox.getText().toString();
                countries.remove(input);
                listView.setAdapter(new ArrayAdapter<String>(view.getContext(),
                        android.R.layout.simple_list_item_1, countries));
            }
        });

        container.addView(btnLayout);
        container.addView(inputBox);
        container.addView(listView);

        setContentView(container);
    }
}
