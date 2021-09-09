package com.example.bookishbookshop;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

public class MainScreen extends AppCompatActivity {

    VideoView videoView;
    ImageButton Menu;

    /*
     * ---AutFit Variables-------------------------------------------------------------------------*/
    private int dpWidth, dpHeight, designWidth = 360,  desighHeiht = 780;
    private float dDensity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_screen);
        Menu = findViewById(R.id.btnMenu);
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
                startActivity(intent);

            }
        });

        /*
         * ---AutoFit------------------------------------------------------------------------------*/
        int buttonsX = 70, buttonsY = 80, edittextX = 300, edittextY = 70;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        dpWidth = (displayMetrics.widthPixels);
        dpHeight = (displayMetrics.heightPixels);
        dDensity = (displayMetrics.scaledDensity);
        // Button: Menu
        ViewGroup.LayoutParams btnMenuP = (ViewGroup.MarginLayoutParams) Menu.getLayoutParams();
        btnMenuP.width = calWidth(buttonsX);
        btnMenuP.height = calHeight(buttonsY);
        // Videoview: Anuncion
        ViewGroup.LayoutParams vvAnuncioP = (ViewGroup.MarginLayoutParams) videoView.getLayoutParams();
        vvAnuncioP.width = calWidth(300);
        vvAnuncioP.height = calHeight(380);
    }

    /*
     * ---Methods: AutoFit------------------------------------------------------------------------*/
    // Method: calHeight
    public int calHeight (float value) {
        return (int) (dpHeight * (value/desighHeiht));
    }
    // Method: calWidth
    public int calWidth (float value) {
        return (int) (dpWidth * (value/designWidth));
    }

}
