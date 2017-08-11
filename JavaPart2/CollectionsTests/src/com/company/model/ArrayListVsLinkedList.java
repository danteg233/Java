package com.company.model;

import java.util.*;

public class ArrayListVsLinkedList {

    private static int count = 100000;

    private static void addCheck(List list, String name) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        System.out.println(name + " add: " + (System.currentTimeMillis() - start));
    }

    private static void getCheck(List list, String name) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.get(i);
        }
        System.out.println(name + " get: " + (System.currentTimeMillis() - start));
    }

    private static void removeCheck(List list, String name) {
        long start = System.currentTimeMillis();
        for (int i = 9999; i >= 0; i--) {
            list.remove(i);
        }
        System.out.println(name + " remove: " + (System.currentTimeMillis() - start));
    }

    public static void Main() {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        addCheck(arrayList, "ArrayList");
        addCheck(linkedList, "LinkedList");
        System.out.println();
        getCheck(arrayList, "ArrayList");
        getCheck(linkedList, "LinkedList");
        System.out.println();
        removeCheck(arrayList, "ArrayList");
        removeCheck(linkedList, "LinkedList");
    }
}
