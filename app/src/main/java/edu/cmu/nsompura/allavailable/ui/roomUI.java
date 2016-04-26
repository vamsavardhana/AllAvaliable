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

import edu.cmu.nsompura.allavailable.R;
import edu.cmu.nsompura.allavailable.models.building;

/**
 * Created by feixu on 4/4/16.
 */
public class roomUI extends AppCompatActivity {

    building bldg;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_room);

        Bundle extras = getIntent().getExtras();
        int buildingNumber= extras.getInt("Building_Number");
        bldg=new building(buildingNumber);




        TableLayout table = (TableLayout)roomUI.this.findViewById(R.id.table1);
        Log.i("Building room no of ts", bldg.rooms.get(0).ts.length + "");
        int x=20;
        for(int k=0;k<bldg.rooms.get(0).ts.length;k++)
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
            label_column1.setPadding(5, 5, 5, 5);
            tr_head.addView(label_column1);

            TextView label_column2= new TextView(this);
            label_column2.setId(x + 1);
            label_column1.setText(bldg.rooms.get(0).getRoomStatus());
            if(bldg.rooms.get(0).getRoomStatus()=="Room Available") {
                label_column1.setTextColor(Color.GREEN);
            }
            else if(bldg.rooms.get(0).getRoomStatus()=="Room Unavailable") {
                label_column1.setTextColor(Color.RED);
            }
            else{
                label_column1.setTextColor(Color.BLACK);
            }
            label_column2.setTextColor(Color.WHITE);          // part2
                    label_column2.setPadding(5, 5, 5, 5);
                    tr_head.addView(label_column2);
                    Button btn = new Button(this);
                    btn.setText("Test Text");
                    btn.setId(x+2);
                    tr_head.addView(btn);


            


                    x=x+10;
            table.addView(tr_head);
        }
        table.requestLayout();
        }

    }

