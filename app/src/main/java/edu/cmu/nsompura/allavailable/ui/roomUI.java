package edu.cmu.nsompura.allavailable.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

import edu.cmu.nsompura.allavailable.R;
import edu.cmu.nsompura.allavailable.models.building;

/**
 * Created by feixu on 4/4/16.
 */
public class roomUI extends AppCompatActivity {
    int flag=1;int k;int buildingNumber;
    building bldg;
    static String GLG="0000";
    String getty="0000";
    static String ts="0000";
    String doubledValue = "0000";
    Button btn;

    String uname;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_room);
        Bundle extras = getIntent().getExtras();
        buildingNumber= extras.getInt("Building_Number");
        String roomstatuses=extras.getString("roomstatuses");
        uname=extras.getString("uname");
        String token = ":;";
        StringTokenizer st1 = new StringTokenizer(roomstatuses, token);
        String brkdown[]=new String[8];
        int i=0;
        int roomid=0;
        final String roomidstring= st1.nextToken();
        while(st1.hasMoreTokens())
        {
            brkdown[i]=st1.nextToken();
            Log.i("values are", brkdown[i]+"  "+i+ "done");
            if(brkdown[i]=="avaliable")
            {
                brkdown[i]="Available";
            }
            i=i+1;
        }
        switch(roomidstring)
        {
            case "Room 129A":
                roomid=0;
                break;
            case "Room 129B":
                roomid=1;
                break;
            case "Room 228B":
                roomid=2;
                break;
            case "Room 230B":
                roomid=3;
                break;
            case "Room 231B":
                roomid=4;
                break;
            case "Room 1020":
                roomid=0;
                break;
            case "Room 1021":
                roomid=1;
                break;
            case "Room 1022":
                roomid=2;
                break;
            case "Room 1023":
                roomid=3;
                break;
            case "Room 1024":
                roomid=4;
                break;
            default: break;
        }


        bldg=new building(buildingNumber);
        bldg.rooms.get(roomid).setTS1RoomStatus(brkdown[1]);
        bldg.rooms.get(roomid).setTS2RoomStatus(brkdown[3]);
        bldg.rooms.get(roomid).setTS3RoomStatus(brkdown[5]);
        bldg.rooms.get(roomid).setTS4RoomStatus(brkdown[7]);



        TableLayout table = (TableLayout)roomUI.this.findViewById(R.id.table1);
        Log.i("Building room no of ts", bldg.rooms.get(0).ts.length + "");
        int x=20;
        for(k=0;k<4;k++)
        {
            TableRow tr_head = new TableRow(this);
            tr_head.setId(k);
            tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView label_column1= new TextView(this);
                    label_column1.setId(x + 0);
            if(k==0) {
                label_column1.setText("9:00-10:00");
            }
            else if(k==1)
            {
                label_column1.setText("10:00-11:00");
            }
            else if(k==2)
            {
                label_column1.setText("11:00-12:00");
            }
            else if(k==3)
            {
                label_column1.setText("12:00-1:00");
            }
            else if(k==4)
            {
                label_column1.setText("1:00-2:00");
            }
            else{label_column1.setText("NOT WORKING");}
            label_column1.setTextColor(Color.BLACK);
            label_column1.setPadding(5, 5, 5, 5);
            tr_head.addView(label_column1);

            //Second Column
            TextView label_column2= new TextView(this);
            label_column2.setId(x + 1);
            if(k==0) {

                getty=bldg.rooms.get(roomid).getTS1RoomStatus();
                label_column2.setText(bldg.rooms.get(roomid).getTS1RoomStatus());
                if (bldg.rooms.get(roomid).getRoomStatus() == "Room Available") {
                    label_column2.setTextColor(Color.GREEN);
                } else if (bldg.rooms.get(roomid).getRoomStatus() == "Room Unavailable") {
                    label_column2.setTextColor(Color.RED);
                } else {
                    label_column2.setTextColor(Color.BLACK);
                }
                label_column2.setPadding(5, 5, 5, 5);
                tr_head.addView(label_column2);
            }
            else if(k==1)
            {
                getty=bldg.rooms.get(roomid).getTS2RoomStatus();
                label_column2.setText(bldg.rooms.get(roomid).getTS2RoomStatus());
                if (bldg.rooms.get(roomid).getRoomStatus() == "Room Available") {
                    label_column2.setTextColor(Color.GREEN);
                } else if (bldg.rooms.get(roomid).getRoomStatus() == "Room Unavailable") {
                    label_column2.setTextColor(Color.RED);
                } else {
                    label_column2.setTextColor(Color.BLACK);
                }
                label_column2.setPadding(5, 5, 5, 5);
                tr_head.addView(label_column2);
            }
            else if(k==2)
            {
                getty=bldg.rooms.get(roomid).getTS3RoomStatus();
                label_column2.setText(bldg.rooms.get(roomid).getTS3RoomStatus());
                if (bldg.rooms.get(roomid).getRoomStatus() == "Room Available") {
                    label_column2.setTextColor(Color.GREEN);
                } else if (bldg.rooms.get(roomid).getRoomStatus() == "Room Unavailable") {
                    label_column2.setTextColor(Color.RED);
                } else {
                    label_column2.setTextColor(Color.BLACK);
                }
                label_column2.setPadding(5, 5, 5, 5);
                tr_head.addView(label_column2);
            }
            else if(k==3)
            {
                getty=bldg.rooms.get(roomid).getTS4RoomStatus();
                label_column2.setText(bldg.rooms.get(roomid).getTS4RoomStatus());
                if (bldg.rooms.get(roomid).getRoomStatus() == "Room Available") {
                    label_column2.setTextColor(Color.GREEN);
                } else if (bldg.rooms.get(roomid).getRoomStatus() == "Room Unavailable") {
                    label_column2.setTextColor(Color.RED);
                } else {
                    label_column2.setTextColor(Color.BLACK);
                }
                label_column2.setPadding(5, 5, 5, 5);
                tr_head.addView(label_column2);
            }
            else
            {
                Log.i("STUFF NOT WORKING","STUFF NOT WORKING");
            }


            //Third column
            Log.i("LABEL2COLUMN STATUS","!!"+label_column2.getText()+"!!"+getty+"!!");
                    if(getty.contains("available")) {
                        Log.i("Here lies a button", "Here lies a button");
                        btn = new Button(this);
                        btn.setText("Book now!!");
                        Log.i("Set button text", "Set button text");
                        btn.setId(x + 2);
                        Log.i("Add button to view", "Add button to view");
                        tr_head.addView(btn);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("BTN.getId", btn.getId() + "!!" + v.getId());
                    if((int) v.getId()==22)
                    {
                        ts="timeslot1";
                    }
                    else if((int) v.getId()==32)
                    {
                        ts="timeslot2";
                    }
                    else if((int) v.getId()==42)
                    {
                        ts="timeslot3";
                    }
                    else if((int) v.getId()==52)
                    {
                        ts="timeslot4";
                    }
                    else{

                    }
                    Thread thread = new Thread(new Runnable() {
                        private login parent;

                        @Override
                        public void run() {

                            try {
                                URL url = new URL("http://172.29.92.114:8080/ServerForAllAvaliable/AllAvaliableServer");
                                Log.i("URL", "URL");
                                URLConnection connection = url.openConnection();
                                Log.i("Connection", "Connection");
                                GLG = "129a";//bookroom: xxx(roomid);xxx( timeslot);xxx(uname
                                String inputString = "bookroom:" + roomidstring+";"+ts+";"+uname;
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
                                while ((returnString = buff.readLine()) != null) {
                                    doubledValue = returnString;
                                }
                                Log.i("DoubledValue", doubledValue);
                                in.close();
                                buff.close();

                            } catch (Exception e) {
                                Log.d("Exception", e.toString());
                            }

                        }
                    });
                    thread.start();
                    while(flag==1)
                    {
                        if(doubledValue.contains("true"))
                        {
                            Intent myIntent = new Intent(roomUI.this,roomnotification.class);
                            myIntent.putExtra("Building_Number", buildingNumber);
                            myIntent.putExtra("roomid",roomidstring);
                            myIntent.putExtra("roomstatuses",doubledValue);
                            myIntent.putExtra("uname",uname);
                            myIntent.putExtra("timeslot",ts);
                            startActivity(myIntent);
                            break;
                        }
                        else if(doubledValue.contains("false"))
                        {
                            Toast.makeText(getApplicationContext(),"The room cannot be booked currently", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else
                        {
                        }
                    }

                }
            });}
            else
            {
                        TextView label_column3= new TextView(this);
                        label_column2.setId(x + 1);
                        Log.i("Third column WORK", "Third column WORK");
            }

            x=x+10;
            table.addView(tr_head);
        }
        table.requestLayout();
        }

    }

