package com.example.media;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
//
//import com.daimajia.androidanimations.library.Techniques;
//import com.daimajia.androidanimations.library.YoYo;

public class MainActivity2 extends AppCompatActivity {
    Animation zoom;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


      //  zoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.room);
        img = findViewById(R.id.image);
      //  img.startAnimation(zoom);
        img.animate().x(300).y(700).setDuration(850);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));


                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();




            }
        }, 900);



        //    YoYo.with(Techniques.SlideInDown).duration(2000).repeat(0).playOn(img);
        //Animation animation1= AnimationUtils.loadInterpolator(this,R.anim.topsy);

    }
}