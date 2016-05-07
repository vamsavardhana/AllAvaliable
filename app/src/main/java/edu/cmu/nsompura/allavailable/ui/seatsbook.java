package edu.cmu.nsompura.allavailable.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

import edu.cmu.nsompura.allavailable.R;
import edu.cmu.nsompura.allavailable.models.IPAdress;

/**
 * Created by anna on 5/2/16.
 */
public class seatsbook extends Activity {
    int buildingNumber;
    String uname1;static String timeslot;static String istrue="true";
    int flag = 1;
    String GLG = "0";
    String doubledValue = "0";
    String roomid;
    static String statusstring;
    String uname;
    static String seatstatuses;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16;
    String roomid1;
    IPAdress ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Bundle from previous activity
        Bundle extras = getIntent().getExtras();
        buildingNumber = extras.getInt("Building_Number");
        roomid = extras.getString("roomid");
        //seatstatuses = extras.getString("seatstatuses");
        uname = extras.getString("uname");
        ip = new IPAdress();

        //send query and get response
        Thread thread = new Thread(new Runnable() {
            private login parent;

            @Override
            public void run() {

                try {
                    URL url = new URL(ip.getIp());
                    Log.i("URL", "URL");
                    URLConnection connection = url.openConnection();
                    Log.i("Connection", "Connection");
                    GLG = roomid;
                    String inputString = "studyroomstatus:" + GLG;
                    Log.i("InputString", inputString);
                    connection.setDoOutput(true);
                    Log.i("Connection.setDooutput", "Connection.setdooutput");
                    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                    Log.i("osw", "osw");
                    out.write(inputString);
                    out.close();
                    Log.i("out.close", "out.close");
                    InputStreamReader in = new InputStreamReader(connection.getInputStream());
                    Log.i("isr", "isr");
                    BufferedReader buff = new BufferedReader(in);
                    Log.i("buff", "buff");
                    String returnString = "";
                    doubledValue="";
                    while ((returnString = buff.readLine()) != null) {
                        doubledValue = doubledValue+returnString;
                        Log.i("returnedString", returnString);
                    }
                    Log.i("DoubledValue112", doubledValue);
                    in.close();
                    buff.close();

                } catch (Exception e) {
                    Log.d("Exception", e.toString());
                }

            }
        });
        thread.start();
        while (flag == 1) {
            if (doubledValue.contentEquals("0")) {

            }
            else
            {
                Log.i("BROKEN1234","BROKEN1234");
                break;

            }
        }
        Log.i("INSERT DOUBLED VALUE",doubledValue);

            //Normal stuff
            super.onCreate(savedInstanceState);
            setContentView(R.layout.ui_seatui);

            //16 buttons are there
            btn1 = (Button) findViewById(R.id.ui_seatui_btn1);
            btn2 = (Button) findViewById(R.id.ui_seatui_btn2);
            btn3 = (Button) findViewById(R.id.ui_seatui_btn3);
            btn4 = (Button) findViewById(R.id.ui_seatui_btn4);
            btn5 = (Button) findViewById(R.id.ui_seatui_btn5);
            btn6 = (Button) findViewById(R.id.ui_seatui_btn6);
            btn7 = (Button) findViewById(R.id.ui_seatui_btn7);
            btn8 = (Button) findViewById(R.id.ui_seatui_btn8);
            btn9 = (Button) findViewById(R.id.ui_seatui_btn9);
            btn10 = (Button) findViewById(R.id.ui_seatui_btn10);
            btn11 = (Button) findViewById(R.id.ui_seatui_btn11);
            btn12 = (Button) findViewById(R.id.ui_seatui_btn12);
            btn13 = (Button) findViewById(R.id.ui_seatui_btn13);
            btn14 = (Button) findViewById(R.id.ui_seatui_btn14);
            btn15 = (Button) findViewById(R.id.ui_seatui_btn15);
            btn16 = (Button) findViewById(R.id.ui_seatui_btn16);
//            tv1 = (TextView) findViewById(R.id.ui_seatui_btn1);
//            tv2 = (TextView) findViewById(R.id.ui_seatui_btn2);
//            tv3 = (TextView) findViewById(R.id.ui_seatui_btn3);
//            tv4 = (TextView) findViewById(R.id.ui_seatui_btn4);
//            tv5 = (TextView) findViewById(R.id.ui_seatui_btn5);
//            tv6 = (TextView) findViewById(R.id.ui_seatui_btn6);
//            tv7 = (TextView) findViewById(R.id.ui_seatui_btn7);
//            tv8 = (TextView) findViewById(R.id.ui_seatui_btn8);
//            tv9 = (TextView) findViewById(R.id.ui_seatui_btn9);
//            tv10 = (TextView) findViewById(R.id.ui_seatui_btn10);
//            tv11 = (TextView) findViewById(R.id.ui_seatui_btn11);
//            tv12 = (TextView) findViewById(R.id.ui_seatui_btn12);
//            tv13 = (TextView) findViewById(R.id.ui_seatui_btn13);
//            tv14 = (TextView) findViewById(R.id.ui_seatui_btn14);
//            tv15 = (TextView) findViewById(R.id.ui_seatui_btn15);
//            tv16 = (TextView) findViewById(R.id.ui_seatui_btn16);


            //Split the seat statuses
            String token1 = ":;";
            StringTokenizer st2 = new StringTokenizer(doubledValue, token1);
            String[] arr = new String[54];
            roomid1 = st2.nextToken();
            int j = 0;
            while (st2.hasMoreTokens()) {
                arr[j] = st2.nextToken();
                j = j + 1;
            }
            String jstfrchk="";
            for(int k=0;k<54;k++)
            {
                jstfrchk=jstfrchk+arr[k]+"!!";
            }
            Log.i("STRING ARRAY",jstfrchk);

            //Make buttons disappear if the slot is booked
            if (!arr[2].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn1);
                b.setVisibility(View.INVISIBLE);
//                TextView label_column1= new TextView(this);
//                label_column1.setId(R.id.ui_seatui_btn1);
            }
            if (!arr[4].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn2);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[6].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn3);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[8].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn4);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[11].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn5);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[13].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn6);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[15].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn7);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[17].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn8);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[20].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn9);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[22].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn10);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[24].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn11);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[26].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn12);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[29].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn13);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[31].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn14);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[33].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn15);
                b.setVisibility(View.INVISIBLE);
            }
            if (!arr[35].contains("available")) {
                View b = findViewById(R.id.ui_seatui_btn16);
                b.setVisibility(View.INVISIBLE);
            }


            //what happens when button 1 is pressed
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeslot="timeslot1";
                    Thread thread = new Thread(new Runnable() {
                        private login parent;

                        @Override
                        public void run() {

                            try {
                                URL url = new URL(ip.getIp());
                                Log.i("URL", "URL");
                                URLConnection connection = url.openConnection();
                                Log.i("Connection", "Connection");
                                //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                                GLG = roomid1;
                                String inputString = "bookseat:"+roomid+";"+"1"+";"+timeslot+";"+uname;
                                Log.i("InputString", inputString);
                                connection.setDoOutput(true);
                                Log.i("Connection.setDooutput", "Connection.setdooutput");
                                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                                Log.i("osw", "osw");
                                out.write(inputString);
                                out.close();
                                Log.i("out.close", "out.close");
                                InputStreamReader in = new InputStreamReader(connection.getInputStream());
                                Log.i("isr", "isr");
                                BufferedReader buff = new BufferedReader(in);
                                Log.i("buff", "buff");
                                String returnString = "";
                                String doubledValue1="";
                                while ((returnString = buff.readLine()) != null) {
                                    doubledValue1 = doubledValue1+returnString;
                                }
                                Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                                if(doubledValue1.contentEquals("true"))
                                {
                                    doubledValue=doubledValue1;
                                }
                                else
                                {
                                    doubledValue="0";
                                }
                                Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                                Log.i("DoubledValue114", doubledValue);
                                in.close();
                                buff.close();
                                btn1.setVisibility(View.GONE);

                            } catch (Exception e) {
                                Log.d("Exception", e.toString());
                            }

                        }
                    });
                    thread.start();
                    while (flag == 1) {
                        if (doubledValue != "0") {

                            Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                            Log.i("GLG VALUE IS ", GLG);
                            myIntent.putExtra("timeslot",timeslot);
                            myIntent.putExtra("Building_Number", buildingNumber);
                            myIntent.putExtra("roomid", GLG);
                            myIntent.putExtra("roomstatuses", doubledValue);
                            myIntent.putExtra("uname", uname1);
                            startActivity(myIntent);
                            break;
                        }

                    }
                    Log.i("OUT", "OUT");
                }
            });

        //what happens when button 2 is clicked
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot2";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"1"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn2.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });

        //what happens when button 3 is clicked
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot3";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"1"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn3.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });

        //what happens when button 4 is clicked
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot4";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"1"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn4.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });

        //what happens when button 5 is clicked
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot1";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"2"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn5.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });

        //what happens when button 6 is clicked
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot2";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"2"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn6.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });

        //what happens when button 7 is clicked
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot3";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"2"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn7.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });

        //what happens when button 8 is clicked
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot4";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"2"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn8.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });

//what happens when button 9 is clicked
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot1";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"3"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn9.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });

//what happens when button 10 is clicked
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot2";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"3"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn10.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });
//what happens when button 11 is clicked
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot3";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"3"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn11.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });
//what happens when button 12 is clicked
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot4";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"3"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn12.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });
//what happens when button 4 is clicked
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot1";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"4"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn13.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });
//what happens when button 14 is clicked
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot2";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"4"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn14.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });
//what happens when button 15 is clicked
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot3";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"4"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn15.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });
//what happens when button 16 is clicked
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeslot="timeslot4";
                Thread thread = new Thread(new Runnable() {
                    private login parent;

                    @Override
                    public void run() {

                        try {
                            URL url = new URL(ip.getIp());
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection", "Connection");
                            //bookseat: xxx(roomid);xxx(seatnumber);xxx(timeslot); xxx(uname)
                            GLG = roomid1;
                            String inputString = "bookseat:"+roomid+";"+"4"+";"+timeslot+";"+uname;
                            Log.i("InputString", inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput", "Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw", "osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close", "out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr", "isr");
                            BufferedReader buff = new BufferedReader(in);
                            Log.i("buff", "buff");
                            String returnString = "";
                            String doubledValue1="";
                            while ((returnString = buff.readLine()) != null) {
                                doubledValue1 = doubledValue1+returnString;
                            }
                            Log.i("CHECKING DOUBLEDVALUE1",doubledValue1);
                            if(doubledValue1.contentEquals("true"))
                            {
                                doubledValue=doubledValue1;
                            }
                            else
                            {
                                doubledValue="0";
                            }
                            Log.i("CHECKING DOUBLEDVALUE",doubledValue);
                            Log.i("DoubledValue1141", doubledValue);
                            in.close();
                            buff.close();
                            btn16.setVisibility(View.INVISIBLE);

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                        }

                    }
                });
                thread.start();
                while (flag == 1) {
                    if (doubledValue != "0") {

                        Intent myIntent = new Intent(seatsbook.this, seatnotification.class);
                        Log.i("GLG VALUE IS ", GLG);
                        myIntent.putExtra("Building_Number", buildingNumber);
                        myIntent.putExtra("roomid", GLG);
                        myIntent.putExtra("roomstatuses", doubledValue);
                        myIntent.putExtra("uname", uname1);
                        myIntent.putExtra("timeslot",timeslot);
                        startActivity(myIntent);
                        break;
                    }

                }
                Log.i("OUT", "OUT");
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
        //send query and get response
//        doubledValue = "0";
//        Thread thread = new Thread(new Runnable() {
//            private login parent;
//
//            @Override
//            public void run() {
//
//                try {
//                    URL url = new URL("http://172.29.92.114:8080/ServerForAllAvaliable/AllAvaliableServer");
//                    Log.i("URL", "URL");
//                    URLConnection connection = url.openConnection();
//                    Log.i("Connection", "Connection");
//                    GLG = roomid;
//                    String inputString = "studyroomstatus:" + GLG;
//                    Log.i("InputString", inputString);
//                    connection.setDoOutput(true);
//                    Log.i("Connection.setDooutput", "Connection.setdooutput");
//                    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
//                    Log.i("osw", "osw");
//                    out.write(inputString);
//                    out.close();
//                    Log.i("out.close", "out.close");
//                    InputStreamReader in = new InputStreamReader(connection.getInputStream());
//                    Log.i("isr", "isr");
//                    BufferedReader buff = new BufferedReader(in);
//                    Log.i("buff", "buff");
//                    String returnString = "";
//                    doubledValue="";
//                    while ((returnString = buff.readLine()) != null) {
//                        doubledValue = doubledValue+returnString;
//                    }
//                    Log.i("DoubledValue111", doubledValue);
//                    in.close();
//                    buff.close();
//
//                } catch (Exception e) {
//                    Log.d("Exception", e.toString());
//                }
//
//            }
//        });
//        Log.i("Step","Step1");
//        thread.start();
//        while (flag == 1) {
//            Log.i("Step2","Step2");
//            Log.i("DOUBLEDDOUBLEDVALUE",doubledValue);
//            if (!doubledValue.contains("0")) {
//                Log.i("Step3","Step3");
//                break;
//            }
//        }
//        Log.i("INSERT DOUBLED VALUE",doubledValue);
//        //Split the seat statuses
//        String token1 = ":;";
//        StringTokenizer st2 = new StringTokenizer(doubledValue, token1);
//        String[] arr = new String[54];
//        roomid1 = st2.nextToken();
//        int j = 0;
//        while (st2.hasMoreTokens()) {
//            arr[j] = st2.nextToken();
//            j = j + 1;
//        }
//        String jstfrchk="";
//        for(int k=0;k<54;k++)
//        {
//            jstfrchk=jstfrchk+arr[k]+"!!";
//        }
//        Log.i("STRING ARRAY",jstfrchk);
//
//
//        //16 buttons are there
//        btn1 = (Button) findViewById(R.id.ui_seatui_btn1);
//        btn2 = (Button) findViewById(R.id.ui_seatui_btn2);
//        btn3 = (Button) findViewById(R.id.ui_seatui_btn3);
//        btn4 = (Button) findViewById(R.id.ui_seatui_btn4);
//        btn5 = (Button) findViewById(R.id.ui_seatui_btn5);
//        btn6 = (Button) findViewById(R.id.ui_seatui_btn6);
//        btn7 = (Button) findViewById(R.id.ui_seatui_btn7);
//        btn8 = (Button) findViewById(R.id.ui_seatui_btn8);
//        btn9 = (Button) findViewById(R.id.ui_seatui_btn9);
//        btn10 = (Button) findViewById(R.id.ui_seatui_btn10);
//        btn11 = (Button) findViewById(R.id.ui_seatui_btn11);
//        btn12 = (Button) findViewById(R.id.ui_seatui_btn12);
//        btn13 = (Button) findViewById(R.id.ui_seatui_btn13);
//        btn14 = (Button) findViewById(R.id.ui_seatui_btn14);
//        btn15 = (Button) findViewById(R.id.ui_seatui_btn15);
//        btn16 = (Button) findViewById(R.id.ui_seatui_btn16);
//        super.onResume();
//
//        //Make buttons disappear if the slot is booked
//        if (!arr[2].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn1);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[4].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn2);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[6].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn3);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[8].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn4);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[11].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn5);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[13].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn6);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[15].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn7);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[17].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn8);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[20].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn9);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[22].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn10);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[24].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn11);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[26].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn12);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[29].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn13);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[31].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn14);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[33].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn15);
//            b.setVisibility(View.GONE);
//        }
//        if (!arr[35].contains("available")) {
//            View b = findViewById(R.id.ui_seatui_btn16);
//            b.setVisibility(View.GONE);
//        }
//
    }
}
