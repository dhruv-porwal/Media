package com.example.media;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
private ImageButton play;

private  ImageButton pause;
private SeekBar seekBar;
private  MediaPlayer mediaPlayer;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
seekBar=        findViewById(R.id.seekBar);


        // hey lets use media player create class and then we will use mediaplayer.create function of media player class

MediaPlayer mediaPlayer = new MediaPlayer();
// Media player using local source
         mediaPlayer =MediaPlayer.create(this,R.raw.music2 );

         //get duration returns int value of time of music





      //  media player using  web source

 //       mediaPlayer= new MediaPlayer();
//
//        try {
//            mediaPlayer.setDataSource("");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        play=findViewById(R.id.play);
         pause=findViewById(R.id.pause);


       // MediaPlayer finalMediaPlayer = mediaPlayer;
       // MediaPlayer finalMediaPlayer = mediaPlayer;
        MediaPlayer finalMediaPlayer = mediaPlayer;
        seekBar.setMax(mediaPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(finalMediaPlayer.getCurrentPosition());
            }
        },0,1000);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //  yahan niche if loop khali tabh hee kam krega jabh user touch krega iske bina yeh hoga ki upar seekBar.set progress ke badhne par bhi yeh chnge ho rha tha aur cuts de rha tha
                if(fromUser){
                finalMediaPlayer.seekTo(progress);}
                //Toast.makeText(MainActivity.this, "Playing", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {

                 finalMediaPlayer.start();
                 finalMediaPlayer.setLooping(true);
             }
         });


        MediaPlayer finalMediaPlayer1 = mediaPlayer;
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalMediaPlayer.pause();
            }
        });


    }
}