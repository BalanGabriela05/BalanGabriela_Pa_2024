package org.example;

public class InvalidArgumentsException extends Exception{
    public InvalidArgumentsException(Exception e){
        super(e);
    }
}
