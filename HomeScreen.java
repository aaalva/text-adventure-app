package com.example.android.xmenadventure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.*;

import androidx.appcompat.app.AppCompatActivity;

// Class function for Home Screen activity.
public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        // Creates intro sound feature.
        final MediaPlayer intro = MediaPlayer.create(this,R.raw.xmen_intro);

        intro.start();

        
        // Creates a sound feature that pulls from X-Men Theme MP3 file.
        final MediaPlayer beginGame = MediaPlayer.create(this, R.raw.xmen_music);

        // Assigns "Begin" button to the Button id in XML file.
        Button beginX = this.findViewById(R.id.begin_game);


        // This line of code activates the MP3 sound after 2 second delay. 
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                beginGame.start();
            }
        }, 2000);

        // This will loop the sound.
        beginGame.setLooping(true);


        // Establishes the actions of various items when user clicks button.
        beginX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Stops MP3 sound after clicking button.
                //beginGame.stop();

                // Allows for the processing of runnable objects in a timed duration.
                //Handler handler= new Handler();

                // This specifically delays the stopping of sound after 17 seconds.
               // handler.postDelayed(new Runnable() {
                    //@Override
                    //public void run() {
                        //beginGame.stop();
                    //}
                //}, 17 * 1000);

                // Changes from Home Screen to Emma Frost Selection Activity after clicking.
                Intent intent =  new Intent(HomeScreen.this, ScenarioTwow.class);
                startActivity(intent);

              

            }
        });
    }
}
