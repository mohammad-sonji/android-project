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

public class Lessons_menu extends AppCompatActivity {

    ExpandableListView expandableListView;
    HashMap<String, List<String>> listDetail;
    ArrayList<String> listTitle;
    CustomExpandableListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_menu);

        ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();
        actionBar.show();




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
                if(listDetail.get(listTitle.get(groupPosition)).get( childPosition) == "questions"){
                    //Toast.makeText(getApplicationContext(), "going to questions page", Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(this, Questions_page.class);
//                    i.putExtra("lesson_name", listTitle.get(groupPosition));
//                    startActivity(i);
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
//        if(item.getItemId() == R.id.action_pen)
//            Toast.makeText(this, "you clicked on the pen", Toast.LENGTH_LONG).show();
//        if(item.getItemId() == R.id.action_send)
//            Toast.makeText(this, "you clicked on the envelope", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    Log.e(getClass().getSimpleName(), "onMenuOpened...unable to set icons for overflow menu", e);
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }
}
