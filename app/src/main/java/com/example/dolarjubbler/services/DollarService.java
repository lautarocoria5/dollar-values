package com.example.dolarjubbler.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dolarjubbler.MySingleton;
import com.example.dolarjubbler.entities.Dollar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DollarService {
    Context ctx;
    public static final String url = "https://www.dolarsi.com/api/api.php?type=valoresprincipales";

    public DollarService(Context ctx) {
        this.ctx = ctx;
    }

    //Interface will return the values to the MainActivity
    public interface ListValuesResponse {
        void onError(String message);

        void onResponse(List<Dollar> dollarList);
    }


    public void listValues(ListValuesResponse listValuesResponse) {
        List<Dollar> dollars = new ArrayList<>();

        JsonArrayRequest req = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(ctx, response.toString(), Toast.LENGTH_SHORT).show();
                            try {

                                for (int i = 0; i < response.length(); i++) {
                                    Dollar d = new Dollar();
                                    JSONObject casa = response.getJSONObject(i).getJSONObject("casa");

                                    if (!(casa.getString("nombre").equals("Bitcoin") || casa.getString("nombre").equals("Argentina") || casa.getString("nombre").equals("Dolar"))) {

                                        d.setAgencia(casa.getString("agencia"));
                                        d.setCompra(casa.getString("compra"));
                                        d.setVenta(casa.getString("venta"));
                                        d.setNombre(casa.getString("nombre"));
                                        d.setDecimales(casa.getString("decimales"));
                                        d.setVariacion(casa.getString("variacion"));
                                        d.setVentaCero(casa.getString("ventaCero"));
                                        dollars.add(d);
                                    }
                                }
                                //Toast.makeText(ctx, dollars.get(5).toString(), Toast.LENGTH_SHORT).show();
                                listValuesResponse.onResponse(dollars);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


//                        try {
//                            JSONArray jsonArray = response.getJSONArray("");
//                            for (int i=0; i< jsonArray.length(); i++) {
//                                JSONObject casa = (JSONObject) jsonArray.get(i);
//                                String nombre = casa.getString("nombre");
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        MySingleton.getInstance(ctx).addToRequestQueue(req);
    }

}
