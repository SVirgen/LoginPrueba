package com.example.saul.loginuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.saul.loginuser.PostWebService.Wservice;
import com.example.saul.loginuser.retrofit.ApiUl;
import com.example.saul.loginuser.retrofit.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPassword;
    Button btnLogin;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        user= ApiUl.getUser();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                if (validateLogin(email, password)) {
              reLogin(email , password);

                }
            }
        });

    }
    private boolean validateLogin(String email,String password){
        if (email == null || email.trim().length()==0) {
            Toast.makeText(this,"email is required",Toast.LENGTH_SHORT).show();
            return false;

        }
        if (password == null || password.trim().length()==0) {
            Toast.makeText(this, "password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void reLogin(final String email,final String password){

        Call<Wservice> call =user.login(email,password);
        call.enqueue(new Callback<Wservice>() {
            @Override
            public void onResponse(Call<Wservice> call, Response<Wservice> response) {
                if (response.isSuccessful()){
                    Wservice wservice = response.body();
                    if (wservice.getMessage().equals("true")){

                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        intent.putExtra("email",email);
                        startActivity(intent);

                    }else {
                        Toast.makeText(LoginActivity.this,"The email or password is incorrect",Toast.LENGTH_SHORT).show();

                    }
                }else
                    Toast.makeText(LoginActivity.this,"Error,Please try again", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Wservice> call, Throwable t) {
                Toast.makeText(LoginActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}
