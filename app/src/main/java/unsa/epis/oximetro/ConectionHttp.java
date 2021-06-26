package unsa.epis.oximetro;

import android.content.Context;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConectionHttp {

    private static final String IP = "198.65.45.15";
    private String Puerto="80";
    private String user="user";
    private String password="pass";
    private Connection connection = null;

    private ArrayList<Evaluation> listEvaluations;
    private int lastEvaluation;
    private Context MyresultContext;
    public ConectionHttp(Context context){
        this.MyresultContext=context;
    }

    public Connection connectionBD(){

        String urlMySQL = "jdbc:mysql://" + IP + ":" + Puerto + "/";
        String nameBD="Tienda";

        if(connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(urlMySQL+nameBD,user,password);

                /*Comprobamos que la conexión se ha establecido.*/
                if(!connection.isClosed())
                {
                    Toast.makeText(MyresultContext,"Conexión Establecida", Toast.LENGTH_LONG).show();
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return connection;
        }

        return connection;

    }

    public ArrayList<Evaluation> getMyResults() {

        /*StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_MySql,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            listEvaluations=new ArrayList<Evaluation>();

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject data = array.getJSONObject(i);

                                listEvaluations.add(new Evaluation(
                                        Integer.parseInt(data.getString("Oxigenacion")),
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

        return listEvaluations;*/
        return null;

    }

    public int lastMeasure(){

        return 0;
    }


}