package com.example.codelearn;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questions_page extends MainActivity {

    Button previous, home;
    TextView text;
    Resources resources;
    RadioButton a, b, c, d;
    String[] answers;
    String LESSONNUMBER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page);
        previous = findViewById(R.id.button2);
        home = findViewById(R.id.button);
        text = findViewById(R.id.textview1);
        a = findViewById(R.id.radioButton1);
        b = findViewById(R.id.radioButton2);
        c = findViewById(R.id.radioButton3);
        d = findViewById(R.id.radioButton4);
        //Questions
        Intent intent = getIntent();
        LESSONNUMBER = intent.getStringExtra("lesson_number");
        int id = getResources().getIdentifier("mcq_1", "array", this.getPackageName());
        String[] ary = getResources().getStringArray(id);
        text.setText(ary[Integer.valueOf(LESSONNUMBER) - 1]);
        int choice = getResources().getIdentifier("choices_1", "array", this.getPackageName());
        String[] choices_1 = getResources().getStringArray(choice);
        String[] choices_seperated = choices_1[Integer.valueOf(LESSONNUMBER) - 1].split(",");
        a.setText(choices_seperated[0]);
        b.setText(choices_seperated[1]);
        c.setText(choices_seperated[2]);
        d.setText(choices_seperated[3]);
        int answer = getResources().getIdentifier("answer_1", "array", this.getPackageName());
        answers = getResources().getStringArray(answer);
        //dark mode
        if(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("dark_mode",false)){
            text.setTextColor(Color.WHITE);
            a.setTextColor(Color.WHITE);
            b.setTextColor(Color.WHITE);
            c.setTextColor(Color.WHITE);
            d.setTextColor(Color.WHITE);
            findViewById(R.id.layout).setBackgroundColor(Color.BLACK);
        }

    }
    public void CheckAnswer(View view) {
        if(a.isChecked() && answers[Integer.valueOf(LESSONNUMBER) - 1].equals("a")){
            Intent i = new Intent(getApplicationContext(), MainActivity_notification.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        } else if(b.isChecked() && answers[Integer.valueOf(LESSONNUMBER) - 1].equals("b")){
            Intent i = new Intent(getApplicationContext(), MainActivity_notification.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        } else if(c.isChecked() && answers[Integer.valueOf(LESSONNUMBER) - 1].equals("c")){
            Intent i = new Intent(getApplicationContext(), MainActivity_notification.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        } else if(d.isChecked() && answers[Integer.valueOf(LESSONNUMBER) - 1].equals("d")){
            Intent i = new Intent(getApplicationContext(), MainActivity_notification.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getApplicationContext(), "wrong :(", Toast.LENGTH_SHORT).show();
        }
    }

    public void Home(View view){
        Intent in = new Intent(getApplicationContext(), Lessons_menu.class);
        startActivity(in);
    }
    public void Back(View view){
        Intent b = new Intent(getApplicationContext(), Lessons_page.class);
        b.putExtra("lesson_number", LESSONNUMBER);
        startActivity(b);
    }
}
