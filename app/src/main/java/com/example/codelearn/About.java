package com.example.codelearn;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        if(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("dark_mode",false)){
            ((TextView)findViewById(R.id.title)).setTextColor(Color.WHITE);
            ((TextView)findViewById(R.id.textView1)).setTextColor(Color.WHITE);
            ((TextView)findViewById(R.id.textView2)).setTextColor(Color.WHITE);
            findViewById(R.id.about).setBackgroundColor(Color.BLACK);
        }
    }
}
