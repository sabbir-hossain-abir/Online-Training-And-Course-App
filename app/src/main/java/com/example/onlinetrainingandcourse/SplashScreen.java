package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    ImageView logo;
    TextView tv1,tv2;

    Animation top,bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logo = findViewById(R.id.spalshimg);
        tv1 = findViewById(R.id.splashtv1);
        tv2 = findViewById(R.id.splashtv2);

        top = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);


        logo.setAnimation(top);
        tv1.setAnimation(bottom);
        tv2.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this,LogInActivity.class);
                startActivity(intent);
                finish();

            }
        },4000);


    }
}