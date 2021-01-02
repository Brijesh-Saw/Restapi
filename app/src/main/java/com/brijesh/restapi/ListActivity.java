package com.brijesh.restapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Country> dataList = new ArrayList<>();
    private static String JSON_URL = "https://restcountries.eu/rest/v2/region/asia";
    TextView delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.countryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        extractCountryData();
    }

    private void extractCountryData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Country country = new Country();
                        country.setName(jsonObject.getString("name"));
                        country.setCapital(jsonObject.getString("capital"));
                        country.setRegion(jsonObject.getString("region"));
                        country.setSubregion(jsonObject.getString("subregion"));
                        country.setPopulation(jsonObject.getString("population"));
                        country.setFlag(jsonObject.getString("flag"));
                        country.setBorders(jsonObject.getString("borders"));
//                        country.setLanguages(jsonObject.getJSONObject("language"));
                        dataList.add(country);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                final Adapter adapter = new Adapter();
                adapter.setCountry(getApplicationContext(),dataList);
                recyclerView.setAdapter(adapter);
            }
        }, error -> Log.d("TAG", "onErrorResponse: "+ error.getMessage()));
        queue.add(jsonArrayRequest);
    }
}