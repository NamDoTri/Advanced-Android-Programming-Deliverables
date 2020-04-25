package com.school.lab3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView image1, image2, image3, image4;
    boolean isDisplayingMammals = true;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = ((ImageView)findViewById(R.id.image_1));
        image2 = ((ImageView)findViewById(R.id.image_2));
        image3 = ((ImageView)findViewById(R.id.image_3));
        image4 = ((ImageView)findViewById(R.id.image_4));

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);

        displayMammals();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
         getMenuInflater().inflate(R.menu.animal_menu, menu);
         return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
         if(item.getItemId() == R.id.mammals){
             displayMammals();
             isDisplayingMammals = true;
         }else{
             displayBirds();
             isDisplayingMammals = false;
         }
         return true;
    }

    @Override
    public void onClick(View view){
         switch (view.getId()){
             case R.id.image_1:
                 MediaPlayer.create(this, isDisplayingMammals ? R.raw.bear_sound : R.raw.huuhkaja_sound).start();
                 break;
             case R.id.image_2:
                 MediaPlayer.create(this, isDisplayingMammals ? R.raw.elephant_sound : R.raw.peippo_sound).start();
                 break;
             case R.id.image_3:
                 MediaPlayer.create(this, isDisplayingMammals ? R.raw.wolf_sound : R.raw.peukaloinen_sound).start();
                 break;
             case R.id.image_4:
                 MediaPlayer.create(this, isDisplayingMammals ? R.raw.lamb_sound : R.raw.punatulkku_sound).start();
                 break;
         }
     }

    private void displayMammals(){
        image1.setImageResource(R.drawable.bear);
        image2.setImageResource(R.drawable.elephant);
        image3.setImageResource(R.drawable.wolf);
        image4.setImageResource(R.drawable.lamb);
    }

    private void displayBirds(){
        image1.setImageResource(R.drawable.huuhkaja);
        image2.setImageResource(R.drawable.peippo);
        image3.setImageResource(R.drawable.peukaloinen);
        image4.setImageResource(R.drawable.punatulkku);
    }
}
