package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salad {
    String name;
    private List<Vegetable> ingredients = new ArrayList<Vegetable>();

    public Salad(){
        this.name = "Unknown";
    }
    public Salad(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addIngredient(Vegetable vegetable){
        return ingredients.add(vegetable);
    }

    public void showRecipe()
    {
        if (ingredients.isEmpty()){
            System.out.println("The salad doesn't have any ingredients...");
            return;
        }
        System.out.println("The salad " + name + " contains:");
        System.out.println("-------------------");
        for (Vegetable vegetable:ingredients) {
            System.out.println(vegetable.toString());
        }
        System.out.println("-------------------");
        System.out.println("Total kcal: " + countCalories());
    }

    private double countCalories() {
        double cal = 0.0;
        for (Vegetable vegetable: ingredients) {
            cal += vegetable.getCalories();
        }
        return cal;
    }

    public void sortByWeight()
    {
        Collections.sort(ingredients, new WeightComparator());
    }

    public void sortByName()
    {
        Collections.sort(ingredients, new NameComparator());
    }

    public void sortByCalories()
    {
        Collections.sort(ingredients, new CaloriesComparator());
    }

    public void showByCalories(double lowerCalories, double upperCalories){
        System.out.println("Show ingredients between " + lowerCalories + " and " + upperCalories + " kcal");
        for (Vegetable vegetable: ingredients) {
            double temp = vegetable.getCalories();
            if (temp > lowerCalories && temp < upperCalories){
                System.out.println(vegetable.getName() + ", " + vegetable.getCalories() + " kcal");
            }
            System.out.println("-------------------");
        }
    }


}
