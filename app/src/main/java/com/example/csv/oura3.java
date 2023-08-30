package com.example.csv;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class oura3 extends AppCompatActivity {

    private ListView ouraData;
    private List<OuraRingData> ouraSamples = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oura3);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6200EE")));
        getSupportActionBar().setTitle("3 Day Readiness Predictions");

        readOuraData();

        ouraData = (ListView) findViewById(R.id.oura_list);

        for(int i = 0; i < ouraSamples.size(); i++){
            String str = "\t\t" + String.valueOf(ouraSamples.get(i).getHR()) + "\t\t\t\t\t\t\t"+ String.valueOf(ouraSamples.get(i).getHRV()) + "\t\t\t\t\t\t\t\t\t"
                    + String.valueOf(ouraSamples.get(i).getSleep() + "\t\t\t\t\t\t\t\t" + String.valueOf(ouraSamples.get(i).getTempDev()) + "\t\t\t\t\t\t\t\t\t" +String.valueOf(ouraSamples.get(i).getReadiness()));

            list.add(str);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.mylist,list);

        ouraData.setAdapter(adapter);
    }

    private void readOuraData() {

        InputStream is = getResources().openRawResource(R.raw.ouraring3);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        try {

            reader.readLine();
            while ( (line = reader.readLine()) != null){
                // Split by ','
                String[] tokens = line.split(",");

                // Read data in
                OuraRingData sample = new OuraRingData();
                sample.setHR(Double.parseDouble(tokens[1]));
                sample.setHRV(Integer.parseInt(tokens[2]));
                sample.setReadiness(Integer.parseInt(tokens[4]));
                sample.setSleep(Integer.parseInt(tokens[3]));
                sample.setTempDev(Double.parseDouble(tokens[5]));

                ouraSamples.add(sample);

                Log.d("Activity", "Just created: " + sample);
            }
        }catch (IOException e){
            Log.wtf("Activity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }

    }



}