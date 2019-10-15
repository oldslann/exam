package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity  {

    private static String TAG="main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btn1=findViewById(R.id.main_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int1();
            }
        });



        ImageButton btn2=findViewById(R.id.main_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int2();
            }
        });

        ImageButton btn3=findViewById(R.id.main_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int3();
            }
        });



    }


    public void int1()
    {
        Intent intent=new Intent(this,Skill.class);
        startActivity(intent);


    }

    public void int2()
    {
        Intent intent=new Intent(this,information.class);
        startActivity(intent);


    }

    private void int3()
    {
        Intent config = new Intent(this, netItem.class);
        config.putExtra("url","https://search.bilibili.com/all?keyword=66剑道选手权" );
        startActivity(config);
        Log.i(TAG,"clicked");


    }
}
