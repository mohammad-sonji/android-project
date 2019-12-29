package com.example.codelearn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lessons_menu extends MainActivity {

    ExpandableListView expandableListView;
    HashMap<String, List<String>> listDetail;
    ArrayList<String> listTitle;
    CustomExpandableListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_menu);


        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        listDetail = ExpandableListDataPump.getData();
        listTitle = new ArrayList<String>(listDetail.keySet());
        listAdapter = new CustomExpandableListAdapter(this, listTitle, listDetail);

        expandableListView.setAdapter(listAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), listTitle.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), listTitle.get(groupPosition) + " List Collapsed.",Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), listTitle.get(groupPosition) + " -> " + listDetail.get(listTitle.get(groupPosition)).get( childPosition), Toast.LENGTH_SHORT).show();
                if(listDetail.get(listTitle.get(groupPosition)).get(childPosition) == "questions"){
                    //Toast.makeText(getApplicationContext(), "going to questions page", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Questions_page.class);
                    String l_num = listTitle.get(groupPosition).substring(7);
                    i.putExtra("lesson_number", l_num);
                    startActivity(i);
               } else {
                    //Toast.makeText(getApplicationContext(), "going to lessons page", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Lessons_page.class);
                    String l_num = listTitle.get(groupPosition).substring(7);
                    //Toast.makeText(getApplicationContext(), l_num, Toast.LENGTH_SHORT).show();
                    i.putExtra("lesson_number", l_num);
                    startActivity(i);
               }
                return true;
            }
        });
    }


}
