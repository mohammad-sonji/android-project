package com.example.codelearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // open lessons page
    public void onClick(View view){
        Toast.makeText(this, "Welcome.", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Lessons_menu.class);
        startActivity(i);
    }
}
