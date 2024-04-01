package org.example;

public class ExportFailedException extends Exception {
    public ExportFailedException(Exception e){
        super(e);
    }
}
