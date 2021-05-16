package com.example.aplikasiandriod;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.aplikasiandriod.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Kos and move the camera
        LatLng kos = new LatLng(-2.210981, 113.896006);
        mMap.addMarker(new MarkerOptions().position(kos).title("marker ini kos saya"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kos));

        // Add a marker in UPR and move the camera
        LatLng upr = new LatLng(-2.217339, 113.896668);
        mMap.addMarker(new MarkerOptions().position(upr).title("marker in upr"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(upr));

        mMap.addPolyline(new PolylineOptions().add(
                kos,
                new LatLng(-2.210981, 113.896006),
                new LatLng(-2.210830, 113.895895),
                new LatLng(-2.210458, 113.895709),
                new LatLng(-2.210498, 113.894681),
                new LatLng(-2.211956, 113.894611),
                new LatLng(-2.212288, 113.894700),
                new LatLng(-2.213025, 113.895007),
                new LatLng(-2.214321, 113.895653),
                new LatLng(-2.216347, 113.896971),
                new LatLng(-2.216925, 113.897313),
                new LatLng(-2.217339, 113.896668),
                upr
                ).width(10)
                .color(Color.BLUE));
    }
}