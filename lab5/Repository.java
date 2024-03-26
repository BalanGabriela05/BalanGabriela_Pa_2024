package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private String directory;
    private Map<Person, List<Document>> documents = new HashMap<>();

    public Repository(String directory) {
        this.directory = directory;
        loadDocuments();
    }

    private void loadDocuments() {
        File masterDir = new File(directory);
        for (File personDir : masterDir.listFiles()) {
            if (personDir.isDirectory()) {
                // id-ul este inclus în numele directorului
                int id = Integer.parseInt(personDir.getName().split("_")[1]);
                Person person = new Person(id, personDir.getName());
                List<Document> personDocuments = new ArrayList<>();
                for (File documentFile : personDir.listFiles()) {
                    //formatul este inclus în numele fișierului
                    String format = documentFile.getName().split("\\.")[1];
                    Document document = new Document(documentFile.getName(), format, person);
                    personDocuments.add(document);
                }
                documents.put(person, personDocuments);
            }
        }
    }



    public void displayContent() throws IOException {
        Files.walk(Paths.get(directory))
                .filter(Files::isRegularFile)
                .forEach(System.out::println);
    }
}
