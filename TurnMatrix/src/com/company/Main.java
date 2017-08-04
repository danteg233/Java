package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] mat1 = {{1,2}, {3,4}};
        int[][] mat2 = {{5,6}, {7,8}};
        int[][] mat3 = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                mat3[i][j] = mat1[0][j] * mat2[i][j];
                System.out.println(mat3[i][j]);
            }
        }
//        for (int i=0; i <2; i++){
//            for (int k=0; k<2; k++){
//                System.out.println(mat3[i][k]);
//            }
//        }
    }
}
