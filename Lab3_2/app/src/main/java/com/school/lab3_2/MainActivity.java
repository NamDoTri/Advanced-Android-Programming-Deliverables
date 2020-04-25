package com.school.lab3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.map_button).setOnClickListener(this);
        findViewById(R.id.phone_button).setOnClickListener(this);
        findViewById(R.id.web_button).setOnClickListener(this);

        packageManager = getPackageManager();

    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.map_button:
                //64.9997843,25.5105266
                Uri campus = Uri.parse("geo:64.9997843,25.5105266?z=21"); // zoom to the building
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, campus);
                if(packageManager.queryIntentActivities(mapIntent, PackageManager.MATCH_DEFAULT_ONLY).size() > 0){
                    startActivity(mapIntent);
                }
                Log.i("test", "Map button pressed");
                break;
            case R.id.phone_button:
                Uri phoneNumber = Uri.parse("tel:+358 40 1415510");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, phoneNumber);

                Log.i("test", "Call button pressed");
                if(packageManager.queryIntentActivities(callIntent, PackageManager.MATCH_DEFAULT_ONLY).size() > 0){
                    startActivity(callIntent);
                }
                break;
            case R.id.web_button:
                String webUrl = ((EditText)findViewById(R.id.url_input)).getText().toString().trim();
                Uri openWeb = Uri.parse(webUrl);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, openWeb);

                if(packageManager.queryIntentActivities(webIntent, PackageManager.MATCH_DEFAULT_ONLY).size() > 0){
                    startActivity(webIntent);
                }
                Log.i("test", "Web button pressed");
                break;
            default:
                Log.i("test", "Nothing was hit");
                break;
        }
    }
}
