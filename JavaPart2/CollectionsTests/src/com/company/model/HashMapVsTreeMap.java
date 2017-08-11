package com.company.model;

import java.util.*;

public class HashMapVsTreeMap {

        private static HashMap<String, String> hashMap = new HashMap<>();
        private static TreeMap<String, String> treeMap = new TreeMap<>();
        private static ArrayList<String> list = new ArrayList<>();
        private static int count = 10000;

        static {
            for (int i = 0; i < count; i++) {
                list.add(Integer.toString(i, 16));
            }
        }


        public static void main() {
            /*Warm up for put*/
            for (int i = 0; i < 1000; i++) {
                put(hashMap);
                put(treeMap);
            }
            measureTimeToPut(hashMap, "HashMap", 1000);
            measureTimeToPut(treeMap, "TreeMap", 1000);
            System.out.println();
             /*Warm up for get*/
            for (int i = 0; i < 1000; i++) {
                get(hashMap);
                get(treeMap);
            }
            measureTimeToGet(hashMap, "HashMap", 1000);
            measureTimeToGet(treeMap, "TreeMap", 1000);
            System.out.println();

            measureTimeToRemove(hashMap, "HashMap", 1000);
            measureTimeToRemove(treeMap, "TreeMap", 1000);

        }

        private static void get(Map<String, String> map) {
            for (String s : list) {
                map.get(s);
            }

        }

        private static void put(Map<String, String> map) {
            map.clear();
            for (String s : list) {
                map.put(s, s);
            }
        }

        private static void remove(Map<String, String> map){
            for (String s : list){
                map.remove(s);
            }
        }


        private static void measureTimeToPut(Map<String, String> map, String setName, int reps) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < reps; i++) {
                put(map);
            }
            long finish = System.currentTimeMillis();
            System.out.println("Time to put " + (reps * map.size()) + " entries in a " + setName + ": " + (finish - start));
        }

        private static void measureTimeToGet(Map<String, String> map, String setName, int reps) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < reps; i++) {
                get(map);
            }
            long finish = System.currentTimeMillis();
            System.out.println("Time to get " + (reps * map.size()) + " entries in a " + setName + ": " + (finish - start));
        }

        private static void measureTimeToRemove(Map<String, String> map, String setName, int reps) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < reps; i++) {
                remove(map);
            }
            long finish = System.currentTimeMillis();
            System.out.println("Time to remove in a " + setName + ": " + (finish - start));
        }

}

