package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    EditText name, email, password, confirmPassword, phone;
    CheckBox remme;
    Button signupbtn;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //stays logged in..
        //commented out because of testing purposes..later will be uncommented..

//        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
//        String checkbox = preferences.getString("remember","");
//        if (checkbox.equals("true")){
//
//            Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
//            startActivity(intent);
//        }

        name = findViewById(R.id.signupetName);
        email = findViewById(R.id.signupetEmail);
        password = findViewById(R.id.signupetPassword);
        confirmPassword = findViewById(R.id.signupetReenterPassword);
        phone = findViewById(R.id.signupetPhone);
        remme = findViewById(R.id.signupcheckBox);
        signupbtn = findViewById(R.id.signupbutton);
        login = findViewById(R.id.signupLogin);


        //if press on login button..

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameStr = name.getText().toString().trim();
                String emailStr = email.getText().toString().trim();
                String phoneStr = phone.getText().toString().trim();
                String passwordStr = password.getText().toString().trim();
                String reenterpassStr = confirmPassword.getText().toString().trim();

//                if (isLoginPage == false) {
                    //here we will write the code for signup
                    if (TextUtils.isEmpty(nameStr)) {
                        name.setError("username is must");
                    } else if (TextUtils.isEmpty(emailStr)) {
                        email.setError("email is not filled");
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(emailStr).matches()) {
                        email.setError("email is not valid");
                    } else if (TextUtils.isEmpty(phoneStr)) {
                        phone.setError("phone number is must");
                    } else if (phoneStr.length() < 11) {
                        phone.setError("phone number must be valid");

                    } else if (TextUtils.isEmpty(passwordStr)) {
                        password.setError("password is must");
                    } else if (passwordStr.length() < 8) {

                        password.setError("Password must be at least " + 8 + " characters long.\n");
                    } else if (!passwordStr.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[\\w@$!%*?&]{8,20}$")) {

                        password.setError("Password must contain at least one lowercase letter, one uppercase letter, one number, and one special character.\n");
                    } else if (!passwordStr.equals(reenterpassStr)) {
                        confirmPassword.setError("Password does not match");
                    } else {


                        SharedPreferences localPref = SignUpActivity.this.getSharedPreferences("localPref", MODE_PRIVATE);
                        SharedPreferences.Editor edit = localPref.edit();
                        edit.putString("email", emailStr);
                        edit.putString("name", nameStr);
                        edit.putString("phone", phoneStr);
                        edit.putString("password", passwordStr);
                        edit.putString("re_enterpassword", reenterpassStr);
//
                        edit.apply();

                        Log.d("SharedPreferences", "Saved email: " + email.getText().toString());
                        Log.d("SharedPreferences", "Saved name: " + name.getText().toString());

                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                        //stays logged in..

                        if (remme.isChecked()) {
                            SharedPreferences preferences = SignUpActivity.this.getSharedPreferences("checkbox", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("remember", "true");
                            editor.apply();
                        } else if (!remme.isChecked()) {

                            SharedPreferences preferences = SignUpActivity.this.getSharedPreferences("checkbox", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("remember", "false");
                            editor.apply();
                        }

                    }
//                }

            }
        });
    }
}