package com.example.resttest.exception.type;



public class NoDataException extends RuntimeException{
    public NoDataException() {
        super("Data not found");
    }
}
