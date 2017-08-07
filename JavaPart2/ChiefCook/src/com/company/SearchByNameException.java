package com.company;

public class SearchByNameException extends Exception {

    String message;

    public SearchByNameException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[SearchByNameException] Couldn't find an ingredient with name " + message;
    }
}
