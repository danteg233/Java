package com.company;

import java.util.Random;

final public class Matrix {
    private final int rows;             // number of rows
    private final int columns;             // number of columns
    private final double[][] data;   // rows-by-columns array

    // create rows-by-columns matrix of 0's
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        data = new double[rows][columns];
    }

    // create matrix based on 2d array
    public Matrix(double[][] data) {
        rows = data.length;
        columns = data[0].length;
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                this.data[i][j] = data[i][j];
    }

    //Fill a matrix with random number in range
    public void fill(int range){
        Random random = new Random();
        for (int i = 0; i < this.rows; i++){
            for(int k = 0; k < this.columns; k++){
                int randomInt = random.nextInt(range);
                this.data[i][k] = randomInt;
            }
        }
    }

    public void printMatrix(){
        for (int i = 0; i < this.rows; i++){
            for(int k = 0; k < this.columns; k++){
                System.out.print(this.data[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    // return C = A * B
    public Matrix times(Matrix B) {
        Matrix A = this;
        if (A.columns != B.rows) throw new RuntimeException("Can't multiply these matrices...");
        Matrix C = new Matrix(A.rows, B.columns);
        for (int i = 0; i < C.rows; i++)
            for (int j = 0; j < C.columns; j++)
                for (int k = 0; k < A.columns; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        return C;
    }
}
