package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in).useDelimiter("\n");

    public static float Add(float a, float b){
        return a+b;
    }

    public static float Min(float a, float b){
        return a-b;
    }

    public static  float Mul(float a, float b){
        return a*b;
    }
    public static float Dev(float a, float b){
        return (b==0) ? 0 : a/b;
    }

    public static void main(String[] args) {
        char ans = 'a';
        try{
            do {
                System.out.println("Enter 1-st number: ");
                float a = input.nextFloat();
                System.out.println("Choose action (+,-,*,/): ");
                char c = input.next(".").charAt(0);
                System.out.println("Enter 2-nd number: ");
                float b = input.nextFloat();
                switch (c){
                    case '+': System.out.println(a + " + " + b + " = " + Add(a, b)); break;
                    case '-': System.out.println(a + " - " + b + " = " + Min(a, b)); break;
                    case '*': System.out.println(a + " * " + b + " = " + Mul(a, b)); break;
                    case '/': System.out.println(a + " / " + b + " = " + Dev(a, b)); break;
                    default: System.out.println("Wrong sign!!!"); break;
                }

                System.out.println("Continue?(y/n)");
                Scanner scanner = new Scanner(System.in);
                ans = scanner.next(".").charAt(0);
            }while(ans!='n');
        }catch (InputMismatchException e){
            System.err.println("Invalid input!");
        }
    }
}
