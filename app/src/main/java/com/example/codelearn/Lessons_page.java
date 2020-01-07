package com.example.codelearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Lessons_page extends MainActivity {
    SharedPreferences Mpref;
    SharedPreferences.Editor Meditor;
    LinearLayout ly;
    String LESSONNUMBER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_page);
        ly = findViewById(R.id.lessons);
        Mpref = PreferenceManager.getDefaultSharedPreferences(this);
        Meditor = Mpref.edit();

        Intent in = getIntent();
        LESSONNUMBER = in.getStringExtra("lesson_number");
        Log.d("lessonnum", "lesson: "+LESSONNUMBER);

        //Getting array from resources
        String Name = "lesson_"+LESSONNUMBER;
        int id = getResources().getIdentifier(Name, "array", this.getPackageName());
        String[] ary = getResources().getStringArray(id);

        //Getting title from resources
        Name = "title_"+LESSONNUMBER;
        id = getResources().getIdentifier(Name, "string", this.getPackageName());
        String title = getResources().getString(id);
        ((TextView)findViewById(R.id.title)).setText(title);

        //dark mode
        if(Mpref.getBoolean("dark_mode",false)){
            findViewById(R.id.layout).setBackgroundColor(Color.BLACK);
            ((TextView)findViewById(R.id.title)).setTextColor(Color.WHITE);
        }

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
        //dark mode
        if(Mpref.getBoolean("dark_mode",false)){
            hsv.setBackgroundColor(Color.parseColor("#292929"));
            tv.setTextColor(Color.parseColor("#acacac"));
        }
        else{
            hsv.setBackgroundColor(Color.parseColor("#efecea"));
        }
        tv.setTextSize(Integer.parseInt(Mpref.getString("code_size",18+"")));
        hsv.addView(tv);
        this.ly.addView(hsv);
    }

    //function that adds normal text to the design(and sets their size, margin, )
    void addText(TextView tv,String ary){
        tv.setText(ary);
        //text size and margin
        tv.setTextSize(Integer.parseInt(Mpref.getString("text_size",18+"")));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f);
        params.setMargins(0, 0, 0, 35); //substitute parameters for left, top, right, bottom
        tv.setLayoutParams(params);
        if(Mpref.getBoolean("dark_mode",false))
            tv.setTextColor(Color.WHITE);
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
            if(s.charAt(j) == 'c' && j+4 < s.length() && s.substring(j,j+4).equals("char"))
                ss.setSpan(new ForegroundColorSpan(Color.parseColor("#5b39c6")),j,j+4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            if(s.charAt(j) == 'f' && j+3 < s.length() && s.substring(j,j+3).equals("for"))
                ss.setSpan(new ForegroundColorSpan(Color.parseColor("#5b39c6")),j,j+3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            if(s.charAt(j) == 'i' && j+4 < s.length() && s.substring(j,j+4).equals("int "))
                ss.setSpan(new ForegroundColorSpan(Color.parseColor("#5b39c6")),j,j+3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            if(s.charAt(j) == 'd' && j+6 < s.length() && s.substring(j,j+6).equals("double"))
                ss.setSpan(new ForegroundColorSpan(Color.parseColor("#5b39c6")),j,j+6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            if(s.charAt(j) == 'w' && j+5 < s.length() && s.substring(j,j+5).equals("while"))
                ss.setSpan(new ForegroundColorSpan(Color.parseColor("#5b39c6")),j,j+5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            if(s.charAt(j) == '.' && j+4 < s.length() && s.substring(j,j+4).equals(".out"))
                ss.setSpan(new ForegroundColorSpan(Color.parseColor("#5b39c6")),j+1,j+4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            else if (j!=s.length()-1 && s.charAt(j)=='/' && s.charAt(j+1)=='/'){
                int i = j;
                for (j = j+2; j < s.length() && s.charAt(j)!='\n';j++);
                ss.setSpan(new ForegroundColorSpan(Color.parseColor("#7fa208")),i,j, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

    public void Back(View view){
       finish();
    }
    public void tomcq(View view){
        Intent b = new Intent(getApplicationContext(), Questions_page.class);
        b.putExtra("lesson_number", LESSONNUMBER);
        startActivity(b);
    }

}
