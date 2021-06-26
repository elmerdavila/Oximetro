package unsa.epis.oximetro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class O2Result extends AppCompatActivity {

    private String user, Date;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    int O2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o2_result);

        Date = df.format(today);
        TextView RO2 = this.findViewById(R.id.O2R);
        //ImageButton SO2 = this.findViewById(R.id.SendO2);
        ConectionHttp conection=new ConectionHttp();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            O2 = bundle.getInt("O2R");
            O2=new Filters().lowPass(O2,conection.lastMeasure());
            user = bundle.getString("Usr");
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

        // AGREGAR EL ID DEL BOTON CORRESPONDIENTE PARA PASAR A LA INTERFAZ DE RESULTADOS
        /*ImageButton VS = this.findViewById(R.id.imageView3);

        VS.setOnClickListener(v -> {


            Intent i = new Intent(this, MyResults.class);

            startActivity(i);
        });*/

    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(unsa.epis.oximetro.O2Result.this, O2Process.class);
        i.putExtra("Usr", user);
        startActivity(i);
        finish();
        super.onBackPressed();

    }
}
