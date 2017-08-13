package com.company.model;

import com.company.model.Vegetable;

public class Tomato extends Vegetable {

    public Tomato(){
        super("Tomato", 30);
    }


    public Tomato(double weight, double calories){
        super("Tomato", weight, calories);
    }
}
