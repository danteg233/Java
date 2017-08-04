package com.company;
//works only with square matrices
public class Main {

    public static int[][] TurnMatrix(int[][] matrix, int n){
        int res[][] = new int[n][n];
        for (int i=0; i < n; i++){
            for (int j=0; j<n; j++){
                res[i][j] = matrix[n-j-1][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] x = TurnMatrix(mat, mat.length);
        for (int i=0; i<3; i++){
            for (int k=0; k<3; k++){
                System.out.print(x[i][k]+ " ");
            }
            System.out.println();
        }
    }
}
