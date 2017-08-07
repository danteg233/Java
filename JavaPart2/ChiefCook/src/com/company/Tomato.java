package com.company;

public class Tomato extends Vegetable {

    public Tomato(){
        super("Tomato", 30);
    }


    public Tomato(double weight, double calories){
        super("Tomato", calories, weight);
    }
}
