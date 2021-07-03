package unsa.epis.oximetro;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyResults extends Activity {

    private ArrayList<Evaluation> listEvaluations;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ConectionHttp conectionHttp=new ConectionHttp();
        conectionHttp.getMyResults(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycleroximeter);
        mAdapter=new CustomAdapter(listEvaluations);
        if(recyclerView==null){
            Log.d("testing","El objeto recycler view es null");
        }
//        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(mAdapter);
    }

}
