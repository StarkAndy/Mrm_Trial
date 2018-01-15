package com.example.ishu.repairproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CustomList customList;
    ListView listview;
    String[] tildeSplit ={"Ishita","ram","shyam","sahil","hushan","shruti","aman","nidhi","vaishali","deepti"},tildeSplit1 ={"saxena","gupta","raj","kumar","sharma","singh","shukla","kumar","saxena","bhatnagar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listview = (ListView)findViewById(R.id.listView);


        try {
            customList = new CustomList(this, tildeSplit, tildeSplit1);
            listview.setAdapter(customList);
        }catch (Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"hi"+i, Toast.LENGTH_SHORT).show();
            }
        });



    }
}
