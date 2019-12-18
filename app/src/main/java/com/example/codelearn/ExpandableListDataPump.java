package com.example.codelearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {
        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();
        List<String> l1 = new ArrayList<String>();
        l1.add("lesson 1");
        l1.add("questions");
        List<String> l2 = new ArrayList<String>();
        l2.add("lesson 2");
        l2.add("questions");
        List<String> l3 = new ArrayList<String>();
        l3.add("lesson 3");
        l3.add("questions");
        expandableListDetail.put("lesson 1", l1);
        expandableListDetail.put("lesson 2", l2);
        expandableListDetail.put("lesson 3", l3);
    return expandableListDetail;
    }
}
