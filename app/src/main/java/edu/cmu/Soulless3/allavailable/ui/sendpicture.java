package edu.cmu.Soulless3.allavailable.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.cmu.nsompura.allavailable.R;

/**
 * Created by anna on 4/4/16.
 */
public class sendpicture extends Activity {
    Button ret;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_sendpicture);
        ret=(Button)findViewById(R.id.btn15);

        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent("android.intent.action.SELECTION");
                startActivity(myintent);
            }
        });
    }
}
