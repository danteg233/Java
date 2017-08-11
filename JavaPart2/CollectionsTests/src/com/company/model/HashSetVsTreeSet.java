package com.company.model;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetVsTreeSet{
    private static int count = 1000000;


    private static void addCheck(Set set, String name){
        long start = System.currentTimeMillis();
        for(int i=0; i<count; i++){
            set.add(i);
        }
        System.out.println(name + " add: " + (System.currentTimeMillis() - start));
    }
    private static void removeCheck(Set set, String name){
        long start = System.currentTimeMillis();
        for(int i=0; i<count; i++){
            set.remove(i);
        }
        System.out.println(name + " remove: " + (System.currentTimeMillis() - start));
    }
    private static void containsCheck(Set set, String name){
        long start = System.currentTimeMillis();
        for(int i=0; i<count; i++){
            set.remove(i);
        }
        System.out.println(name + " contains: " + (System.currentTimeMillis() - start));
    }



    public static void main(){
        HashSet hashSet = new HashSet();
        TreeSet treeSet = new TreeSet();
        addCheck(hashSet, "HashSet");
        addCheck(treeSet, "TreeSet");
        System.out.println();
        removeCheck(hashSet, "HashSet");
        removeCheck(treeSet, "TreeSet");
        System.out.println();
        containsCheck(hashSet, "HashSet");
        containsCheck(treeSet, "TreeSet");

    }
}
