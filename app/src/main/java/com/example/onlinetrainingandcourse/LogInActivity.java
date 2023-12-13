package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    EditText email, password;
    CheckBox remme;
    Button loginbtn;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //stays logged in..
        //commented out because of testing purposes..later will be uncommented..

//        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
//        String checkbox = preferences.getString("remember","");
//        if (checkbox.equals("true")){
//
//            Intent intent = new Intent(LogInActivity.this,MainActivity.class);
//            startActivity(intent);
//        }

        email = findViewById(R.id.loginetEmail);
        password = findViewById(R.id.loginetPassword);
        remme = findViewById(R.id.logincheckBox);
        loginbtn = findViewById(R.id.loginbutton);
        signup = findViewById(R.id.loginSignup);

        //if press on signup button..

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String loginemail= email.getText().toString().trim();
               String loginpassword = password.getText().toString().trim();

                SharedPreferences preferences = getSharedPreferences("localPref", MODE_PRIVATE);
                String email = preferences.getString("email", "");
                String password = preferences.getString("password", "");

                if (loginemail.equals(email) && loginpassword.equals(password)){

                    Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                    //stays logged in..

                    if (remme.isChecked()){
                        SharedPreferences preferenceschk = getSharedPreferences("checkbox", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("remember", "true");
                        editor.apply();
                    } else if (!remme.isChecked()) {

                        SharedPreferences preferenceschk = getSharedPreferences("checkbox", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("remember", "false");
                        editor.apply();
                    }



                }else {
                    Toast.makeText(LogInActivity.this, "Please Enter Right email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}