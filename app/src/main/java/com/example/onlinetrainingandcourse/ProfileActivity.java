package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private CircleImageView profileimage;
    private TextView profilename, profileemail, profilesupport, profileshare, profileaboutus;
    private ImageView profilebackbtn, profilesettingsbtn, profilesharebtn, profilesupportbtn, profileaboutusbtn, profilelogoutbtn;
    private Button profileeditbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize all variables using findViewById
        profileimage = findViewById(R.id.profileimage);
        profilename = findViewById(R.id.profilename);
        profileemail = findViewById(R.id.profileemail);
        profilebackbtn = findViewById(R.id.profilebackbtn);
        profilesettingsbtn = findViewById(R.id.profilesettingsbtn);
        profileeditbtn = findViewById(R.id.profileeditbtn);
        profilesupport = findViewById(R.id.profilesupport);
        profilesharebtn = findViewById(R.id.profilesharebtn);
        profileshare = findViewById(R.id.profileshare);
        profilesupportbtn = findViewById(R.id.profilesupportbtn);
        profileaboutusbtn = findViewById(R.id.profileaboutusbtn);
        profileaboutus = findViewById(R.id.profileaboutus);
        profilelogoutbtn = findViewById(R.id.profilelogoutbtn);

        //setting up the name and email from shared preferences..

        SharedPreferences preferences = getSharedPreferences("localPref", MODE_PRIVATE);
        String name = preferences.getString("name", "");
        String email = preferences.getString("email", "");

        profilename.setText(name);
        profileemail.setText(email);

        profilebackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        profilesettingsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        profilelogoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, LogInActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });




    }
}