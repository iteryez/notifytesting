package com.example.ajinkya.stayhealthysg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Ajinkya on 11/3/17.
 */

public class Diseases extends AppCompatActivity implements OnMapReadyCallback{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diseases);
        TabHost host=(TabHost) findViewById(R.id.mainTabHost);
        host.setup();

        //Diseases
        TabHost.TabSpec spec = host.newTabSpec("Diseases");
        spec.setContent(R.id.Diseases);
        spec.setIndicator("Diseases");
        host.addTab(spec);

        //SafestRoute
        spec = host.newTabSpec("SafestRoute");
        spec.setContent(R.id.safestRoute);
        spec.setIndicator("SafestRoute");
        host.addTab(spec);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.safestRoute);
        mapFragment.getMapAsync(this);

    }

    public void buttonClick(View view)
    {
        switch(view.getId())
        {
            case R.id.dengueButton:
                Intent intent1 = new Intent(Diseases.this,Dengue.class);
                startActivity(intent1);

                break;

            case R.id.malariaButton:
                Intent intent2 = new Intent(Diseases.this,Malaria.class);
                startActivity(intent2);

                break;

            case R.id.zikaButton:
                Intent intent3 = new Intent(Diseases.this,Zika.class);
                startActivity(intent3);
                break;
        }
    }





    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(1.3521, 103.8198 ), 11.0f));




    }
}

