package com.company;

import java.util.Comparator;

public class WeightComparator implements Comparator<Vegetable> {
    @Override
    public int compare(Vegetable v1, Vegetable v2) {
        return (int) (v1.getWeight() - v2.getWeight());
    }
}
