package com.company.model;

import com.company.model.Vegetable;

public class Potato extends Vegetable {
    public Potato(){
        super("Potato", 50);
    }

    public Potato(double calories, double weight) {
        super("Potato", calories, weight);
    }
}
