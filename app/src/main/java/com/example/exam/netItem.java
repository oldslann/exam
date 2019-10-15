package com.example.exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class netItem extends AppCompatActivity implements Runnable, AdapterView.OnItemClickListener {

    String url="";
    private  static String TAG="main";
    Handler handler;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_item);
        Intent intent=getIntent();
        url=intent.getStringExtra("url");
        Log.i(TAG,url);



        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what ==8 ) {
                    listView=(ListView)findViewById(R.id.netlist);


                    ArrayList<HashMap<String, String>> listItems = (ArrayList<HashMap<String, String>>) msg.obj;

                    MyAdapter myAdapter = new MyAdapter(netItem.this,
                            R.layout.list_item,
                            listItems);
                    Log.i(TAG, "listView");
                    listView.setAdapter(myAdapter);
                    listView.setOnItemClickListener(netItem.this);


                }


                super.handleMessage(msg);
            }
        };

        //开启子进程
        Thread th=new Thread(netItem.this);
        th.start();


    }

    public void run() {


        Log.i(TAG, "run=  .......... " );



        try {
            Log.i(TAG, "start url " );
            Document doc= Jsoup.connect(url).get();
            Log.i(TAG, "get url " );
            Elements item=doc.getElementsByClass("video-item matrix");

            Log.i(TAG, "get elements" );
            //List<String> list=new ArrayList<String>();
            ArrayList<HashMap<String, String>> listItems = new ArrayList<HashMap<String, String>>();
            Log.i(TAG, "creat hashmap " );

            for(int i=0;i<item.size();i++)
            {
                Element body1=item.get(i);
                Element flag1=body1.selectFirst("a");
                String net=flag1.attr("href");
                String name=flag1.attr("title");
                HashMap<String,String> map=new HashMap<String, String>();
                map.put("name",name);
                map.put("net",net);
                listItems.add(map);

                //list.add(str1+"----->"+val);
                Log.i(TAG, name);
                Log.i(TAG, net);

            }


            Message msg=handler.obtainMessage(8);//获取对象 返回主线程
            //msg.what=6;
            //msg.obj=list;
            msg.obj=listItems;
            handler.sendMessage(msg);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i(TAG,"wrong");
        }






    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {

        Object itemAtPosition = listView.getItemAtPosition(position);
        HashMap<String,String> map = (HashMap<String, String>) itemAtPosition;
        String url = map.get("net");
        Log.i(TAG, "onItemClick: titleStr=" + url);


        Intent config = new Intent(this, webc.class);
        config.putExtra("url", url);
        startActivity(config);
    }



}
