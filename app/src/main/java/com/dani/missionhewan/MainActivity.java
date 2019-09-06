package com.dani.missionhewan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<DataHewan> lvhewan;
    private RecyclerView rvHewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvhewan = new ArrayList<>();
        rvHewan = findViewById(R.id.rv_hewan);
        jsonreq();
    }

    private void jsonreq() {
        String JSON_URL = "https://raw.githubusercontent.com/danirahmad/JSON_Hewan/master/Hewan_Karnivora/DataHewan.json";
        JsonArrayRequest req = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        DataHewan data = new DataHewan();
                        data.setName(jsonObject.getString("nama"));
                        data.setPenjelasan(jsonObject.getString("pengertian"));
                        data.setSumber_dari(jsonObject.getString("sumber"));
                        data.setImages(jsonObject.getString("img"));
                        lvhewan.add(data);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(lvhewan);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(req);

    }

    private void setuprecyclerview(List<DataHewan> listhewan) {
        ListHewanAdapter myadapter = new ListHewanAdapter(this, listhewan);
        rvHewan.setLayoutManager(new LinearLayoutManager(this));
        rvHewan.setAdapter(myadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId) {
            case R.id.aboutme:
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
        }
    }
}
