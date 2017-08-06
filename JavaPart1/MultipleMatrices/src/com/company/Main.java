package com.company;

public class Main {

    public static int[][] MultiplyMatrices(int[][] matA, int[][] matB){

        if (matA[0].length != matB.length){
            System.out.println("Can't multiply these matrices");
            return null;
        }

        int[][] res = new int[matA.length][matB[0].length];
        for (int i=0; i< matA.length; i++){
            for (int j=0; j< matB[0].length; j++){
                for (int s=0; s< matA[0].length; s++){
                    res[i][j] += matA[i][s]*matB[s][j];
                }
            }
        }

        /* Output result */
        for (int i=0; i<res.length;i++){
            for(int k=0; k<res.length; k++) {
                System.out.print(res[i][k] + " ");
            }
            System.out.println();
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1,3}, {7,2}};
        int[][] mat2 = {{4,8}, {0,1}};
        MultiplyMatrices(mat1,mat2);

    }
}
