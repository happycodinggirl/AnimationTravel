package com.test.huangxingli.animationtravel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import org.apache.http.ProtocolVersion;

/**
 * Created by huangxingli on 2015/3/5.
 */
public class ObjectAnimatorActivity extends Activity {

        static final String TAG="TAG";
    boolean animated=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.objectanim);
        final ImageView dot= (ImageView) findViewById(R.id.imageView);
        Button button= (Button) findViewById(R.id.button);
        Button button1= (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            ObjectAnimator animX;
            @Override
            public void onClick(View v) {
                //第一种方法
              /*  if (animated) {
                    animX = ObjectAnimator.ofFloat(dot, "x", 50f);
                    Log.v(TAG,"====animated true");
                    animated=false;

                }else{
                    Log.v(TAG,"ANIMATED FALSE");
                    animX = ObjectAnimator.ofFloat(dot, "x", 250f);
                    animated=true;
                }


                ObjectAnimator animY = ObjectAnimator.ofFloat(dot, "y", 100f);
                AnimatorSet animSetXY = new AnimatorSet();
                animSetXY.playTogether(animX, animY);
                animSetXY.start();*/
                //第二种方法
               /* PropertyValuesHolder pvhX;
                if(animated) {
                    pvhX= PropertyValuesHolder.ofFloat("x", 50f);
                    animated=false;
                }else{
                    pvhX=PropertyValuesHolder.ofFloat("x",150f);
                    animated=true;
                }
                PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("y", 100f);
                ObjectAnimator.ofPropertyValuesHolder(dot, pvhX, pvhY).start();*/
                //第三种方法
                if (animated) {
                    dot.animate().x(50).y(150);
                    animated=false;
                }else{
                    dot.animate().x(150).y(150);
                    animated=true;
                }
//三种方法效果一致




            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator=ObjectAnimator.ofFloat(dot,"xhl",1,0.5f);
                valueAnimator.setDuration(4000);
                valueAnimator.start();
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value= (float) animation.getAnimatedValue();
                        dot.setScaleX(value);
                        dot.setAlpha(value);

                    }

                });
                valueAnimator.addListener(new AnimatorListenerAdapter() {


                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        //ValueAnimator的getTarget方法是得到动画所作用的对象
                        ImageView dot= (ImageView) ((ObjectAnimator)animation).getTarget();
                        dot.setScaleY(0.5f);
                        //利用关键帧，在时间为0,刚开始时，旋转角度为0，当处于一半时间时，处于旋转角度为360度，当最后结束时从360度转到0度。
                       /* Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
                        Keyframe kf1 = Keyframe.ofFloat(.5f, 360f);
                        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
                        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2);
                        ObjectAnimator rotationAnim = ObjectAnimator.ofPropertyValuesHolder(dot, pvhRotation);
                        rotationAnim.setDuration(5000);
                        rotationAnim.start();*/

                    }
                });
            }
        });
                dot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(dot, "hxl", 1, 0.5f);
                        objectAnimator.setDuration(3000);
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        objectAnimator.start();
                        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                float value = (float) animation.getAnimatedValue();
                                dot.setScaleX(value);
                                dot.setScaleY(value);
                                dot.setAlpha(value);

                            }
                        });

                    }
                });
                //  ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(dot,"alpha",1,0.5f);
                //  objectAnimator.setDuration(3000);
                //  objectAnimator.setInterpolator(new LinearInterpolator());
                // objectAnimator.start();


            }
        }


