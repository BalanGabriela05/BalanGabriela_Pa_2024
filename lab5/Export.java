package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Export implements Command {
    private final Repository repository;

    public Export(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String... args) throws ExportFailedException {
        ObjectMapper mapper = new ObjectMapper();

        // Crează un model de date
        /**
         * people -> fiecare element al listei va fi o hartă care reprezintă un angajat și documentele sale
         * personData -> o hartă pentru a stoca datele despre angajatul curent
         * documents -> listă pentru a stoca documentele angajatului curent
         */
        List<Map<String, Object>> people = new ArrayList<>();

        for (Person person : repository.getPeople()) {
            Map<String, Object> personData = new HashMap<>();
            personData.put("id", person.id());
            personData.put("name", person.name());

            List<Map<String, String>> documents = new ArrayList<>();
            for (Document document : repository.getDocuments(person)) {
                Map<String, String> documentData = new HashMap<>();
                documentData.put("name", document.name());
                documentData.put("format", document.format());
                documents.add(documentData);
            }

            personData.put("documents", documents);
            people.add(personData);
        }

        // Converteste modelul de date într-un șir JSON
        String json;
        try {
            json = mapper.writeValueAsString(people);
        } catch (IOException e) {
            throw new ExportFailedException(new Exception("Eroare la convertirea datelor în JSON: " + e.getMessage()));
        }

        // Scrie șirul JSON într-un fișier
        try (FileWriter file = new FileWriter("repository.json")) {
            file.write(json);
        } catch (IOException e) {
            throw new ExportFailedException(new Exception("Eroare la scrierea JSON-ului în fișier: " + e.getMessage()));
        }
    }



}
