package org.example;

public interface Command {
    void execute(String... args) throws ExportFailedException,ReportGenerationException, InvalidCommandException, InvalidArgumentsException, DocumentNotFoundException;;
}

