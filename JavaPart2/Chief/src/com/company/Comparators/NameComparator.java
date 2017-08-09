package com.company.Comparators;

import com.company.model.Salad;

import java.util.Comparator;

public class NameComparator implements Comparator<Salad> {
    @Override

    public int compare(Salad s1, Salad s2) {

        return (s1.getName().compareTo(s2.getName()));
    }
}
