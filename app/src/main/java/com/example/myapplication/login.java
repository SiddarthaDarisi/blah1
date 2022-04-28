package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText usrname,email,phone,password;
    Button signin,create;
    TextView already;
    FirebaseAuth fauthen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        create=findViewById(R.id.logInFragSignUp);
        email=findViewById(R.id.logInFragUsername);
        password=findViewById(R.id.logInFragPassword);
        signin=findViewById(R.id.logInFragSignIn);
        fauthen= FirebaseAuth.getInstance();
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String remail= email.getText().toString().trim();
                String rpassword= password.getText().toString().trim();
                if(TextUtils.isEmpty(remail)){
                    email.setError("email requried");
                }
                if(TextUtils.isEmpty(rpassword)){
                    password.setError("password requried");
                }
                if(rpassword.length()<6){
                    password.setError("Enter more");
                }
                fauthen.signInWithEmailAndPassword(remail,rpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }

                    }
                });
    }});}}