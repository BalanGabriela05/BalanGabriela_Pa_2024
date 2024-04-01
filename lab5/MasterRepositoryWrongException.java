package org.example;

public class MasterRepositoryWrongException extends Exception {
    public MasterRepositoryWrongException(Exception e){
        super("Error at Master Directory : " + e);
    }
}
