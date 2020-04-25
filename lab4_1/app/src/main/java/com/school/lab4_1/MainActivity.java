package com.school.lab4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.load_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String url = ((EditText)findViewById(R.id.input_url)).getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                ((TextView)findViewById(R.id.page_preview)).setText(response);
                            }
                        },
                        new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError e){
                                Log.i("test", "Error: " + e.toString());
                                ((TextView)findViewById(R.id.page_preview)).setText("Something is wrong!");
                            }
                        });

                RequestQueue queue = Volley.newRequestQueue(view.getContext());
                queue.add(stringRequest);
            }
        });
    }
}
