package edu.cmu.nsompura.allavailable.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import edu.cmu.nsompura.allavailable.models.room;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import edu.cmu.nsompura.allavailable.R;
import edu.cmu.nsompura.allavailable.models.building;

/**
 * Created by nidhish on 4/4/16.
 */
public class rooms extends Activity implements AdapterView.OnItemSelectedListener {
    static String GLG="0000";
    Spinner spinner;
    String room;
    Button book;
    building bldg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        int buildingNumber= extras.getInt("Building_Number");
        bldg=new building(buildingNumber);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_rooms);
        book = (Button) findViewById(R.id.book);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayList<room> rooms1=new ArrayList<room>();
        rooms1.clear();
        rooms1.addAll(bldg.rooms);

        ArrayList<String> roomNames=new ArrayList<String>();
                for(int i=0;i<rooms1.size();i++)
        {
        roomNames.add(bldg.rooms.get(i).getRoomName());
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, roomNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Thread thread = new Thread(new Runnable()
//                {
//                    private login parent;
//                    @Override
//                    public void run()
//                    {

//                        try{
//                            URL url = new URL("http://172.29.92.114:8080/ServerForAllAvaliable/AllAvaliableServer");
//                            Log.i("URL","URL");
//                            URLConnection connection = url.openConnection();
//                            Log.i("Connection","Connection");
//                            String inputString="conferenceroomstatus:"+GLG;
//                            Log.i("InputString",inputString);
//                            connection.setDoOutput(true);
//                            Log.i("Connection.setDooutput","Connection.setdooutput");
//                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
//                            Log.i("osw","osw");
//                            out.write(inputString);
//                            out.close();
//                            Log.i("out.close","out.close");
//                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
//                            Log.i("isr","isr");
//                            BufferedReader buff=new BufferedReader(in);
//                            Log.i("buff","buff");
//                            String returnString="";
//                            String doubledValue="0";
//                            while ((returnString = buff.readLine()) != null)
//                            {
//                                doubledValue= returnString;
//                            }
//                            Log.i("DoubledValue",doubledValue);
//                            in.close();
//                            buff.close();
//                            if(doubledValue.contains("ufalse"))
//                            {
//                                Toast.makeText(getApplicationContext(), "The username and password are wrong", Toast.LENGTH_SHORT);
//                            }
//                            else if (doubledValue.contains("utrue"))
//                            {
//                                Intent myIntent = new Intent("android.intent.action.SIGNUP");
//                                startActivity(myIntent);
//                            }
//                            else
//                            {
//                                Log.i("NOT WORKING","NOT WORKING");
//                            }
//
//                        }catch(Exception e)
//                        {
//                            Log.d("Exception",e.toString());
//                        }
//
//                    }});thread.start();
                Log.i("OUT","OUT");}});


        Intent myIntent = new Intent("android.intent.action.ROOMCONTROLLER");
                myIntent.putExtra("Building_Number",bldg.getBuildingNumber());
                startActivity(myIntent);
            }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        room = (String)parent.getItemAtPosition(pos);
        GLG=room;

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
