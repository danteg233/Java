package com.company;

public class SimpleCalc {

    public static float Add(float a, float b){return a+b;}
    public static float Sub(float a, float b){return a-b;}
    public static float Mul(float a, float b) {return a*b;}
    public static float Dev(float a, float b) throws ArithmeticException {
        if (b==0) throw new ArithmeticException();
        return a/b;
    }
}
