package unsa.epis.oximetro;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class StartVitalSigns extends AppCompatActivity {
    private String user;
    private int p;
    private Button my_result;


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

        /*Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = extras.getString("Usr");
            p = extras.getInt("Page");
        }*/

        my_result=this.findViewById(R.id.btn_my_result);
        my_result.setOnClickListener(CallbackOnclick);

        ImageButton VS = this.findViewById(R.id.StartVS);

        VS.setOnClickListener(v -> {

            //switch is to decide which activity must be opened
            /*switch (p) {

                case 1: {
                    Intent i = new Intent(v.getContext(), O2Process.class);
                    i.putExtra("Usr", user);
                    startActivity(i);
                    finish();
                }
                break;*/

            Intent i = new Intent(this, O2Process.class);

            startActivity(i);

        });
    }

    View.OnClickListener CallbackOnclick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(StartVitalSigns.this, Recycler.class);
            startActivity(i);
        }
    };




}
