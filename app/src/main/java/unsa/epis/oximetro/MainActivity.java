package unsa.epis.oximetro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView reyclerViewUser;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reyclerViewUser = (RecyclerView) findViewById(R.id.reyclerViewUser);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        reyclerViewUser.setHasFixedSize(true);

        // use a linear layout manager
        reyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

        // specify an adapter with the list to show
        mAdapter = new CustomAdapter(getData());
        reyclerViewUser.setAdapter(mAdapter);

    }
    // create fake data for this example
    public List<Evaluation> getData() {

        List<Evaluation>Models = new ArrayList<>();
        Models.add(new Evaluation("95","21-06-21"));
        Models.add(new Evaluation("94","21-06-21"));
        Models.add(new Evaluation("96","21-06-21"));
        Models.add(new Evaluation("94","21-06-21"));
        Models.add(new Evaluation("92","21-06-21"));
        Models.add(new Evaluation("91","21-06-21"));

      //  for(int i = 1; i < 10; i++) {
      //      Models.add(new Item("Name " + i));
      //  }

        return Models;
    }


}