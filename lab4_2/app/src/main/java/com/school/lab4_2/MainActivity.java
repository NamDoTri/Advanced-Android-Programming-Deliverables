package com.school.lab4_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String[] STOCKIDS = {"AAPL", "GOOGL", "FB", "NOK"};
    private final String BASEURL ="https://financialmodelingprep.com/api/company/price/";
    private final String queryOption = "?datatype=json";
    //https://financialmodelingprep.com/api/company/price/NOK?datatype=json

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = BASEURL + String.join(",", STOCKIDS) + queryOption;
        final ArrayList<String> stocks = new ArrayList<>();
        Log.i("test","Url: " + url);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            for(String id : STOCKIDS){
                                JSONObject stock = (JSONObject) response.get(id);
                                stocks.add(id + ": " + stock.get("price").toString());
                                Log.i("test", id + ": " + stock.get("price").toString());
                            }
                            Log.i("test", "Stocks: " + stocks.toString());
                            ListView stockList = findViewById(R.id.stock_list);
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, stocks);
                            stockList.setAdapter(adapter);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }
}
