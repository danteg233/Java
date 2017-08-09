package com.company.Comparators;

import com.company.model.Salad;

import java.util.Comparator;

public class CaloriesComparator implements Comparator<Salad>{

    @Override
    public int compare(Salad s1, Salad s2) {
        return (int) (s1.countCalories() - s2.countCalories());
    }
}
