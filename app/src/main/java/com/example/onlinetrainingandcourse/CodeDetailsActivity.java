package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.reactivex.rxjava3.annotations.NonNull;

public class CodeDetailsActivity extends AppCompatActivity {

    private VideoView courseVideoView;
    private TextView courseNameTextView, courseRatingTextView, courseOfferByTextView, courseDescriptionTextView;
    private Button enrollButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_details);


        // Initialize views
        courseVideoView = findViewById(R.id.coursedetailvideoView);
        courseNameTextView = findViewById(R.id.coursedetailname);
        courseRatingTextView = findViewById(R.id.coursedetailrating);
        courseOfferByTextView = findViewById(R.id.coursedetailoffrby);
        courseDescriptionTextView = findViewById(R.id.coursedetailsdescription);
        enrollButton = findViewById(R.id.coursedetailsenrollbtn);
        ImageButton playButton = findViewById(R.id.playButton);
        ImageButton pauseButton = findViewById(R.id.pauseButton);


        Intent intent = getIntent();

        String coursename = intent.getStringExtra("coursename");
        String description = intent.getStringExtra("description");
        String offerby = intent.getStringExtra("offerby");
        String videourl = intent.getStringExtra("videourl");
        Float rating = intent.getFloatExtra("rating", 0.0f);


        courseNameTextView.setText(coursename);
        courseRatingTextView.setText(String.valueOf(rating));
        courseOfferByTextView.setText(offerby);
        courseDescriptionTextView.setText(description);

        // Load video URL into VideoView
        if (videourl != null && !videourl.isEmpty()) {
            courseVideoView.setVideoPath(videourl);
            courseVideoView.start();
        }


//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("your_database_node");
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    HomeModel homeModel = dataSnapshot.getValue(HomeModel.class);
//
//                    // Now you can access the video URL
//                    String videoUrl = homeModel.getVideourl();
//
//                    // Load the video into your VideoView or handle it as needed
//                    // Note: You need to replace "courseVideoView" with your actual VideoView instance
//                    if (videoUrl != null && !videoUrl.isEmpty()) {
//                        courseVideoView.setVideoPath(videoUrl);
//                        courseVideoView.start();
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Handle errors
//            }
//        });
    }
}