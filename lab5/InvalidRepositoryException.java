package org.example;

public class InvalidRepositoryException extends Exception{
    public InvalidRepositoryException(Exception e){
        super("Error at Directory : " + e);
    }

}
