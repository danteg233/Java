package com.company;


import java.util.Random;

public class Util {

    public static void printMatrix(Matrix matrix){
        for (int i = 0; i < matrix.getRows(); i++){
            for(int k = 0; k < matrix.getColumns(); k++){
                System.out.print(matrix.getData()[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Fill a matrix with random number in range
    public static void fillMatrix(Matrix matrix, int range){
        Random random = new Random();
        for (int i = 0; i < matrix.getRows(); i++){
            for(int k = 0; k < matrix.getColumns(); k++){
                int randomInt = random.nextInt(range);
                matrix.getData()[i][k] = randomInt;
            }
        }
    }

    // return C = A * B
    public static Matrix times(Matrix matrixA, Matrix matrixB) throws MatrixException {
        if (matrixA.getColumns() != matrixB.getRows()) throw new MatrixException("Can't multiply these matrices... Amount of Matrix A columns should be equal Matrix B rows");
        Matrix matrixC = new Matrix(matrixA.getRows(), matrixB.getColumns());
        for (int i = 0; i < matrixC.getRows(); i++)
            for (int j = 0; j < matrixC.getColumns(); j++)
                for (int k = 0; k < matrixA.getColumns(); k++)
                    matrixC.getData()[i][j] += (matrixA.getData()[i][k] * matrixB.getData()[k][j]);
        return matrixC;
    }

    public static double findDeterminant(Matrix matrix, double[][] a){
        if (matrix.getColumns()==1 && matrix.getRows() == 1) return matrix.getData()[0][0];
        //2x2 matrix
        if (matrix.getColumns() == 2 && matrix.getRows() == 2){
            return (matrix.getData()[0][0] * matrix.getData()[1][1]) - (matrix.getData()[0][1] * matrix.getData()[1][1]);
        }
        //matrix NxN



    private Util(){};
}
