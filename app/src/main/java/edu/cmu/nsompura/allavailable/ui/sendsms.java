package edu.cmu.nsompura.allavailable.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import edu.cmu.nsompura.allavailable.R;

/**
 * Created by anna on 4/4/16.
 */
public class sendsms extends Activity{
    Button btn15,btn16;
    EditText et1,et2;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_sendsms);
        btn15=(Button)findViewById(R.id.btn15);
        btn16=(Button)findViewById(R.id.btn16);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);


        //Return logic
        btn15.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent myintent = new Intent("android.intent.action.SELECTION");
                startActivity(myintent);
            }});




        //Send SMS logic
        btn16.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String smsNumber = et1.getText().toString();
                String smsText = et2.getText().toString();
                //create array list
                List<String> numbers = new ArrayList<String>();
                //split smsNumber by comma
                StringTokenizer st1 = new StringTokenizer(smsNumber, ",");
                //assign arraylist elements to sms numbers
                while (st1.hasMoreTokens()) {
                    numbers.add(st1.nextToken());
                }
                //start SMS Manager
                SmsManager smsManager = SmsManager.getDefault();
                Log.i("size", numbers.size()+"");
                //send SMS to all the participants in the meeting
                for(int i=0;i<numbers.size();i++) {
                    smsManager.sendTextMessage(numbers.get(i), null, smsText, null, null);
                    Log.i("mesage sent to",numbers.get(i)+"");
                }
                //Notification that message has been sent
                Toast.makeText(getApplicationContext(), "The message has been sent", Toast.LENGTH_LONG).show();
            }});

    }
}
