package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] string = {"boxxz123", "apple", "ch"};

        Arrays.sort(string, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String str:string
             ) {
            System.out.println(str);
        }
    }
}
