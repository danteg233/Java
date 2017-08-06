package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	    String [] string = {"Alex", "Nothing", "Something", "Whatever", "Cheeeeeeck!!!"};
        Arrays.sort(string, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length()- s1.toLowerCase().replaceAll("a|e|i|o|u|", "").length() -
                        s2.length()- s2.toLowerCase().replaceAll("a|e|i|o|u|", "").length();
            }
        });

        for (String str: string
             ) {
            System.out.println(str);
        }
    }
}
