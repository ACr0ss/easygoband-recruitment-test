package com.cross.easygoband_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.cross.easygoband_test.pojo.Ticket;
import com.cross.easygoband_test.utils.VolleySingleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
    }

    private void setView() {
        searchBar = findViewById(R.id.searchbar);
        searchBar.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    searchId();
                    return true;
                }
                return false;
            }
        });
    }

    private void searchId() {
        String url = "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/" + searchBar.getText().toString().trim();
        Intent i = new Intent(MainActivity.this, ResultActivity.class);
        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("M/d/yy hh:mm a");
        Gson gson = gsonBuilder.create();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<Ticket> tickets = Arrays.asList(gsonBuilder.create().fromJson(response.toString(), Ticket[].class));
                        i.putExtra("data", (Serializable) tickets);
                        startActivity(i);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Basic cJmAc71jah17sgqi1jqaksvaksda=");
                return params;
            }
        };
        VolleySingleton.getInstance(MainActivity.this).addToRequestQueue(jsonArrayRequest);
    }


}