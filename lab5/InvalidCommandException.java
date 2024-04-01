package org.example;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(Exception e){
        super(e);
    }
}
