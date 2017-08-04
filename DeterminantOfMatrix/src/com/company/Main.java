package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] mat2 = {{1,2}, {3,4}};
        int det = (mat2[0][0] * mat2[1][1]) - (mat2[0][1] * mat2[1][1]);
        System.out.println(det);
        //------------------------
        //mat3 = matrix 3x3
        int[][] mat3 = {{1,5,6}, {2,8,7}, {3,2,1}};
        det = ((mat3[0][0]*mat3[1][1]*mat3[2][2]) + (mat3[0][1]*mat3[1][2]*mat3[2][0]) + (mat3[0][2]*mat3[1][0]*mat3[2][1])-
                (mat3[0][2]*mat3[1][1]*mat3[2][0]) - (mat3[0][1]*mat3[1][0]*mat3[2][2]) - (mat3[0][0]*mat3[1][2]*mat3[2][1]));
        System.out.println(det);

    }
}
