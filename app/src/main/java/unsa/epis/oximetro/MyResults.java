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
    private RecyclerView.Adapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        listEvaluations=new ArrayList<>();

        //****************AQUI SE DEBEN COLOCAR LOS DATOS DE MYSQL

        ConectionHttp conectionHttp=new ConectionHttp();

        listEvaluations=conectionHttp.getMyResults();

        //***************************************************
        recyclerView = (RecyclerView) findViewById(R.id.reyclerViewUser);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter=new CustomAdapter(listEvaluations);
        recyclerView.setAdapter(mAdapter);
    }

}
