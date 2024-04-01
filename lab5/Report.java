package org.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report implements Command {
    private final Configuration cfg;
    private final Repository repository;

    public Report(Repository repository) throws ReportGenerationException {
        this.repository = repository;
        cfg = new Configuration(Configuration.VERSION_2_3_30);
        try {
            cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\Gabriela\\Documents\\BalanGabriela_Pa_2024\\LAB5\\untitled2\\src\\main\\resources"));
        } catch (IOException e) {
            throw new ReportGenerationException(new Exception("Eroare la încărcarea șablonului: " + e.getMessage()));
        }
    }

    @Override
    public void execute(String... args) throws ReportGenerationException {
        /**
         * model va fi folosit pentru a stoca datele care vor fi introduse în șablonul HTML
         * employees stocheaza informațiile despre angajați și documentele lor
         * documentDataList stocheaza datele despre documentele angajatului
         */
        Map<String, Object> model = new HashMap<>();
        Map<String, List<Map<String, String>>> employees = new HashMap<>();
        for (Person person : repository.getPeople()) {
            List<Document> personDocuments = repository.getDocuments(person);
            List<Map<String, String>> documentDataList = new ArrayList<>();
            for (Document document : personDocuments) {
                Map<String, String> documentData = new HashMap<>();
                documentData.put("name", document.name());
                documentData.put("format", document.format());
                documentDataList.add(documentData);
            }
            employees.put(person.name(), documentDataList);
        }
        //Adaugă HashMap-ul de angajați în modelul de date
        model.put("employees", employees);

        try {
            Template template = cfg.getTemplate("report.ftl");

            // Scrie raportul HTML într-un fișier folosind șablonul și modelul de date
            try (Writer fileWriter = new FileWriter("report.html")) {
                template.process(model, fileWriter);
            }

            // Deschide raportul în browserul implicit al sistemului de operare
            Desktop.getDesktop().browse(new File("report.html").toURI());
        } catch (IOException | TemplateException e) {
            throw new ReportGenerationException(new Exception("Eroare la crearea raportului: " + e.getMessage()));
        }
    }
}
