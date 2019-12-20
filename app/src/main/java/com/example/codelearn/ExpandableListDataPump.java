package com.example.codelearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {
        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();
        List<String> l1 = new ArrayList<String>();
        l1.add("System.out.println()");
        l1.add("questions");
        List<String> l2 = new ArrayList<String>();
        l2.add("java primitive types");
        l2.add("questions");
        List<String> l3 = new ArrayList<String>();
        l3.add("Declaration and initialization");
        l3.add("questions");
        List<String> l4 = new ArrayList<String>();
        l4.add("Increment and decrement");
        l4.add("questions");
        List<String> l5 = new ArrayList<String>();
        l5.add("Char and String");
        l5.add("questions");
        List<String> l6 = new ArrayList<String>();
        l6.add("Relational Operators");
        l6.add("questions");
        List<String> l7 = new ArrayList<String>();
        l7.add("if statement");
        l7.add("questions");
        List<String> l8 = new ArrayList<String>();
        l8.add("Loops,Nested loop,while loop,do while");
        l8.add("questions");
        List<String> l9 = new ArrayList<String>();
        l9.add("Scope");
        l9.add("questions");
        List<String> l10 = new ArrayList<String>();
        l10.add("Declaring a method");
        l10.add("questions");



        expandableListDetail.put("lesson 1", l1);
        expandableListDetail.put("lesson 2", l2);
        expandableListDetail.put("lesson 3", l3);
        expandableListDetail.put("lesson 4", l4);
        expandableListDetail.put("lesson 5", l5);
        expandableListDetail.put("lesson 6", l6);
        expandableListDetail.put("lesson 7", l7);
        expandableListDetail.put("lesson 8", l8);
        expandableListDetail.put("lesson 9", l9);
        expandableListDetail.put("lesson 10", l10);

    return expandableListDetail;
    }
}
