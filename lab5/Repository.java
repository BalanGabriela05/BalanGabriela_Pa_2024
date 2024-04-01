package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Repository {
    private String directory;
    private Map<Person, List<Document>> documents = new HashMap<>();

    public Repository(String directory) throws InvalidRepositoryException,MasterRepositoryWrongException {
        File dir = new File(directory);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new InvalidRepositoryException(new Exception("Directory " + directory + " does not exist."));
        }
        this.directory = directory;
        loadDocuments();
    }
    private void loadDocuments() throws MasterRepositoryWrongException {
        File masterDir = new File(directory);
        for (File personDir : Objects.requireNonNull(masterDir.listFiles())) {
            if (personDir.isDirectory()) {
                int id = Integer.parseInt(personDir.getName().split("_")[1]);
                Person person = new Person(id, personDir.getName());
//                System.out.println(person);
                //Exceptie pentru id-uri duplicate
                for (Person existingPerson : documents.keySet()) {
                    if (existingPerson.id() == person.id()) {
                        throw new MasterRepositoryWrongException(new Exception("Duplicate employee ID: " + id));
                    }
                }
                List<Document> personDocuments = new ArrayList<>();
                for (File documentFile : Objects.requireNonNull(personDir.listFiles())) {
                    //Exceptie daca exista director in Master diresctor
                    if (documentFile.isDirectory()) {
                        throw new MasterRepositoryWrongException(new Exception("Unexpected directory in employee's folder: " + documentFile.getPath()));
                    }
                    String format = documentFile.getName().split("\\.")[1];
                    Document document = new Document(documentFile.getName(), format, person);
                    personDocuments.add(document);
                }
                documents.put(person, personDocuments);
            }
        }
    }
//Metoda getPeople() returnează un set cu toți angajații din depozit
    public Set<Person> getPeople() {
        return this.documents.keySet();
    }
//Metoda getDocuments(Person person) returnează lista de documente a unui anumit angajat
    public List<Document> getDocuments(Person person) {
        return this.documents.get(person);
    }

    public void displayContent() {
        try {
            Files.walk(Paths.get(directory))
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("An error occurred while trying to display the content: " + e.getMessage());
        }
    }
}
