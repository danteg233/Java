package com.company.model;

import java.io.Serializable;

public class Vegetable implements Serializable {

    String name;
    double calories;
    double weight;

    Vegetable(String name){
        this.name = name;
        this.weight = 100;
    }

    Vegetable(String name, double calories){
        if (calories < 0){
            throw new IllegalArgumentException("Can't create vegetable with " + calories + "kcal");
        }
        this.name = name;
        this.calories = calories;
        this.weight = 100;

    }


    Vegetable(String name, double calories, double weight){
        if (calories < 0.0){
            throw new IllegalArgumentException("Can't create vegetable with " + calories + "kcal");
        }
        if (weight < 0.0){
            throw new IllegalArgumentException("Can't create vegetable with " + weight + "weight");
        }
        this.name = name;
        this.calories = calories;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return (weight + " gramm of " + name + " : " + calories + " kcal");
    }

    public double getCalories() {
        return calories;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object){
        return (this.name.equals(((Vegetable)object).getName()));
    }

}
