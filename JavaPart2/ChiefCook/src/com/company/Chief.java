package com.company;


import com.company.Comparators.CaloriesComparator;
import com.company.Comparators.NameComparator;
import com.company.Comparators.WeightComparator;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.*;

public class Chief implements Serializable {

    private List<Salad> salads = new ArrayList<>();
    private Vegetable vegetable = null;
    private static final String file = "test.ser";

    private Vegetable getIngredient(Scanner scanner) {               //Creating an ingredient for salad
        String ingredientName;
        double weight;
        double calories;
        System.out.println("Enter ingredient name: ");
        ingredientName = scanner.next();
        try{
            System.out.println("Enter weight: ");
            weight = scanner.nextDouble();
            System.out.println("Enter kcal(per 100 gr): ");
            calories = scanner.nextDouble();
        }catch (InputMismatchException e){
            System.out.println("Wrong input!");
            scanner.next();
            return null;
        }

        try{
            ingredientName = "com.company." + ingredientName;
            Class <?> ingredientClass = Class.forName(ingredientName);
            Constructor <?> constructor = ingredientClass.getConstructor(new Class[]{double.class, double.class});
            vegetable = (Vegetable) constructor.newInstance(calories, weight);
            return vegetable;                                                       //If ingredient exist then we return it,
                                                                                    //otherwise null

        }catch (Exception e) {
            System.out.println("Couldn't find a class with name  " + ingredientName);
            return null;
        }catch (NoClassDefFoundError e){
            System.out.println("[NoClassDefFoundError] " + e.getMessage());
            return null;
        }

    }

    private int getIndexByName(String name){
        for (Salad salad: salads) {
            if (salad.getName().equals(name)){
                return salads.indexOf(salad);
            }
        }
        return -1;
    }

    public void showMenu()
    {
        int choice = -1;
        while(choice!=0){
            System.out.println("1 - Show all recipes");
            System.out.println("2 - Add recipe");
            System.out.println("3 - Rename recipe");
            System.out.println("4 - Add ingredient");
            System.out.println("5 - Sort salads by weight");
            System.out.println("6 - Sort salads by name");
            System.out.println("7 - Sort salads by calories");
            System.out.println("8 - Show ingredients by range of calories");
            System.out.println("------------------------------");
            System.out.println("9 - Write into file");
            System.out.println("10 - Read from file");
            System.out.println("------------------------------");
            System.out.println("0 - Exit");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.print("Enter only digits!");
                scanner.next();
                choice = -1;
            }

            switch (choice){
                case 1:
                    if (salads.isEmpty()){
                        System.out.println("You haven't added any recipes yet. Please add first..");
                        break;
                    }
                    for (Salad salad: salads) {
                        salad.showRecipe();
                    }
                    break;

                case 2:
                    System.out.println("Name your Salad: ");
                    Salad salad = new Salad(scanner.next());
                    salads.add(salad);
                    break;

                case 3:
                    if (salads.isEmpty()){
                        System.out.println("You haven't added any recipes yet. Please add first..");
                        break;
                    }
                    System.out.println("Enter name you want to change: ");
                    String oldName = scanner.next();
                    int i = getIndexByName(oldName);
                    if (i != -1){
                        System.out.println("Enter new name: ");
                        String newName = scanner.next();
                        salads.get(i).setName(newName);
                        break;
                        }
                        System.out.println("Couldn't find a salad with name " + "'" + oldName +"'");
                    break;



                case 4:
                    System.out.println("Enter name of salad: ");
                    String name = scanner.next();
                    try {
                        int indexByName = getIndexByName(name);
                        if (indexByName != -1){
                            vegetable = getIngredient(scanner);
                            if (vegetable != null){
                                salads.get(indexByName).addIngredient(vegetable);
                                break;
                            }
                            break;
                        }
                        System.out.println("Couldn't find salad with name: " + "'" + name + "'");
                        break;

                    }catch (Exception e){
                        System.out.println("error");
                        break;
                    }


                case 5:
                    Collections.sort(salads, new WeightComparator());                   //Sorting by WEIGHT
                    if (salads.isEmpty()){
                        System.out.println("You haven't added any recipes yet. Please add first..");
                        break;
                    }
                    System.out.println("======== SORTED BY WEIGHT OF SALADS ========");
                    for (Salad salad1: salads) {
                        salad1.showRecipe();
                    }
                    break;

                case 6:
                    Collections.sort(salads, new NameComparator());
                    if (salads.isEmpty()){
                        System.out.println("You haven't added any recipes yet. Please add first..");
                        break;
                    }
                    System.out.println("======== SORTED BY NAMES OF SALADS ========");
                    for (Salad salad1: salads) {
                        salad1.showRecipe();
                    }
                    break;

                case 7:
                    Collections.sort(salads, new CaloriesComparator());
                    if (salads.isEmpty()){
                        System.out.println("You haven't added any recipes yet. Please add first..");
                        break;
                    }
                    System.out.println("======== SORTED BY CALORIES OF SALADS ========");
                    for (Salad salad1: salads) {
                        salad1.showRecipe();
                    }
                    break;

                case 8:
                    try{
                        System.out.println("Enter lower calories: ");
                        double lowerCalories = scanner.nextDouble();
                        System.out.println("Enter upper calories: ");
                        double upperCalories = scanner.nextDouble();
                        for (Salad salad2 : salads) {
                            salad2.showByCalories(lowerCalories, upperCalories);
                        }
                        break;
                    }catch (InputMismatchException e){
                        System.out.println("Wrong input!");
                        scanner.next();
                        break;
                    }catch (NegativeException e){                   //Here we catch NegativeException
                        System.out.println(e.getMessage());
                        break;
                    }



                case 9:
                    try(final ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))){
                        for (Salad salad2 : salads) {
                            outputStream.writeObject(salad2);
                        }
                    }catch (Exception e) {
                        System.out.println("Error" + e.getMessage());
                        break;
                    }
                    break;


                case 10:
                    ArrayList<Salad> sal;
                    try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
                        sal = (ArrayList<Salad>)objectInputStream.readObject();
                    }catch (ClassCastException e){
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong input, try again..."); break;
            }
        }
    }
}
