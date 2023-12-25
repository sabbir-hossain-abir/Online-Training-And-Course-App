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

        SharedPreferences preferences = getSharedPreferences("checkbox2", MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");
        if (checkbox.equals("true")){

            Intent intent = new Intent(LogInActivity.this,Home.class);
            startActivity(intent);
        }

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

//        loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//               String loginemail= email.getText().toString().trim();
//               String loginpassword = password.getText().toString().trim();
//
//                SharedPreferences preferences = getSharedPreferences("localPref", MODE_PRIVATE);
//                String email = preferences.getString("email", "");
//                String password = preferences.getString("password", "");
//
//                if (loginemail.equals(email) && loginpassword.equals(password)){
//
//                    Intent intent = new Intent(LogInActivity.this, Home.class);
//                    startActivity(intent);
//                    finish();
//
//                    //stays logged in..
//
//                    if (remme.isChecked()){
//                        SharedPreferences preferenceschk = getSharedPreferences("checkbox2", MODE_PRIVATE);
//                        SharedPreferences.Editor editor = preferences.edit();
//                        editor.putString("remember", "true");
//                        editor.apply();
//                    } else if (!remme.isChecked()) {
//
//                        SharedPreferences preferenceschk = getSharedPreferences("checkbox2", MODE_PRIVATE);
//                        SharedPreferences.Editor editor = preferences.edit();
//                        editor.putString("remember", "false");
//                        editor.apply();
//                    }
//
//
//
//                }else {
//                    Toast.makeText(LogInActivity.this, "Please Enter Right email or password", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String loginemail = email.getText().toString().trim();
                String loginpassword = password.getText().toString().trim();

                if (isValidInput(loginemail, loginpassword)) {
                    SharedPreferences preferences = getSharedPreferences("localPref", MODE_PRIVATE);
                    String storedEmail = preferences.getString("email", "");
                    String storedPassword = preferences.getString("password", "");

                    if (loginemail.equals(storedEmail) && loginpassword.equals(storedPassword)) {

                        Intent intent = new Intent(LogInActivity.this, Home.class);
                        startActivity(intent);
                        finish();

                        // Stays logged in..
                        if (remme.isChecked()) {
                            SharedPreferences preferenceschk = getSharedPreferences("checkbox2", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferenceschk.edit();
                            editor.putString("remember", "true");
                            editor.apply();
                        } else {
                            SharedPreferences preferenceschk = getSharedPreferences("checkbox2", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferenceschk.edit();
                            editor.putString("remember", "false");
                            editor.apply();
                        }

                    } else {
                        Toast.makeText(LogInActivity.this, "Please Enter the correct email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    // Function to validate email and password
    private boolean isValidInput(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(LogInActivity.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
            return false;
        }
        // You can add more sophisticated validation if needed
        return true;
    }
}