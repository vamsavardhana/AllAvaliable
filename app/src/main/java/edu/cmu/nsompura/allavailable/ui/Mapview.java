package edu.cmu.nsompura.allavailable.ui;

import android.Manifest;
import android.app.Activity;
//import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

import edu.cmu.nsompura.allavailable.MyApp;
import edu.cmu.nsompura.allavailable.R;

/**
 * Created by anna on 4/30/16.
 */
public class Mapview extends Fragment {

    MapView mapView;
    GoogleMap map;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mapviewfragment, container, false);
        Log.i("Inside mapview", "Inside mapview");

        // Gets the MapView from the XML layout and creates it
//        mapView = (MapView) v.findViewById(R.id.mapview1);
//        Log.i("find mapview", "find mapview");
//        mapView.onCreate(savedInstanceState);
//        Log.i("mapview created","mapview created");
//        // Gets to GoogleMap from the MapView and does initialization stuff
//        map = mapView.getMap();
//        Log.i("gets map", "gets map");
//        map.getUiSettings().setMyLocationButtonEnabled(false);
        Log.i("disableslocationenbtn","disableslocationenbtn");
        if (ActivityCompat.checkSelfPermission(MyApp.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MyApp.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        }
        Log.i("sets location enable","sets location enable");
      //  map.setMyLocationEnabled(true);

        Log.i("initializes map","initializes map");
        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        try {
            MapsInitializer.initialize(this.getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("newcameraupdate","newcameraupdate");
        // Updates the location and zoom of the MapView
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(37.4109937,-122.0604528), 18);
        Log.i("animatecamera","animatecamera");
      //  map.animateCamera(cameraUpdate);

        return v;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

}