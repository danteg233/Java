package com.company;

import java.util.Comparator;

public class ByCountOfVowels implements Comparator<String > {
    @Override
    public int compare(String s1, String s2) {
        return s1.length()- s1.toLowerCase().replaceAll("a|e|i|o|u|", "").length() -
                s2.length()- s2.toLowerCase().replaceAll("a|e|i|o|u|", "").length();
    }
}
