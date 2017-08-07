package com.company;

public class Potato extends Vegetable {
    public Potato(){
        super("Potato", 50);
    }

    public Potato(double calories, double weight) {
        super("Potato", calories, weight);
    }
}
