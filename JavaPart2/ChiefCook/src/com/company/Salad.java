package com.company;

import sun.invoke.empty.Empty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salad implements Serializable{
    String name;
    private List<Vegetable> ingredients = new ArrayList<>();

    public Salad(){
        this.name = "Unknown";
    }


    public void setName(String name) {
        this.name = name;
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

    public void showByCalories(double lowerCalories, double upperCalories) throws NegativeException {
        if (lowerCalories < 0.0){
            throw new NegativeException("Kcal can not be a negative number!", lowerCalories);
        }
        if (upperCalories < 0.0){
            throw new NegativeException("Kcal can not be a negative number!", upperCalories);
        }
        System.out.println("Show ingredients between " + lowerCalories + " and " + upperCalories + " kcal");
        for (Vegetable vegetable: ingredients) {
            double temp = vegetable.getCalories();
            if (temp > lowerCalories && temp < upperCalories){
                System.out.println(vegetable.getName() + ", " + vegetable.getCalories() + " kcal");
            }
        }
        System.out.println("-------------------");
    }

    public void searchByName(String  searchName) throws SearchByNameException {
        int count = 0;
        for (Vegetable vegetable: ingredients) {
            if (searchName.equals(vegetable.getName())){
                System.out.println(vegetable.toString());
                count++;
            }
        }
        if (count==0){
            throw new SearchByNameException(searchName);
        }
    }
}
