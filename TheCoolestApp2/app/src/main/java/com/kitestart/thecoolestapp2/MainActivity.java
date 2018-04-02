package com.kitestart.thecoolestapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText emailField, passwordField;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        submitBtn = findViewById(R.id.submitBtn);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });


    }

    void signUp(){
        if( validEmail( emailField.getText().toString() ) ){
            if( validPassword( passwordField.getText().toString() ) ){

                Toast.makeText(this, "Sign up", Toast.LENGTH_SHORT).show();


            }else{
                passwordField.setTextColor(getResources().getColor(R.color.danger));
                passwordField.setLinkTextColor(getResources().getColor(R.color.danger));
            }
        }else{
            emailField.setTextColor(getResources().getColor(R.color.danger));
            emailField.setLinkTextColor(getResources().getColor(R.color.danger));
        }
    }


    boolean validEmail(String email){
        if(email.contains("@") && email.contains(".")){
           return true;
        }
        return false;
    }
    boolean validPassword(String password){
        if(password.length()>6){
            return true;
        }
        return false;
    }




}
