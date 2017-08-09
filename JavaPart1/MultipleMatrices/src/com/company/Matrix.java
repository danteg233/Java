package com.company;



final public class Matrix {
    private final int rows;
    private final int columns;
    private final double[][] data;   // rows-by-columns array

    // create rows-by-columns matrix of 0's
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        data = new double[rows][columns];
    }

    // Create matrix based on 2d array
    public Matrix(double[][] data) {
        rows = data.length;
        columns = data[0].length;
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                this.data[i][j] = data[i][j];
    }


    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public double[][] getData() {
        return data;
    }
}
