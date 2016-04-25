package edu.cmu.nsompura.allavailable.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import edu.cmu.nsompura.allavailable.R;
import edu.cmu.nsompura.allavailable.models.building;

/**
 * Created by nidhish on 4/4/16.
 */
public class selection extends Activity {
    Button broom,btnsms,btnseat,btnmms;
    building bldg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bldg=new building(23);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_selection);
        broom = (Button)findViewById(R.id.broom);

        broom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.B23ROOMS");
                intent.putExtra("Building_Number", bldg.getBuildingNumber());
                startActivity(intent);
            }
        });
        btnseat = (Button)findViewById(R.id.btnseat);

        btnseat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(selection.this, seats.class);
                startActivity(newIntent);
            }
        });
        btnsms= (Button)findViewById(R.id.btnsms);

        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(selection.this, sendsms.class);
                startActivity(newIntent);
            }
        });

        btnmms= (Button)findViewById(R.id.btnmms);
        btnmms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(selection.this, sendpicture.class);
                startActivity(newIntent);
            }
        });
    }
}
