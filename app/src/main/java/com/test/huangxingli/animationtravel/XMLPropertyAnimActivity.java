package com.test.huangxingli.animationtravel;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by huangxingli on 2015/3/5.
 */
public class XMLPropertyAnimActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlpropertyanim);
        Button button1= (Button) findViewById(R.id.button1);
        Button button2= (Button) findViewById(R.id.button2);
        final ImageView ball= (ImageView) findViewById(R.id.imageView);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animator objectAnimator= AnimatorInflater.loadAnimator(XMLPropertyAnimActivity.this,R.animator.objectanim);

                objectAnimator.setTarget(ball);
                ball.invalidate();
                objectAnimator.start();


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet objectAnimator= (AnimatorSet) AnimatorInflater.loadAnimator(XMLPropertyAnimActivity.this,R.animator.animset);
                ball.invalidate();
                objectAnimator.setTarget(ball);
                objectAnimator.start();

            }
        });

    }
}
