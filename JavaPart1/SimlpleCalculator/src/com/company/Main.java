package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        char sing,  ans = 'a';
        float a,b;
        do{
            try{
                System.out.println("Enter 1-st number: ");
                a = input.nextFloat();
                System.out.println("Enter 2-nd number: ");
                b = input.nextFloat();
            }catch (InputMismatchException e){
                System.out.println("Wrong input.. Try again..");
                input.next();
                continue;
            }
            System.out.println("Select action (+,-,*,/): ");
            sing = input.next().charAt(0);
            switch (sing){
                case '+' : System.out.println(a + " + " + b + " = " + SimpleCalc.Add(a, b)); break;
                case '-' : System.out.println(a + " - " + b + " = " + SimpleCalc.Sub(a, b)); break;
                case '*' : System.out.println(a + " * " + b + " = " + SimpleCalc.Mul(a, b)); break;
                case '/' : try{
                    System.out.println(a + " / " + b + " = " + SimpleCalc.Dev(a, b));
                    break;
                } catch (ArithmeticException e){
                    System.out.println("Cannot divide by 0!");
                    break;
                }
            }
            System.out.println("Continue (y/n): ");
            ans = input.next().charAt(0);

        }while(ans != 'n');
    }
}
