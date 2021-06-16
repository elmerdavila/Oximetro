package unsa.epis.oximetro;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class StartVitalSigns extends AppCompatActivity {
    private String user;
    private int p;


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

        /*Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = extras.getString("Usr");
            p = extras.getInt("Page");
        }*/

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



    /*@Override
    public void onBackPressed() {
        Intent i = new Intent(unsa.epis.oximetro.StartVitalSigns.this, Primary.class);
        startActivity(i);
        finish();
        super.onBackPressed();
    }*/


}
