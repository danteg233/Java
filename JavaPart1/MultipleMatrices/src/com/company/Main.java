package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c = 'a';
        int rows_1,columns_1, range_1, rows_2, columns_2, range_2;
        do{
            try{
                System.out.println("Enter number of rows of 1-st matrix: ");
                rows_1 = scanner.nextInt();
                System.out.println("Enter number of columns of 1-st matrix: ");
                columns_1 = scanner.nextInt();
                System.out.println("Enter a range of 1-st matrix: ");
                range_1 = scanner.nextInt();
                System.out.println("Enter number of rows of 2-nd matrix: ");
                rows_2 = scanner.nextInt();
                System.out.println("Enter number of columns of 2-nd matrix: ");
                columns_2 = scanner.nextInt();
                System.out.println("Enter a range of 2-nd matrix: ");
                range_2 = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Wrong input.. Try again...");
                scanner.next();
                continue;
            }
            Matrix m1 = new Matrix(rows_1,columns_1);
            Matrix m2 = new Matrix(rows_2,columns_2);
            Util.fillMatrix(m1, range_1);
            Util.fillMatrix(m2, range_2);
            try{
                Matrix m3 = Util.times(m1, m2);
                System.out.println("1-st matrix: ");
                Util.printMatrix(m1);
                System.out.println("2-nd matrix: ");
                Util.printMatrix(m2);
                System.out.println("Product of A*B: ");
                Util.printMatrix(m3);
                //------------------------
                //TURN MATRIX
                System.out.println("Turn 1-st matrix: \n");
                Matrix temp = Util.TurnMatrix(m1);
                Util.printMatrix(temp);
            }catch (MatrixException e){
                System.out.println(e.getMessage());
            }catch (NotEqualException e){
                System.out.println(e.getMessage());
            }
            System.out.println("Continue(y/n): ");
            c = scanner.next().charAt(0);
        }while(c != 'n');



    }
}
