package com.test.huangxingli.animationtravel;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.PointF;
import android.media.Image;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by huangxingli on 2015/3/5.
 */
public class ValueAnimatorActivity extends Activity {
    ImageView dot;
    static final String TAG="TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valueanim);
        dot= (ImageView) findViewById(R.id.image);
        Button button1= (Button) findViewById(R.id.button1);
        Button button2= (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ofObjectAnim();
            }
        });

       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                newValueAnim();
           }
       });

    }

    public void ofObjectAnim(){
        ValueAnimator valueAnimator=ValueAnimator.ofObject(new TypeEvaluator<PointF> ()
        {
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                Log.v(TAG,"fraction 的值为"+fraction);
                PointF point=new PointF();
                point.x = fraction * endValue.x;
                point.y=fraction*endValue.y;

                return point;
            }
        },new PointF(0,0),new PointF(500,500));
        valueAnimator.setDuration(4000);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF= (PointF) animation.getAnimatedValue();
                dot.setX(pointF.x);
                dot.setY(pointF.y);
            }
        });
    }
    public void newValueAnim(){
        ValueAnimator valueAnimator=new ValueAnimator();
        //注意第一个point是起始位置点，其余剩下的均为终点坐标，除第一个外，分别以1,2和1,3组合来
        // 作为起始和终点位置执行动画
        valueAnimator.setObjectValues(new PointF(0,0),new PointF(500,500),new PointF(600,600));
        valueAnimator.setDuration(4000);
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                PointF pointF=new PointF();
                pointF.x=fraction*endValue.x;
                pointF.y=fraction*endValue.y;
                return pointF;
            }
        });
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF= (PointF) animation.getAnimatedValue();
                float x=pointF.x;
                float y=pointF.y;
                Log.v(TAG,"X IS -----------------------------"+x+"---------------------y is "+y);
                dot.setX(x);
                dot.setY(y);
            }
        });

    }
}
