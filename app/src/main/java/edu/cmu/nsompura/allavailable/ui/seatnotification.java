package edu.cmu.nsompura.allavailable.ui;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import edu.cmu.nsompura.allavailable.R;

/**
 * Created by feixu on 4/4/16.
 */
public class seatnotification extends AppCompatActivity {
    String text;
    TextView bookroom;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        int buildingNumber= extras.getInt("Building_Number");
        String uname1=extras.getString("uname");
        String room=extras.getString("roomid");
//        String timeslot = "";
//        String room = "";
        String timeslot=extras.getString("timeslot");
        Toast.makeText(getApplicationContext(),timeslot, Toast.LENGTH_SHORT).show();
        Log.i("PUTEXTRA1",timeslot+"!!");
        Log.i("PUTEXTRA1",uname1+"!!");
        Log.i("PUTEXTRA1",buildingNumber+"!!");
        Log.i("PUTEXTRA1",room+"!!");

        setContentView(R.layout.ui_seatnotification);
        TextView date=(TextView)findViewById(R.id.bookingTime2);
        bookroom=(TextView)findViewById(R.id.bookingTime1);
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        String dater = df.format(Calendar.getInstance().getTime());
        Log.i("Currentdate and time", dater);
        //date.setText("Date:"+dater);
        if(timeslot.contains("timeslot1"))
        {
            text="9:00 to 10:00";
        }
        else if(timeslot.contains("timeslot2"))
        {
            text="10:00 to 11:00";
        }
        else if(timeslot.contains("timeslot3"))
        {
            text="11:00 to 12:00";
        }
        else if(timeslot.contains("timeslot4"))
        {
            text="12:00 to 1:00";
        }
        else
        {
            Log.i("NOT WOKRING", "NOT WOKRING");
        }
        Log.i("The notification: ", room+text);
        bookroom.setText("You have successfully booked the room"+room+" for the timeslot "+text);
        final Button buttonReturn = (Button) findViewById(R.id.returnButton);
        final Button buttonLogout = (Button) findViewById(R.id.logoutButton2);

//        if(buttonReturn != null && buttonLogout != null){

//        buttonReturn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent myIntent = new Intent(roomnotification.this, selection.class);
//                startActivity(myIntent);
//            }
//        });
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(seatnotification.this, login.class);
                startActivity(myIntent);
            }
        });
//        }
    }
}
