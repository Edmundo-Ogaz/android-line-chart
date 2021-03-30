package com.example.linechart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("sharedPrefs", MODE_PRIVATE);

//        SortedMap<Integer, Float> sm = new TreeMap<Integer, Float>();
//        Set<String> set = prefs.getStringSet("data", null);
//        for (String d : set ) {
//            System.out.println(d);
//            String[] array = d.split((";"));
//            int x = Integer.parseInt(array[0]);
//            System.out.println(x);
//            float y = Float.parseFloat(array[1]);
//            System.out.println(y);
//            sm.put(x, y);
//        }
//
//        List<Entry> entries = new ArrayList<Entry>();
//
//        Set s = sm.entrySet();
//        Iterator i = s.iterator();
//        while (i.hasNext()) {
//            Map.Entry m = (Map.Entry)i.next();
//
//            int key = (Integer)m.getKey();
//            Float value = (Float)m.getValue();
//
//            System.out.println("Key : " + key
//                    + "  value : " + value);
//            entries.add(new Entry(key, value));
//        }



        LineChart chart = (LineChart) findViewById(R.id.chart);

        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(1, 60));
        entries.add(new Entry(2, 50));
        entries.add(new Entry(3, 70));
        entries.add(new Entry(4, 60));

        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset

        LineData data = new LineData(dataSet);
        chart.setData(data);

        //SharedPreferences prefs = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = prefs.edit();
        myEditor.putString("NAME", "Alice");

        Set<String> cars = new HashSet<String>();
        cars.add("1;60");
        cars.add("2;50");
        cars.add("3;70");
        cars.add("4;60");
        cars.add("5;60");

        myEditor.putStringSet("data", cars);
        myEditor.apply();


    }
}