package com.company;

public class Tomato extends Vegetable {

    Tomato(){
        super("Tomato", 30);
    }

    Tomato(double weight, double calories){
        super("Tomato", calories, weight);
    }
}
