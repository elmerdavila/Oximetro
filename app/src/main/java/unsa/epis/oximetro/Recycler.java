package unsa.epis.oximetro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

        import android.app.Activity;
        import android.os.Bundle;
        import android.util.Log;


        import androidx.annotation.Nullable;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

public class Recycler extends AppCompatActivity {

    public static ArrayList<Evaluation> listEvaluations;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = (RecyclerView) findViewById(R.id.recycleroximeter);
        ConectionHttp conectionHttp=new ConectionHttp(recyclerView,this);
        listEvaluations= new ArrayList<Evaluation>();
        conectionHttp.getMyResults(this);


        if(recyclerView==null){
            Log.d("testing","El objeto recycler view es null");
        }
//        recyclerView.setHasFixedSize(true);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
