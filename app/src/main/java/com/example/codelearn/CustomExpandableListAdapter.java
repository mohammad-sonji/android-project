package com.example.codelearn;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listTitle;
    // list with only the titles
    private HashMap<String, List<String>> listDetail;
    // the full list
    public CustomExpandableListAdapter(Context context, List<String> expandableListTitle, HashMap<String, List<String>> expandableListDetail) {
        this.context = context;
        this.listTitle = expandableListTitle;
        this.listDetail = expandableListDetail;
    }

    @Override
    public int getGroupCount() {
        return this.listTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDetail.get(this.listTitle.get(groupPosition)).size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int titlePosition, int detailPosition) {
        return this.listDetail.get( this.listTitle.get(titlePosition)).get(detailPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            // inﬂate view if not existing
            LayoutInflater LayoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = LayoutInflater.inflate( R.layout.activity_listgroup, null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    public View getChildView(int titlePosition, int detailPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String expandedListText = (String) getChild(titlePosition, detailPosition);
        if (convertView == null) {
            // inﬂate view if not existing
            LayoutInflater LayoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = LayoutInflater.inflate(R.layout.activity_listitem, null);
        }
        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}
