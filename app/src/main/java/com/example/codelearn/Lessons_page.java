package com.example.codelearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Lessons_page extends AppCompatActivity {

    LinearLayout ly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_page);
        ly = (LinearLayout) findViewById(R.id.lessons);


        Intent in = getIntent();
        String LESSONNUMBER = in.getStringExtra("lesson_number");

        //Getting array from resources
        String Name = "lesson_"+LESSONNUMBER;
        int id = getResources().getIdentifier(Name, "array", this.getPackageName());
        String[] ary = getResources().getStringArray(id);

        //Getting title from resources
        Name = "title_"+LESSONNUMBER;
        id = getResources().getIdentifier(Name, "string", this.getPackageName());
        String title = getResources().getString(id);
        ((TextView)findViewById(R.id.title)).setText(title);

        //inserting array elements in design
        for (int i = 0; i < ary.length; i++){
            TextView tv=new TextView(this);

            //coloring words
            if(ary[i].charAt(0) == '#'){
                if(ary[i].charAt(1) == 'c')
                    addCodeText(tv,ary[i]);
            }
            else {
                //setting text if no coloring needed
                addText(tv,ary[i]);
            }
        }

    }

    //function that adds code to the design(and gives the background, text color, horizontal scroll)
    void addCodeText(TextView tv, String ary){
        ary = ary.substring(2);
        //makes a spannable string to color specific words
        SpannableString ss = new SpannableString(ary);
        colorSpecialWords(ary,ss);
        tv.setText(ss);
        HorizontalScrollView hsv = new HorizontalScrollView(this);
        tv.setTextSize(18);
        hsv.setBackgroundColor(Color.parseColor("#efecea"));
        hsv.addView(tv);
        this.ly.addView(hsv);
    }

    //function that adds normal text to the design(and sets their size, margin, )
    void addText(TextView tv,String ary){
        tv.setText(ary);
        //text size and margin
        tv.setTextSize(18);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f);
        params.setMargins(0, 0, 0, 35); //substitute parameters for left, top, right, bottom
        tv.setLayoutParams(params);
        //inserting textviews into layout
        this.ly.addView(tv);
    }

    //function that finds special words and colors them
    static void colorSpecialWords(String s, SpannableString ss){
        for (int j = 0; j < s.length(); j++){
            if(s.charAt(j)=='p' && j+6 < s.length() && s.substring(j,j+6).equals("public"))
                ss.setSpan(new ForegroundColorSpan(Color.parseColor("#5b39c6")),j,j+6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            if(s.charAt(j) == 's' && j+6 < s.length() && s.substring(j,j+6).equals("static"))
                ss.setSpan(new ForegroundColorSpan(Color.parseColor("#5b39c6")),j,j+6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            if(s.charAt(j) == 'v' && j+4 < s.length() && s.substring(j,j+4).equals("void"))
                ss.setSpan(new ForegroundColorSpan(Color.parseColor("#5b39c6")),j,j+4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            if(s.charAt(j) == 'c' && j+5 < s.length() && s.substring(j,j+5).equals("class"))
                ss.setSpan(new ForegroundColorSpan(Color.parseColor("#5b39c6")),j,j+5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    public void Back(View view){
        Intent in = new Intent(this, Lessons_menu.class);
        startActivity(in);
    }
}
