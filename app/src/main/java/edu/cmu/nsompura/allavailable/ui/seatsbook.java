package edu.cmu.nsompura.allavailable.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

import edu.cmu.nsompura.allavailable.R;

/**
 * Created by anna on 5/2/16.
 */
public class seatsbook extends Activity {
    int buildingNumber;
    String uname1;
    int flag=1;String GLG="0";String doubledValue="0";String seatstatuses;String roomid;

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Normal stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_seatui);

        //Get bundle from previous activity
        Bundle extras = getIntent().getExtras();
        buildingNumber= extras.getInt("Building_Number");
        uname1=extras.getString("uname");
        seatstatuses=extras.getString("seatstatuses");

        //16 buttons are there
        btn1=(Button)findViewById(R.id.ui_seatui_btn1);
        btn2=(Button)findViewById(R.id.ui_seatui_btn2);
        btn3=(Button)findViewById(R.id.ui_seatui_btn3);
        btn4=(Button)findViewById(R.id.ui_seatui_btn4);
        btn5=(Button)findViewById(R.id.ui_seatui_btn5);
        btn6=(Button)findViewById(R.id.ui_seatui_btn6);
        btn7=(Button)findViewById(R.id.ui_seatui_btn7);
        btn8=(Button)findViewById(R.id.ui_seatui_btn8);
        btn9=(Button)findViewById(R.id.ui_seatui_btn9);
        btn10=(Button)findViewById(R.id.ui_seatui_btn10);
        btn11=(Button)findViewById(R.id.ui_seatui_btn11);
        btn12=(Button)findViewById(R.id.ui_seatui_btn12);
        btn13=(Button)findViewById(R.id.ui_seatui_btn13);
        btn14=(Button)findViewById(R.id.ui_seatui_btn14);
        btn15=(Button)findViewById(R.id.ui_seatui_btn15);
        btn16=(Button)findViewById(R.id.ui_seatui_btn16);



        //Split the seat statuses
        String token=":;";
        StringTokenizer st1=new StringTokenizer(seatstatuses,token);
        String[] arr=new String[36];
        roomid=st1.nextToken();
        int i=0;
        while(st1.hasMoreTokens())
        {
            arr[i]=st1.nextToken();
            i=i+1;
        }

        //Make buttons disappear if the slot is booked
        if(!arr[2].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn1);
            b.setVisibility(View.GONE);
        }
        if(!arr[4].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn2);
            b.setVisibility(View.GONE);
        }
        if(!arr[6].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn3);
            b.setVisibility(View.GONE);
        }
        if(!arr[8].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn4);
            b.setVisibility(View.GONE);
        }
        if(!arr[11].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn5);
            b.setVisibility(View.GONE);
        }
        if(!arr[13].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn6);
            b.setVisibility(View.GONE);
        }
        if(!arr[15].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn7);
            b.setVisibility(View.GONE);
        }
        if(!arr[17].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn8);
            b.setVisibility(View.GONE);
        }
        if(!arr[20].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn9);
            b.setVisibility(View.GONE);
        }
        if(!arr[22].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn10);
            b.setVisibility(View.GONE);
        }
        if(!arr[24].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn11);
            b.setVisibility(View.GONE);
        }
        if(!arr[26].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn12);
            b.setVisibility(View.GONE);
        }
        if(!arr[29].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn13);
            b.setVisibility(View.GONE);
        }
        if(!arr[31].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn14);
            b.setVisibility(View.GONE);
        }
        if(!arr[33].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn15);
            b.setVisibility(View.GONE);
        }
        if(!arr[35].contains("available"))
        {
            View b = findViewById(R.id.ui_seatui_btn16);
            b.setVisibility(View.GONE);
        }


        //what happens when button 1 is pressed
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable()
                {
                    private login parent;
                    @Override
                    public void run()
                    {

                        try{
                            URL url = new URL("http://172.29.92.114:8080/ServerForAllAvaliable/AllAvaliableServer");
                            Log.i("URL", "URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection","Connection");
                            GLG=roomid;
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
                            Log.i("DoubledValue",doubledValue);
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

                        Intent myIntent = new Intent(seatsbook.this,seatnotification.class);
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
}
