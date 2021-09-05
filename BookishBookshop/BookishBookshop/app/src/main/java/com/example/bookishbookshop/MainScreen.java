package com.example.bookishbookshop;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainScreen extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_screen);
        Button Menu = findViewById(R.id.btnMenu);
        videoView = findViewById(R.id.vAnuncio);
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.anuncio_book);
        videoView.setVideoURI(video);
        videoView.setZOrderOnTop(true);
        videoView.start();
        videoView.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });



        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Menu.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
