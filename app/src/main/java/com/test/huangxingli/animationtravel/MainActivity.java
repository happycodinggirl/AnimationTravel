package com.test.huangxingli.animationtravel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    static final String TAG="TAG";
    String[] animStrings={"ValueAnimation","ObjectAnimation","ViewCodeAnim","ViewXMLAnim","XMLPropertyAnim"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MyAdapter adapter=new MyAdapter(getApplicationContext(),animStrings);
        ListView listView= (ListView) findViewById(R.id.mlist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent1=new Intent(MainActivity.this,ValueAnimatorActivity.class);
                        startActivity(intent1);

                        break;
                    case 1:
                        Intent intent2=new Intent(MainActivity.this,ObjectAnimatorActivity.class);
                        startActivity(intent2);

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        Intent intent=new Intent(MainActivity.this,XMLPropertyAnimActivity.class);
                        startActivity(intent);
                        break;

                }

            }
        });


        final ImageView dot = (ImageView) findViewById(R.id.image);

    }
    class MyAdapter extends ArrayAdapter<String>{

        public MyAdapter(Context context, String[] resource) {
            super(context, R.layout.item_layout,resource);
        }

        @Override
        public String getItem(int position) {
            return animStrings[position];
        }

        @Override
        public View getView(int position, View convertView1, ViewGroup parent) {
            LayoutInflater inflater=LayoutInflater.from(getApplicationContext());
           View  convertView=inflater.inflate(R.layout.item_layout,null,true);
            TextView textView= (TextView) convertView.findViewById(R.id.textView);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(20);
            textView.setText(getItem(position));
            return convertView;
        }
    }
}
