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

import edu.cmu.nsompura.allavailable.models.IPAdress;
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
    int buildingNumber;
    static String doubledValue="0";
    int flag=1;
    static String uname;String uname1;
    IPAdress ip;
    //String uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ip = new IPAdress();
        Bundle extras = getIntent().getExtras();
        buildingNumber= extras.getInt("Building_Number");
        uname1=extras.getString("uname");
        Toast.makeText(getApplicationContext(),uname1, Toast.LENGTH_SHORT).show();
        Log.i("in rooms act bldgno is",buildingNumber+"");
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
                Thread thread = new Thread(new Runnable()
                {
                    private login parent;
                    @Override
                    public void run()
                    {

                        try{
                            URL url = new URL(ip.getIp());
                            Log.i("URL","URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection","Connection");
                            GLG = spinner.getSelectedItem().toString();
                            String inputString="conferenceroomstatus:"+GLG;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput","Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close","out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr","isr");
                            BufferedReader buff=new BufferedReader(in);
                            Log.i("buff","buff");
                            String returnString="";
                            while ((returnString = buff.readLine()) != null)
                            {
                                doubledValue= returnString;
                            }
                            Log.i("DoubledValue1121",doubledValue);
                            in.close();
                            buff.close();

                        }catch(Exception e)
                        {
                            Log.d("Exception",e.toString());
                        }

                    }});thread.start();
                while(flag==1)
                {
                    if(doubledValue!="0")
                    {

                        Intent myIntent = new Intent(rooms.this,roomUI.class);
                        GLG=spinner.getSelectedItem().toString();
                        Log.i("GLG VALUE IS ", GLG);

                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid",GLG);
                        myIntent.putExtra("roomstatuses",doubledValue);
                        myIntent.putExtra("uname",uname1);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT","OUT");}});

    }

    @Override
    protected void onPause() {
        super.onPause();
        }

    @Override
    protected void onResume() {
        GLG=spinner.getSelectedItem().toString();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        Log.i("RESULT CODE",resultCode+"!!"+requestCode);
        if(resultCode==0)
        {
            finish();
        }
        else
        {

        }
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        room = (String)parent.getItemAtPosition(pos);

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
