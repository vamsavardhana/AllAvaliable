package edu.cmu.Soulless3.allavailable.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import edu.cmu.nsompura.allavailable.R;

/**
 * Created by feixu on 4/4/16.
 */
public class room extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_room);

        final Button button1 = (Button) findViewById(R.id.buttonTitle13);
        final Button button2 = (Button) findViewById(R.id.buttonTitle23);
        final Button button3 = (Button) findViewById(R.id.buttonTitle33);

        if(button1 != null && button2 != null && button3 != null){
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent myIntent = new Intent("android.intent.action.NOTIFICATION");
                    startActivity(myIntent);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent myIntent = new Intent("android.intent.action.NOTIFICATION");
                    startActivity(myIntent);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent myIntent = new Intent("android.intent.action.NOTIFICATION");
                    startActivity(myIntent);
                }
            });

        }

    }
}
