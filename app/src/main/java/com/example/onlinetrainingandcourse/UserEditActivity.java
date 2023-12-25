package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserEditActivity extends AppCompatActivity {

    private CircleImageView profileImage;
    private CircleImageView cameraIcon;
    private EditText nameEditText;
    private EditText phoneEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);

        // Initialize variables with findViewById
        profileImage = findViewById(R.id.usereditprofileimage);
        cameraIcon = findViewById(R.id.usereditcameraicon);
        nameEditText = findViewById(R.id.usereditnameet);
        phoneEditText = findViewById(R.id.usereditphoneet);
        saveButton = findViewById(R.id.usereditsavebtn);
    }
}