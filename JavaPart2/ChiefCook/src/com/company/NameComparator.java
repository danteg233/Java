package com.company;

import java.util.Comparator;

public class NameComparator implements Comparator<Vegetable> {
    @Override
    public int compare(Vegetable v1, Vegetable v2) {
        return v2.getName().length() - v1.getName().length();
    }
}
