package edu.cmu.Soulless3.allavailable.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import edu.cmu.nsompura.allavailable.R;

public class login extends AppCompatActivity {
    EditText username, password;
    Button login,signup;
    String user_name;
    String pass_word;

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
               // user_name = username.getText().toString();
               // pass_word = password.getText().toString();

//                Intent myIntent = new Intent("android.intent.action.SELECTION");
//                startActivity(myIntent);

                try{
                    URL url = new URL("http://localhost:8080/ServerForAllAvaliable/AllAvaliableServer");
                    URLConnection connection = url.openConnection();

                    String inputString = username.getText().toString();
                    //inputString = URLEncoder.encode(inputString, "UTF-8");

                    Log.d("username", inputString);

                    connection.setDoOutput(true);
                    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                    out.write(inputString);
                    out.close();

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String returnString="";

                    in.close();

                }catch(Exception e)
                {
                    Log.d("Exception",e.toString());
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent("android.intent.action.SIGNUP");
                startActivity(myIntent);

            }
        });
    }
}
