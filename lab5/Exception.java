package org.example;

public class Exception {
    public Exception(String message) {
    }
}
class DocumentException extends Exception {
    public DocumentException(String message) {
        super(message);
    }
}

class PersonException extends Exception {
    public PersonException(String message) {
        super(message);
    }
}