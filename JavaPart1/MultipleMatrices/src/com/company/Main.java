package com.company;

public class Main {

    public static void main(String[] args) {
        Matrix m1 = new Matrix(2,2);
        Matrix m2 = new Matrix(2,2);
        m1.fill(5);
        m1.printMatrix();
        m2.fill(3);
        m2.printMatrix();
        Matrix m3 = m1.times(m2);
        m3.printMatrix();

    }
}
