package com.company;

public class Cucumber extends Vegetable {
    Cucumber(){
        super("Cucumber", 42);
    }

    Cucumber(double calories, double weight){
        super("Potato", calories, weight);
    }
}
