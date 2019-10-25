package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CapitalActivity extends AppCompatActivity {

    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);

        show = findViewById(R.id.showw);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String cap = bundle.getString("Capital");
            show.setText(cap);
        }
        else{
            Toast.makeText(this, "No Message", Toast.LENGTH_SHORT).show();
        }
    }
}
