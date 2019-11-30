package com.example.noelanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    GifImageView gifImageViewFirt,gifImageViewsecond,santaclaus1,santaclaus2,santaclaus3,santaclauswelcome,textmerrychritmas,running,skate;
    CountDownTimer countDownTimer;
    int i=0;
    MediaPlayer mediaPlayer;
    int[] array_image= {R.drawable.dance0,R.drawable.dance2,R.drawable.dance1,R.drawable.dance3,R.drawable.dance4,R.drawable.dance5,R.drawable.dance6,R.drawable.skate};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context;
        mediaPlayer= MediaPlayer.create(this, R.raw.nhacgiangsinh);
        mediaPlayer.start();
        textmerrychritmas=findViewById(R.id.gifmerrychristmas);
        gifImageViewFirt= findViewById(R.id.gifmovefirstime);
        gifImageViewsecond=findViewById(R.id.gifmovesecond);
        santaclaus1=findViewById(R.id.gifImagesantal1);
        santaclaus2=findViewById(R.id.gifImagesanta2);
        santaclaus3=findViewById(R.id.gifImagesanta3);
        running= findViewById(R.id.running);
        skate=findViewById(R.id.idskate);
        skate.setVisibility(View.INVISIBLE);
        running.setVisibility(View.INVISIBLE);
        santaclauswelcome=findViewById(R.id.gifsantaclauswelcome);
        santaclaus1.setVisibility(View.INVISIBLE);
        santaclaus2.setVisibility(View.INVISIBLE);
        santaclaus3.setVisibility(View.INVISIBLE);
        Animation translateAnimation_merrychristmas= AnimationUtils.loadAnimation(this,R.anim.scalemerrychristmas);
        textmerrychritmas.setAnimation(translateAnimation_merrychristmas);
        Animation translateAnimation_first= AnimationUtils.loadAnimation(this,R.anim.firstanimation);
        gifImageViewFirt.setAnimation(translateAnimation_first);
        Animation translateAnimation_second= AnimationUtils.loadAnimation(this,R.anim.secondmove);
        gifImageViewsecond.setAnimation(translateAnimation_second);
        Animation animation_welcome= AnimationUtils.loadAnimation(this,R.anim.scale);
        santaclauswelcome.setAnimation(animation_welcome);
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                santaclauswelcome.setVisibility(View.INVISIBLE);
                santaclaus1.setVisibility(View.VISIBLE);
                santaclaus2.setVisibility(View.VISIBLE);
                santaclaus3.setVisibility(View.VISIBLE);
                countDownTimer= new CountDownTimer(4000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() { i++;
                        if(i>=8) {
                            i = 0;
                            mediaPlayer.stop();
                            mediaPlayer= MediaPlayer.create(MainActivity.this, R.raw.nhacgiangsinh);
                            mediaPlayer.start();
                        }
                        if (i==0)
                        {   santaclaus2.setVisibility(View.VISIBLE);
                            santaclaus1.setVisibility(View.VISIBLE);
                            santaclaus3.setVisibility(View.VISIBLE);
                            running.setVisibility(View.INVISIBLE);
                            skate.setVisibility(View.INVISIBLE);
                        }
                        else if (i==1||i==6)
                        {   santaclaus1.setVisibility(View.INVISIBLE);
                            santaclaus2.setVisibility(View.INVISIBLE);
                            santaclaus3.setVisibility(View.INVISIBLE);
                            skate.setVisibility(View.INVISIBLE);
                            running.setVisibility(View.VISIBLE);
                            Animation arunning= AnimationUtils.loadAnimation(MainActivity.this,R.anim.running);
                            running.setAnimation(arunning);
                        }
                        else if (i==7)
                        {   skate.setVisibility(View.VISIBLE);
                            santaclaus2.setVisibility(View.INVISIBLE);
                            running.setVisibility(View.INVISIBLE);
                            santaclaus1.setVisibility(View.INVISIBLE);
                            santaclaus3.setVisibility(View.INVISIBLE);
                            Animation aSkate= AnimationUtils.loadAnimation(MainActivity.this,R.anim.skate);
                            skate.setAnimation(aSkate);
                        }
                        else
                        {   skate.setVisibility(View.INVISIBLE);
                            santaclaus2.setVisibility(View.VISIBLE);
                            running.setVisibility(View.INVISIBLE);
                            santaclaus1.setVisibility(View.INVISIBLE);
                            santaclaus3.setVisibility(View.INVISIBLE);
                        }
                        santaclaus1.setImageResource(array_image[i]);
                        santaclaus2.setImageResource(array_image[i]);
                        santaclaus3.setImageResource(array_image[i]);
                        running.setImageResource(array_image[i]);
                        skate.setImageResource(array_image[i]);
                        countDownTimer.start();
                    }
                };
                countDownTimer.start();
            }
        },2*animation_welcome.getDuration());

    }
}
