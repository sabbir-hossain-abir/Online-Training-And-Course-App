package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private CircleImageView profileimage;
    private TextView profilename, profileemail, profilesupport, profileshare, profileaboutus;
    private ImageView profilebackbtn, profilesettingsbtn, profilesharebtn, profilesupportbtn, profileaboutusbtn;
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

    }
}