package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1=findViewById(R.id.main_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int1();
            }
        });



        Button btn2=findViewById(R.id.main_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int2();
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
}