package joeadyz.pe.academia.controller;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Celeritech Peru on 08/08/2015.
 */
public class MapaFragment extends SupportMapFragment{


    @Override
    public void onResume() {
        super.onResume();

        LatLng local = new LatLng(23.4555453556, 11.145315551);

        this.centrarMapa(local);
    }

    private void centrarMapa(LatLng local) {
        GoogleMap mapa = this.getMap();
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 17));
    }
}
