package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView country;

    public static final String countries[]={"Nepal", "Kathmandu","China", "Beijing" , "India" , "New Delhi"};

    private Map<String,String> countryMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country = findViewById(R.id.list);

        countryMap = new HashMap<>();
        for (int i = 0; i<countries.length; i=i+2){
            countryMap.put(countries[i],countries[i+1]);
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
        new ArrayList<String>(countryMap.keySet()));
        country.setAdapter(adapter);

        country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                String capital = countryMap.get(country);
                //Toast.makeText(MainActivity.this, "Capital of " + country + " is : " +capital, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,CapitalActivity.class);
                intent.putExtra("Capital",capital);
                startActivity(intent);
            }
        });
    }
}
