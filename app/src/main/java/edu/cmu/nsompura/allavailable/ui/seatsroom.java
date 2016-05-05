package edu.cmu.nsompura.allavailable.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import edu.cmu.nsompura.allavailable.R;
import edu.cmu.nsompura.allavailable.models.building;
import edu.cmu.nsompura.allavailable.models.room;
import edu.cmu.nsompura.allavailable.models.studyroom;

/**
 * Created by anna on 5/2/16.
 */
public class seatsroom extends Activity {
    Spinner spinner;
    Button btn;
    String doubledValue="0";String GLG="0";int flag=1;int buildingNumber;String uname1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        buildingNumber= extras.getInt("Building_Number");
        uname1=extras.getString("uname");
        building bldg=new building(23);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_seat);
        spinner = (Spinner) findViewById(R.id.spinner_ui_seat);
        btn=(Button)findViewById(R.id.book_ui_seat);
        ArrayList<studyroom> rooms1=new ArrayList<studyroom>();
        rooms1.clear();
        rooms1.addAll(bldg.rooms1);
        ArrayList<String> roomNames=new ArrayList<String>();
        for(int i=0;i<rooms1.size();i++)
        {
            roomNames.add(bldg.rooms1.get(i).getRoomName());
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, roomNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               Thread thread = new Thread(new Runnable() {
//                    private login parent;
//
//                    @Override
//                    public void run() {
//
//                        try {
//                            URL url = new URL("http://172.29.92.114:8080/ServerForAllAvaliable/AllAvaliableServer");
//                            Log.i("URL", "URL");
//                            URLConnection connection = url.openConnection();
//                            Log.i("Connection", "Connection");
//                            GLG = spinner.getSelectedItem().toString();
//                            String inputString = "studyroomstatus:" + GLG;
//                            Log.i("InputString", inputString);
//                            connection.setDoOutput(true);
//                            Log.i("Connection.setDooutput", "Connection.setdooutput");
//                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
//                            Log.i("osw", "osw");
//                            out.write(inputString);
//                            out.close();
//                            Log.i("out.close", "out.close");
//                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
//                            Log.i("isr", "isr");
//                            BufferedReader buff = new BufferedReader(in);
//                            Log.i("buff", "buff");
//                            String returnString = "";
//                            doubledValue="";
//                            while ((returnString = buff.readLine()) != null) {
//                                doubledValue =doubledValue+ returnString;
//                            }
//                            Log.i("DoubledValue", doubledValue);
//                            in.close();
//                            buff.close();
//
//                        } catch (Exception e) {
//                            Log.d("Exception", e.toString());
//                        }
//
//                    }
//                });
                        Intent myIntent = new Intent(seatsroom.this, seatsbook.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", spinner.getSelectedItem().toString());
//                        myIntent.putExtra("seatstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        startActivity(myIntent);
                Log.i("OUT", "OUT");
            }
        });




    }
}
