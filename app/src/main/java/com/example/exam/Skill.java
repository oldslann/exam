package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class Skill extends AppCompatActivity {
    private static String TAG="main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);

        ImageButton btn1=findViewById(R.id.skill_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in1();
            }
        });



        ImageButton btn2=findViewById(R.id.skill_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                in2();
            }
        });


        ImageButton btn3=findViewById(R.id.skill_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in3();
            }
        });






    }
    private void in1()
    {
        Intent config = new Intent(this, netItem.class);
        config.putExtra("url","https://search.bilibili.com/all?keyword=潘达剑士" );
        startActivity(config);
        Log.i(TAG,"clicked");
    }

    private void in2(){
        Intent config = new Intent(this, webc.class);
        config.putExtra("url", "//www.bilibili.com/video/av35190395" );
        startActivity(config);
        Log.i(TAG,"clicked");


    }

    private void in3()
    {
        Intent config = new Intent(this, netItem.class);
        config.putExtra("url","https://search.bilibili.com/all?keyword=剑道比赛" );
        startActivity(config);
        Log.i(TAG,"clicked");
    }

}
