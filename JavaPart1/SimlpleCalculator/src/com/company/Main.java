package com.company;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in).useDelimiter("\n");

    public static double Add(double a, double b){
        return a+b;
    }
    public static float Min(float a, float b){
        return a-b;
    }
    public static  double Mul(double a, double b){
        return a*b;
    }
    public static double Dev(double a, double b){
        return (b==0) ? 0.0 : a/b;
    }

    public static void main(String[] args) {
        char ans = 'a';
        float a = 0;
        float b = 0;
            do {
                try {
                    System.out.println("Enter 1-st number: ");
                     a = input.nextFloat();
                    System.out.println("Enter 2-nd number: ");
                     b = input.nextFloat();

                }catch (InputMismatchException e){
                    System.out.println("Wrong input.. Try again");
                }
                System.out.println("Choose action (+,-,*,/): ");
                char c = input.next(".").charAt(0);

                switch (c){
//                    case '+': System.out.println(a + " + " + b + " = " + Add(a, b)); break;
                    case '-': System.out.println(a + " - " + b + " = " + Min(a, b)); break;
//                    case '*': System.out.println(a + " * " + b + " = " + Mul(a, b)); break;
//                    case '/': System.out.println(a + " / " + b + " = " + Dev(a, b)); break;
                    default: System.out.println("Wrong sign!!!"); break;
                }
                System.out.println("Continue?(y/n)");
                Scanner scanner = new Scanner(System.in);
                ans = scanner.next(".").charAt(0);
            }while(ans!='n');
    }
}
