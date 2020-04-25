package com.school.lab3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.color_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        TextView textView = findViewById(R.id.display_color);
        switch (item.getItemId()){
            case R.id.red:
                textView.setText("Red");
                textView.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                textView.setText("Green");
                textView.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                textView.setText("Blue");
                textView.setBackgroundColor(Color.BLUE);
                break;
            case R.id.yellow:
                textView.setText("Yellow");
                textView.setBackgroundColor(Color.YELLOW);
                break;
            default: break;
        }
        return true;
    }
}
