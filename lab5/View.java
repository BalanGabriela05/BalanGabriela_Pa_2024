package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
public class View implements Command {
    @Override
    public void execute(String... args) throws InvalidArgumentsException, DocumentNotFoundException {
       //Verific dacă a fost furnizată o cale de fișier (filePath)
        if (args.length == 0) {
            throw new InvalidArgumentsException(new Exception("No file path provided."));
        }

        String filePath = args[0];
        File file = new File(filePath);

        if (!file.exists()) {
            throw new DocumentNotFoundException(new Exception("File " + filePath + " does not exist."));
        }

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            throw new DocumentNotFoundException(new Exception("Unable to open the file: " + filePath));
        }
    }
}
//C:\Users\Gabriela\Documents\BalanGabriela_Pa_2024\LAB5\masterFile\Ana_4\FileAna.txt