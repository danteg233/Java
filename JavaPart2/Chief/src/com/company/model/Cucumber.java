package com.company.model;

import com.company.model.Vegetable;

public class Cucumber extends Vegetable {
    public Cucumber(){
        super("Cucumber", 42);
    }

    public Cucumber(double calories, double weight){
        super("Cucumber", calories, weight);
    }
}
