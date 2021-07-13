package com.example.bookishbookshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class Splash extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(Splash.this, Login.class);
                startActivity(intent);

                videoView = findViewById(R.id.videoView);

                String path = "android.resource://"+getPackageName()+"/"+R.raw.bookish;

                videoView.setVideoURI(Uri.parse(path));
                videoView.start();
            }

        },4000);
    }
}
