package com.company;


import java.io.*;
import java.lang.reflect.Constructor;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Chief {

    private Salad salad = new Salad();
    private Vegetable vegetable = null;
    private String file = "D:\\GitProjects\\Java\\JavaPart2\\ChiefCook\\test.ser";

    public Vegetable getIngredient(Scanner scanner) {               //Creating an ingredient for salad
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
            System.out.println("Error");
            e.getStackTrace();
            return null;
        }

    }


    public void showMenu()
    {
        int choice = -1;
        while(choice!=0){
            System.out.println("1 - Show recipe");
            System.out.println("2 - Rename recipe");
            System.out.println("3 - Add ingredient");
            System.out.println("4 - Sort by weight");
            System.out.println("5 - Sort by name");
            System.out.println("6 - Sort by calories");
            System.out.println("7 - Show by range of calories");
            System.out.println("8 - Search ingredient by name");
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
                    salad.showRecipe();
                    break;

                case 2:
                    System.out.println("Name your Salad: ");
                    salad.setName(scanner.next());
                    break;

                case 3:
                    vegetable = getIngredient(scanner);
                    if (vegetable != null) {
                        salad.addIngredient(vegetable);
                    }
                    break;

                case 4:
                    salad.sortByWeight();
                    salad.showRecipe();
                    break;

                case 5:
                    salad.sortByName();
                    salad.showRecipe();
                    break;

                case 6:
                    salad.sortByCalories();
                    salad.showRecipe();
                    break;

                case 7:
                    try{
                        System.out.println("Enter lower calories: ");
                        double lowerCalories = scanner.nextDouble();
                        System.out.println("Enter upper calories: ");
                        double upperCalories = scanner.nextDouble();
                        salad.showByCalories(lowerCalories, upperCalories);
                        break;
                    }catch (InputMismatchException e){
                        System.out.println("Wrong input!");
                        scanner.next();
                        break;
                    }catch (NegativeException e){                   //Here we catch NegativeException
                        System.out.println(e.getMessage());
                        break;
                    }
                case 8:
                    System.out.println("Enter name of needed ingredient: ");    //Here we catch SearchByNameException
                    String neededIngredient = scanner.next();
                    try{
                        salad.searchByName(neededIngredient);
                        break;
                    }catch (SearchByNameException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                case 9:
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(salad);
                        break;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case 10:
                    try{
                        FileInputStream fin = new FileInputStream(file);
                        ObjectInputStream ois = new ObjectInputStream(fin);
                        salad = (Salad) ois.readObject();
                        break;
                    }catch (Exception e){
                        System.out.println("error" + e.getMessage());
                        break;
                    }


                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong input, try again..."); break;
            }
        }
    }
}
