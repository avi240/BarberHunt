package com.example.patientdemo;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapView extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    FrameLayout showMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        showMap=findViewById(R.id.showMap);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.showMap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        this.gMap = googleMap;

        LatLng mapIndia = new LatLng(18.55307282572514, 73.87707231164426);
        this.gMap.addMarker(new MarkerOptions().position(mapIndia).title("Prashant Lucky Star Hair Style And Gents Parlour"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapIndia));
    }
}
