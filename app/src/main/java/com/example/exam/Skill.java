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
            }
        });


        ImageButton btn3=findViewById(R.id.skill_btn3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in3();
            }
        });






    }
    public void in1()
    {
        Intent config = new Intent(this, netItem.class);
        config.putExtra("url","https://search.bilibili.com/all?keyword=潘达剑士" );
        startActivity(config);
        Log.i(TAG,"clicked");
    }

    public void in3()
    {
        Intent config = new Intent(this, netItem.class);
        config.putExtra("url","https://search.bilibili.com/all?keyword=剑道实战" );
        startActivity(config);
        Log.i(TAG,"clicked");
    }

}
