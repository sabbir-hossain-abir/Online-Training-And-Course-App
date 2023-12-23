package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private RecyclerView horizontalRecyclerView;
    private LinearLayout HomeAlltopicsbtn, homePopularbtn, homeNewestbtn, homeAdvancebtn;
    private ImageView homefooterpannel, homeHomebtn, homeedubtn, homesrcbtn, homesavebtn, homeprofilebtn;
    private TextView homeSeeAllbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize all variables using findViewById
        horizontalRecyclerView = findViewById(R.id.homeRecycleView);
        HomeAlltopicsbtn = findViewById(R.id.HomeAlltopicsbtn);
        homePopularbtn = findViewById(R.id.homePopularbtn);
        homeNewestbtn = findViewById(R.id.homeNewestbtn);
        homeAdvancebtn = findViewById(R.id.homeAdvancebtn);
        homefooterpannel = findViewById(R.id.homefooterpannel);
        homeHomebtn = findViewById(R.id.homeHomebtn);
        homeedubtn = findViewById(R.id.homeedubtn);
        homesrcbtn = findViewById(R.id.homesrcbtn);
        homesavebtn = findViewById(R.id.homesavebtn);
        homeprofilebtn = findViewById(R.id.homeprofilebtn);
        homeSeeAllbtn = findViewById(R.id.homeSeeAllbtn);


        // Create a LinearLayoutManager with horizontal orientation
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Set the LayoutManager for the RecyclerView
        horizontalRecyclerView.setLayoutManager(layoutManager);

        // Create and set an adapter for your RecyclerView
        HomeAdapter homeAdapter = new HomeAdapter();
//        horizontalRecyclerView.setAdapter(adapter);
        horizontalRecyclerView.setAdapter(homeAdapter);


        // when clicked on home button

        homeHomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        // when clicked on education button

        homeedubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, EducationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // when clicked on search button

        homesrcbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, SearchActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // when clicked on save button

        homesavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, SaveActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // when clicked on profile button

        homeprofilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }


}