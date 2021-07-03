package unsa.epis.oximetro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import unsa.epis.oximetro.server.MqttClient;

public class O2Result extends AppCompatActivity {


    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    int O2;
    MqttClient mqttserver= new MqttClient(this);
    private Button my_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o2_result);

        TextView RO2 = this.findViewById(R.id.O2R);
        //ImageButton SO2 = this.findViewById(R.id.SendO2);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            O2 = bundle.getInt("O2R");
            mqttserver.publishOximeterMeasure(""+O2);
            RO2.setText(String.valueOf(O2));
        }

        // AGREGAR EL TEXTO DE RESULTADO DEPENDIENDO DEL NIVEL DE OXIGENACION

        if(O2<60){

        }
        else if(O2>20 && O2 < 40){

        }
        else if(O2 > 40 && O2 < 80){

        }
        else{

        }

        my_result=this.findViewById(R.id.btn_my_results);
        my_result.setOnClickListener(CallbackOnclick);

    }

    View.OnClickListener CallbackOnclick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(O2Result.this, Recycler.class);
            startActivity(i);
        }
    };

    @Override
    public void onBackPressed() {
        Intent i = new Intent(unsa.epis.oximetro.O2Result.this, O2Process.class);
        startActivity(i);
        finish();
        super.onBackPressed();

    }
}
