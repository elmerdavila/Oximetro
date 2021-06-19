package unsa.epis.oximetro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyResults extends Activity {

    private ArrayList<String> listData;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        listData=new ArrayList<>();

        //****************AQUI SE DEBEN COLOCAR LOS DATOS DE MYSQL



        //***************************************************

        AdapterData adapterData=new AdapterData(listData);
        recyclerView.setAdapter(adapterData);
    }
}
