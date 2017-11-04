package com.example.saul.loginuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail= (TextView) findViewById(R.id.txtEmail);

        Bundle Ex = getIntent().getExtras();
        String email;

        if (Ex !=null){
           email=Ex.getString("email");
           txtEmail.setText(email);
        }
    }
}
