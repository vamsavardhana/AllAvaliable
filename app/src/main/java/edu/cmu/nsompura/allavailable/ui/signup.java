package edu.cmu.nsompura.allavailable.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import edu.cmu.nsompura.allavailable.R;
import edu.cmu.nsompura.allavailable.models.IPAdress;

/**
 * Created by nidhish on 4/4/16.
 */
public class signup extends Activity {
    Button signup;
    EditText username,password;
    String usern;
    String passw;
    IPAdress ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_signup);
        username = (EditText)findViewById(R.id.uName);
        password= (EditText)findViewById(R.id.pWord);
        signup = (Button)findViewById(R.id.signup2);
        ip = new IPAdress();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("in", "in");
                usern = username.getText().toString();
                passw = password.getText().toString();
                Thread thread = new Thread(new Runnable()
                {
                    private login parent;
                    @Override
                    public void run()
                    {

                        try{
                            Log.i("username",username.getText().toString()+"");
                            URL url = new URL(ip.getIp());
                            Log.i("URL","URL");
                            URLConnection connection = url.openConnection();
                            Log.i("Connection","Connection");

                            String inputString="signup:uname:"+usern+";pword:"+passw;
                            Log.i("InputString",inputString);
                            connection.setDoOutput(true);
                            Log.i("Connection.setDooutput","Connection.setdooutput");
                            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                            Log.i("osw","osw");
                            out.write(inputString);
                            out.close();
                            Log.i("out.close","out.close");
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            Log.i("isr","isr");
                            BufferedReader buff=new BufferedReader(in);
                            Log.i("buff","buff");
                            String returnString="";
                            String doubledValue="0";
                            while ((returnString = buff.readLine()) != null)
                            {
                                doubledValue= returnString;
                            }
                            Log.i("DoubledValue",doubledValue);
                            in.close();
                            buff.close();
                            if(doubledValue.contains("ufalse"))
                            {
                                Toast.makeText(getApplicationContext(), "The username and password are wrong", Toast.LENGTH_SHORT);
                            }
                            else if (doubledValue.contains("utrue"))
                            {
                                Intent myIntent = new Intent("android.intent.action.SIGNUP");
                                startActivity(myIntent);
                            }
                            else
                            {
                                Log.i("NOT WORKING","NOT WORKING");
                            }

                        }catch(Exception e)
                        {
                            Log.d("Exception",e.toString());
                        }

                    }});thread.start();


                Intent intent = new Intent(signup.this,login.class);
                startActivity(intent);

            }
        });
    }
}
