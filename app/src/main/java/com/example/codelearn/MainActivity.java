package com.example.codelearn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //action bar
        ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();
        actionBar.show();

        //dark mode
        if(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("dark_mode", false)){
            findViewById(R.id.layout).setBackgroundColor(Color.BLACK);
            ((TextView)findViewById(R.id.textview)).setTextColor(Color.WHITE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // reads XML to create the menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO: handle clicks on the menu items
        if(item.getItemId() == R.id.settings) {
            Intent i = new Intent(getApplicationContext(), Settings.class);
            startActivity(i);
        }
        if(item.getItemId() == R.id.about)  {
            Intent i = new Intent(getApplicationContext(), About.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    Log.e(getClass().getSimpleName(), "onMenuOpened...unable to set icons for overflow menu", e);
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }
    // open lessons page
    public void onClick(View view){
        Toast.makeText(this, "Welcome.", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Lessons_menu.class);
        startActivity(i);
        finish();
    }
}
