package edu.cmu.nsompura.allavailable.ui;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import edu.cmu.nsompura.allavailable.R;

/**
 * Created by feixu on 4/4/16.
 */
public class roomnotification extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_roomnotification);

        final Button buttonReturn = (Button) findViewById(R.id.returnButton);
        final Button buttonLogout = (Button) findViewById(R.id.logoutButton);
        if(buttonReturn != null && buttonLogout != null){
            buttonReturn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent myIntent = new Intent("android.intent.action.SELECTION");
                    startActivity(myIntent);
                }
            });

            buttonLogout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent myIntent = new Intent(roomnotification.this, login.class);
                    startActivity(myIntent);
                }
            });


        }



    }
}
