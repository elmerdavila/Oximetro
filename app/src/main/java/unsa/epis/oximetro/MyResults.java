package unsa.epis.oximetro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyResults extends Activity {

    private ArrayList<Evaluation> listEvaluations;
    private RecyclerView recyclerView;

    private static final String URL_MySql = "http://";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        listEvaluations=new ArrayList<>();

        //****************AQUI SE DEBEN COLOCAR LOS DATOS DE MYSQL

        getMyResults();

        //***************************************************

        AdapterData adapterData=new AdapterData(listEvaluations);
        recyclerView.setAdapter(adapterData);
    }

    public void getMyResults() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_MySql,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject data = array.getJSONObject(i);

                                listEvaluations.add(new Evaluation(
                                        data.getInt("Oxigenacion"),
                                        data.getString("Fecha")));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


    }
}
