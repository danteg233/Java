package com.company;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Chief {

    private Salad salad = new Salad();
    private Vegetable vegetable = null;

    public Vegetable getIngredient(Scanner scanner) {
        String ingredientName;
        double weight;

        System.out.println("Enter ingredient name: ");
        ingredientName = scanner.nextLine();
        System.out.println("Enter weight: ");
        weight = scanner.nextDouble();
        try{
            ingredientName = "com.comany.Vegetable." + ingredientName;
            Class ingredientClass = Class.forName(ingredientName);
            



        }catch (ClassNotFoundException e) {
            return null;
        }
        return null;
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
                    salad.setName(scanner.nextLine());
                    break;

                case 3:
                    vegetable = getIngredient(scanner);
                    if (vegetable != null) {
                        if (!salad.addIngredient(vegetable)) {
                            System.out.println("Cannot add ingredient!");
                        }
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
                    }


                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong input, try again!"); break;
            }
        }
    }
}
