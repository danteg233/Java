package com.company.comparators;

import com.company.model.Salad;

import java.util.Comparator;

public class WeightComparator implements Comparator<Salad> {


    @Override
    public int compare(Salad s1, Salad s2) {
        return (int) (s1.countWeight() - s2.countWeight());
    }
}
