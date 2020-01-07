package com.example.codelearn;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lessons_menu extends MainActivity {
    LinearLayout ln;
    int LangN;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_menu);
        if(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("dark_mode",false)){
            findViewById(R.id.layout).setBackgroundColor(Color.BLACK);
            ((TextView)findViewById(R.id.title)).setTextColor(Color.WHITE);
        }
        ln = (LinearLayout) findViewById(R.id.ln);
        LangN = 0;
        setLanguage();
        ((Button)findViewById(R.id.java)).setEnabled(false);
        ((Button)findViewById(R.id.java)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LangN==0)
                    return;
                LangN = 0;
                ((Button)findViewById(R.id.java)).setEnabled(false);
                ((Button)findViewById(R.id.cpp)).setEnabled(true);
                setLanguage();
            }
        });
        ((Button)findViewById(R.id.cpp)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LangN==1)
                    return;
                LangN = 1;
                ((Button)findViewById(R.id.java)).setEnabled(true);
                ((Button)findViewById(R.id.cpp)).setEnabled(false);
                setLanguage();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    void setLanguage(){
        ln.removeAllViews();
        int count = 1;
        while(true){
            try {
                String Name = "";
                if(LangN == 0) {
                    Name = "title_" + count;
                }
                else{
                    Name = "title_" + count + "C";
                }
                int id = getResources().getIdentifier(Name, "string", this.getPackageName());
                String str = getResources().getString(id);
                addButton(str, count);
                count++;
            } catch (Exception Resources$NotFoundException) {
                break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    void addButton(String str, int n){
        Log.d("WORKSS", "addButton: ");
        Button b = new Button(this);
        b.setText(n+"");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,0,0,200);
        b.setBackground(getResources().getDrawable(R.drawable.mybutton));
        b.setTextSize(25);
        b.setLayoutParams(params);
        TextView tv = new TextView(this);
        tv.setText(str);
        //darkmode
        if(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("dark_mode",false))
            tv.setTextColor(Color.WHITE);
        else{
            tv.setTextColor(Color.BLACK);
        }
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params2.setMargins(0,200,0,60);
        tv.setLayoutParams(params2);
        tv.setTextSize(18);
        final int n2 = n;
        final int lesson = LangN;
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Lessons_page.class);
                if(LangN == 0)
                    i.putExtra("lesson_number", n2+"");
                else
                    i.putExtra("lesson_number", n2+"C");
                startActivity(i);
            }
        });

        ln.addView(tv);
        ln.addView(b);
    }

}
