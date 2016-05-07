package edu.cmu.nsompura.allavailable.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class login extends AppCompatActivity {
    EditText username, password;boolean flag=true;
    Button login,signup;
    static String usern;
    String user_name;
    String pass_word;
    static String doubledValue="0";
    String passw;
//    static String doubledValue="";
//    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
//    static final LatLng KIEL = new LatLng(53.551, 9.993);
//    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_login);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
        username=(EditText)findViewById(R.id.uname);
        password=(EditText)findViewById(R.id.pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usern = username.getText().toString();
                passw = password.getText().toString();
                doubledValue="";
                Log.i("in", "in");
                Thread thread = new Thread(new Runnable()
                {
                    private login parent;
                    @Override
                    public void run()
                    {

                try{
                    URL url = new URL("http://172.29.92.36:8080/ServerForAllAvaliable/AllAvaliableServer");
                    Log.i("URL","URL");
                    URLConnection connection = url.openConnection();
                    Log.i("Connection","Connection");

                    String inputString="login:uname:"+usern+";pword:"+passw;
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
                    Log.i("USERN",usern);
                    while ((returnString = buff.readLine()) != null)
                    {
                        doubledValue= returnString;
                    }
                    Log.i("DoubledValue", doubledValue);
                    in.close();
                    buff.close();
//                    if(doubledValue.contains("ufalse"))
//                    {
//                        Toast.makeText(getApplicationContext(),"The username and password are wrong",Toast.LENGTH_SHORT);
//                    }
//                    else if (doubledValue.contains("ptrue"))
//                    {
//                        Intent myIntent = new Intent("android.intent.action.SIGNUP");
//                        startActivity(myIntent);
//                    }
//                    else
//                    {
//                        Log.i("NOT WORKING","NOT WORKING");
//                    }

                }catch(Exception e)
                {
                    Log.d("Exception",e.toString());
                }
                }});thread.start();

                Log.i("OUT","OUT");
                while(flag==true)
                {
                if(doubledValue.contains("ufalse"))
                {
                    Log.i("inside ufalse", "inside ufalse");
                    Toast.makeText(getApplicationContext(),"No such username exists in the data base Please sign up!!",Toast.LENGTH_SHORT).show();
                    break;
                }
                else if (doubledValue.contains("ptrue"))
                {
                        Log.i("inside ptrue","inside ptrue");
                    Log.i("username",usern);
                    Intent myIntent = new Intent(login.this,selection.class);

                    myIntent.putExtra("uname", usern);
                    startActivity(myIntent);
                        break;
                }
                else if(doubledValue.contains("pfalse"))
                {
                    Log.i("inside pfalse","inside pfalse");
                    Toast.makeText(getApplicationContext(),"The password is incorrect. Login again!!",Toast.LENGTH_SHORT).show();
                    break;
                }
                else if(usern.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please enter the username!",Toast.LENGTH_SHORT).show();
                    break;
                }
                else if(passw.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter the password!",Toast.LENGTH_SHORT).show();
                    break;
                }
                }
            }});


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("OUT", "OUT");
                Intent myIntent = new Intent("android.intent.action.SIGNUP");
                startActivity(myIntent);

            }
        });
    }
}
