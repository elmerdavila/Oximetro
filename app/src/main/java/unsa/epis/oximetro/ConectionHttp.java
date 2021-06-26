package unsa.epis.oximetro;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConectionHttp {

    private static final String URL_MySql = "http://";

    private ArrayList<Evaluation> listEvaluations;
    private int lastEvaluation;

    public ConectionHttp(){}

    public ArrayList<Evaluation> getMyResults() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_MySql,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            listEvaluations=new ArrayList<Evaluation>();

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

        return listEvaluations;

    }

    public int lastMeasure() {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_MySql,

                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            JSONObject data = array.getJSONObject(array.length());
                            lastEvaluation = data.getInt("Oxigenacion");


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
        return lastEvaluation;
    }

}
