package com.company;

public class Potato extends Vegetable {
    Potato(){
        super("Potato", 50);
    }

    Potato(double calories, double weight) {
        super("Potato", calories, weight);
    }
}
