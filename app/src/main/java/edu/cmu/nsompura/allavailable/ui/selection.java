package edu.cmu.nsompura.allavailable.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.PrintWriter;

import edu.cmu.nsompura.allavailable.R;
import edu.cmu.nsompura.allavailable.models.building;

/**
 * Created by nidhish on 4/4/16.
 */
public class selection extends Activity {
    Button broom, btnsms, btnseat, btnmms;
    building bldg;
    TextView bldg1;
    static int bldgno;
    public static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bldg = new building(23);
        super.onCreate(savedInstanceState);

        //Checking if location is building 19 or building 23
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        //Get current location: latitude and longitude
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        float dist=getDistanceInMiles(latitude,longitude);
        Log.i("The distance from", "The distance from " + (int) dist);
        if((int)dist>50)
        {
            bldgno=23;
        }
        else
        {
            bldgno=19;
        }

        //Attach the mapview fragment to selection activity
        Log.i("Fragment created", "Fragment created");
        FragmentManager fragmanager=getFragmentManager();
        FragmentTransaction fragtransaction=fragmanager.beginTransaction();
            Log.i("went in", "Went in");
            Mapview mp2=new Mapview();
            fragtransaction.replace(R.id.fragment1, mp2).addToBackStack("TAG").commit();
            getFragmentManager().dump("", null, new PrintWriter(System.out, true), null);
        Log.i("Fragment finished", "Fragment finished");
        setContentView(R.layout.ui_selection);
        Bundle extras = getIntent().getExtras();
        final String uname1=extras.getString("uname");
        //Tell the user which room he is in
        bldg1 = (TextView)findViewById(R.id.bldg11);
        bldg1.setText("The building you are in is"+bldgno);
        broom = (Button)findViewById(R.id.broom);

        //When the user books a room
        broom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(selection.this,rooms.class);
                Log.i("going from Sto rooms","going from Sto rooms");
                intent.putExtra("Building_Number", bldgno);
                intent.putExtra("uname", uname1);
                //intent.putExtra("");
                startActivity(intent);
            }
        });

        //when the user books a seat
        btnseat = (Button)findViewById(R.id.btnseat);

        btnseat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(selection.this, seats.class);
                startActivity(newIntent);
            }
        });


        //when the user wants to send an sms
        btnsms= (Button)findViewById(R.id.btnsms);

        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(selection.this, sendsms.class);
                startActivity(newIntent);
            }
        });


        //when the user wants to send an mms
        btnmms= (Button)findViewById(R.id.btnmms);
        btnmms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(selection.this, sendpicture.class);
                startActivity(newIntent);
            }
        });
    }


    //calculates distance in mils from latitude and longitude coordinates
    public float getDistanceInMiles(double latitude , double longitude) {
        double lat1 = ((double)37.4109937) / 1e6;
        double lng1 = ((double)-122.0604528) / 1e6;
        double lat2 = (latitude) / 1e6;
        double lng2 = (longitude) / 1e6;
        float [] dist = new float[1];
        Location.distanceBetween(lat1, lng1, lat2, lng2, dist);
        return dist[0] * 0.000621371192f;
    }
}
