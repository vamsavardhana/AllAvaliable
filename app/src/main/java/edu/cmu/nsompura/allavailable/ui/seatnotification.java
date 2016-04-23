package edu.cmu.nsompura.allavailable.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.cmu.nsompura.allavailable.R;

/**
 * Created by anna on 4/4/16.
 */
public class seatnotification extends Activity{
    Button ret,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_seatnotification);
        ret=(Button)findViewById(R.id.btn13);
        logout=(Button)findViewById(R.id.btn14);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent("android.intent.action.SELECTION");
                startActivity(myintent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(seatnotification.this, login.class);
                startActivity(myIntent);
            }
        });
    }
}
