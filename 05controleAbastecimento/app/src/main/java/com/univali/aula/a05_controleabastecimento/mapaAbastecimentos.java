package com.univali.aula.a05_controleabastecimento;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class mapaAbastecimentos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_abastecimentos);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void onResume() {
        super.onResume();
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng nav;
     //   try {
            ArrayList<abastecimento> lista = abastecimentoDao.getLista(this.getApplicationContext());
            int i = 0;
            while (i<lista.size()) {
                nav = new LatLng(lista.get(i).getLat(), lista.get(i).getLongi());
                mMap.addMarker(new MarkerOptions().position(nav).title("Posto " + lista.get(i).getPosto() + " data: " + lista.get(i).getData() +
                      " Km: " + lista.get(i).getKm() + " Litros: "  + lista.get(i).getLitro()));
                i++;
            }
      //  } catch (Exception e) {

      //  }
    }
}
