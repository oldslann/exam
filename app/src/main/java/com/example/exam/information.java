package com.example.exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class information extends AppCompatActivity {

    private SensorManager sensorManager;
    private ImageView img;
    private Vibrator vibrator;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);//传感器
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {

                super.handleMessage(msg);

                if (msg.what==100)//摇一摇
                {
                    float shake=(float)msg.obj;
                    img=(ImageView) findViewById(R.id.imageView2);
                    img.setImageResource(R.mipmap.shake2);
                    TextView textView=(TextView)findViewById(R.id.shake_t);
                    textView.setText(""+shake+"m/s");


                }


            }
        };


    }

    //注册监听器
    @Override
    protected void onResume() {
        if (sensorManager!=null)
        {
            sensorManager.registerListener(sensorEventListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        }
        super.onResume();
    }

    //取消监听器
    @Override
    protected void onStop() {
        super.onStop();
        if (sensorManager!=null)
        {
            sensorManager.unregisterListener(sensorEventListener);
        }
    }

    //传感器对象
    private SensorEventListener sensorEventListener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float []values= sensorEvent.values;
            float x=values[0];//不同轴上的加速度
            float y=values[1];
            float z=values[2];
            int medumValue=20;
            if (Math.abs(x)>medumValue||Math.abs(y)>medumValue||Math.abs(z)>medumValue)
            {
                float j=0;
                vibrator.vibrate(200);
                Message msg=new Message();
                msg.what= 100;
                j=Math.max(Math.abs(x),Math.abs(y));
                j=Math.max(j,Math.abs(z));
                msg.obj=j;
                handler.sendMessage(msg);

            }


        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}
