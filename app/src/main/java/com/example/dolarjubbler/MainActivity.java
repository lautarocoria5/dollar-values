package com.example.dolarjubbler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dolarjubbler.services.DollarService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button btn_list, btn_history, btn_date;
    ListView listaValores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_list = findViewById(R.id.btn_listValues);
        btn_history = findViewById(R.id.btn_history);
        btn_date = findViewById(R.id.btn_date);
        listaValores = findViewById(R.id.listarValores);
        String url = "https://www.dolarsi.com/api/api.php?type=valoresprincipales";

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DollarService ds = new DollarService(MainActivity.this);
                ds.listValues();
//                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                        Request.Method.GET,
//                        url,
//                        null,
//                        new Response.Listener<JSONObject>() {
//
//                            @Override
//                            public void onResponse(JSONObject response) {
//                                try {
//                                    JSONArray jsonArray = response.getJSONArray("");
//                                    for (int i=0; i< jsonArray.length(); i++) {
//                                        JSONObject casa = (JSONObject) jsonArray.get(i);
//                                        String nombre = casa.getString("nombre");
//                                    }
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        },
//                        new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                error.printStackTrace();
//                            }
//                        });
            }
        });


//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                Request.Method.GET,
//                url,
//                null,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.e("Response: ",response.toString());
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        error.printStackTrace();
//                    }
//                });
    }
}