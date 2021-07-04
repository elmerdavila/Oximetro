package unsa.epis.oximetro;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import unsa.epis.oximetro.server.MqttClient;

public class StartVitalSigns extends AppCompatActivity {
    private String user;
    private int p;
    private Button my_result;
    MqttClient mqtt;

    //Camera Permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_vital_signs);

        //Checking for camera
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
        //mqtt = new MqttClient(this);
        my_result=this.findViewById(R.id.btn_my_result);
        my_result.setOnClickListener(CallbackOnclick);

        ImageButton VS = this.findViewById(R.id.StartVS);
        VS.setOnClickListener(v -> {

            Intent i = new Intent(this, O2Process.class);
            startActivity(i);

        });
    }

    View.OnClickListener CallbackOnclick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //mqtt.publishOximeterMeasure(""+98);

            Intent i = new Intent(StartVitalSigns.this, Recycler.class);
            startActivity(i);
        }
    };




}
