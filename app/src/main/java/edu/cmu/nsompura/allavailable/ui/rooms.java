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
import edu.cmu.nsompura.allavailable.models.room;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.nsompura.allavailable.R;
import edu.cmu.nsompura.allavailable.models.building;

/**
 * Created by nidhish on 4/4/16.
 */
public class rooms extends Activity implements AdapterView.OnItemSelectedListener {
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
        Log.i("Roomsize",rooms1.size()+"");
        Log.i("Roomname",bldg.rooms.get(0).getRoomName());
        Log.i("Roomname",bldg.rooms.get(1).getRoomName());
        Log.i("Roomname",bldg.rooms.get(2).getRoomName());

        for(int i=0;i<rooms1.size();i++)
        {
        roomNames.add(bldg.rooms.get(i).getRoomName());
            Log.i("Roomdetail", bldg.rooms.get(i).getRoomName());
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, roomNames);



//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, R.layout.spinner);
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the  to the spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
       // spinner.setOnItemSelectedListener(this);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent("android.intent.action.ROOMCONTROLLER");
                startActivity(myIntent);
            }
        });


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
