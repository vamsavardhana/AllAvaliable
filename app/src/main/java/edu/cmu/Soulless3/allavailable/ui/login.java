package edu.cmu.Soulless3.allavailable.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                Intent myIntent = new Intent("android.intent.action.SELECTION");
                startActivity(myIntent);


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
