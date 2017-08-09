package com.company.Exceptions;

//If calories is below 0, then program throw this Exception

public class NegativeException extends Exception {

    double number;

    public NegativeException(String message, double number){
        super(message);
        this.number = number;
    }

}
