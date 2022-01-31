package com.example.authenticationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    private EditText editTextTextPersonName4;
    private EditText editTextTextPersonName6;
    private EditText editTextTextPassword;
    private  EditText editTextTextPersonName13;
    private  EditText editTextTextPersonName17;
    private  EditText editTextTextPersonName19;
    private  EditText editTextTextPersonName22;
    private Button button3;
    private FirebaseAuth firebaseauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName6 = findViewById(R.id.editTextTextPersonName6);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextTextPersonName13 = findViewById(R.id.editTextTextPersonName13);
        editTextTextPersonName17 = findViewById(R.id.editTextTextPersonName17);
        editTextTextPersonName19 = findViewById(R.id.editTextTextPersonName19);
        editTextTextPersonName22 = findViewById(R.id.editTextTextPersonName22);
        firebaseauth = FirebaseAuth.getInstance();
        button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextTextPersonName4.getText().toString();
                String roll = editTextTextPersonName6.getText().toString();
                int roll_no = Integer.parseInt(roll);

                String password=editTextTextPassword.getText().toString();
                String branch = editTextTextPersonName13.getText().toString();
                String year = editTextTextPersonName17.getText().toString();
                int y = Integer.parseInt(year);
                String add = editTextTextPersonName19.getText().toString();
                String email = editTextTextPersonName22.getText().toString();
                int phone=Integer.parseInt(email);
                if (name.length() != 0 && roll.length() !=0&& password.length() != 0 && branch.length() != 0 && year.length() != 0 && add.length() != 0 && email.length() != 0 ) {
                    Toast.makeText(MainActivity.this, "All credentials valid", Toast.LENGTH_SHORT).show();

                    registerUser(email, password);

                    Intent intent =new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "Registration Failed.Please Enter all the credentials", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    private void registerUser(String email, String password) {
     firebaseauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {
             if(task.isSuccessful()){
                 Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
             }else {
                 Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
              }

         }
     });
    }



    }
