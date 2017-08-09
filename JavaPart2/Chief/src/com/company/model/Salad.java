package com.company.model;


import com.company.Exceptions.NegativeException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Salad implements Serializable{
    String name;
    private List<Vegetable> ingredients = new ArrayList<>();

    public Salad(String name){this.name = name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addIngredient(Vegetable vegetable){
        if (ingredients.contains(vegetable)){
            System.out.println("This salad already contains this ingredient");
            return;
        }
        ingredients.add(vegetable);
    }

    public void showRecipe()
    {
        if (ingredients.isEmpty()){
            System.out.println("The salad doesn't have any ingredients...");
            return;
        }
        System.out.println("\nThe salad " + "'" + name + "'" + " contains:");
        System.out.println("-------------------");
        for (Vegetable vegetable:ingredients) {
            System.out.println(vegetable.toString());
        }
        System.out.println("-------------------");
        System.out.println("Total weight: " + countWeight() + "\tTotal kcal: " + countCalories());
        System.out.println();
    }

    public double countCalories() {
        double cal = 0.0;
        for (Vegetable vegetable: ingredients) {
            cal += vegetable.getCalories();
        }
        return cal;
    }
    public double countWeight(){
        double temp = 0.0;
        for (Vegetable vegetable: ingredients) {
            temp += vegetable.getWeight();
        }
        return temp;
    }


    public void showByCalories(double lowerCalories, double upperCalories) throws NegativeException {
        if (lowerCalories < 0.0){
            throw new NegativeException("Kcal can not be a negative number!", lowerCalories);
        }
        if (upperCalories < 0.0){
            throw new NegativeException("Kcal can not be a negative number!", upperCalories);
        }
        System.out.println("Show ingredients between " + lowerCalories + " and " + upperCalories + " kcal" + " from " +  "'" + name + "'" + " salad");
        for (Vegetable vegetable: ingredients) {
            double temp = vegetable.getCalories();
            if (temp > lowerCalories && temp < upperCalories){
                System.out.println(vegetable.getName() + ", " + vegetable.getCalories() + " kcal");
            }
        }

    }

    public boolean searchByName(String  searchName){
        List<Vegetable> temp = new ArrayList<>();
        for (Vegetable vegetable: ingredients) {
            if (searchName.equals(vegetable.getName())){
                temp.add(vegetable);
            }
        }
        if (temp.isEmpty()){
            return false;
        }
        return true;

    }

    @Override
    public boolean equals(Object object){
        return (this.name.equals(((Salad)object).getName()));
    }


}
