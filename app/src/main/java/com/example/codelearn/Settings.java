package com.example.codelearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    Button save;
    Button cancel;
    Switch darkmode;
    EditText textsize;
    EditText codesize;
    SharedPreferences Mpref;
    SharedPreferences.Editor Meditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //shared pref
        Mpref = PreferenceManager.getDefaultSharedPreferences(this);
        Meditor = Mpref.edit();

        darkmode = findViewById(R.id.darkmode);
        textsize = findViewById(R.id.textsize);
        codesize = findViewById(R.id.codesize);
        darkmode.setChecked(Mpref.getBoolean("dark_mode", false));
        textsize.setText(""+Mpref.getString("text_size", 18+""));
        codesize.setText(""+Mpref.getString("code_size",18+""));

        save = findViewById(R.id.save);
        cancel  = findViewById(R.id.cancel);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meditor.putBoolean("dark_mode",darkmode.isChecked());
                int x = Integer.parseInt(textsize.getText().toString());
                if(x>40)x=40;
                if(x<9)x=9;
                Meditor.putString("text_size",x+"");
                x = Integer.parseInt(codesize.getText().toString());
                if(x>40)x=40;
                if(x<9)x=9;
                Meditor.putString("code_size",x+"");
                Meditor.commit();
                Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if(Mpref.getBoolean("dark_mode",false))
            darkmode();
    }

    void darkmode(){
        findViewById(R.id.layout).setBackgroundColor(Color.BLACK);
        ((TextView)findViewById(R.id.textView)).setTextColor(Color.WHITE);
        //((TextView)findViewById(R.id.textview1)).setTextColor(Color.WHITE);
        ((TextView)findViewById(R.id.textView2)).setTextColor(Color.WHITE);
        ((TextView)findViewById(R.id.textView3)).setTextColor(Color.WHITE);
        ((TextView)findViewById(R.id.textView4)).setTextColor(Color.WHITE);
        textsize.setTextColor(Color.WHITE);
        codesize.setTextColor(Color.WHITE);
    }
}
