package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class vedio_play extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_play);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);   //全屏
        try {
           play_rtsp();
       } catch (IOException e){

           e.printStackTrace();
       }



    }






    private void play_rtsp() throws IOException {
        String videoUrl2 = "blob:https://www.bilibili.com/4b5b9f89-9dfc-4433-96ec-8a616bd586d7" ;
        Uri uri = Uri.parse( videoUrl2 );
        videoView = (VideoView)this.findViewById(R.id.videoView );
        //videoView.setVideoPath(path);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }


}
