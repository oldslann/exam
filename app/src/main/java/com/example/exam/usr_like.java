package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class usr_like extends AppCompatActivity implements AdapterView.OnItemClickListener{


    private static String TAG="main";
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usr_like);

        listView=(ListView)findViewById(R.id.usr_likes);
        String name="";
        String net="";
        SharedPreferences sharedPreferences=getSharedPreferences("usr_like", Activity.MODE_PRIVATE);
        ArrayList<HashMap<String, String>> listItems = new ArrayList<HashMap<String, String>>();

        int num=sharedPreferences.getInt("num",0);
        for (int i=0;i<=num;i++) {

            Log.i(TAG,"read num:"+num);
            name = sharedPreferences.getString("name"+i, "");
            net = sharedPreferences.getString("net"+i, "");
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("name", name);
            map.put("net", net);
            if (name!="") {
                listItems.add(map);
            }
        }
        MyAdapter myAdapter = new MyAdapter(usr_like.this,
                R.layout.list_item,
                listItems);
        Log.i(TAG, "listView");
        listView.setAdapter(myAdapter);
        listView.setEmptyView(findViewById(R.id.nodata_usr_like));
        listView.setOnItemClickListener(usr_like.this);



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
