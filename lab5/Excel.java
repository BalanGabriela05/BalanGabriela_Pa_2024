package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

    public class Excel {
        private final Map<String, Set<String>> personAbilities = new HashMap<>();

        public void loadAbilities(String excelFilePath) throws IOException {
            FileInputStream fis = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            boolean skipHeader = true;
            for (Row row : sheet) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                Cell personCell = row.getCell(1);
                Cell abilityCell = row.getCell(2);
                if (personCell != null && abilityCell != null) {
                    String person = personCell.getStringCellValue();
                    String[] abilities = abilityCell.getStringCellValue().split("\t"); //abilitățile sunt separate prin tab-uri
                    for (String ability : abilities) {
                        personAbilities.computeIfAbsent(person, k -> new HashSet<>()).add(ability);
                    }
                }
            }
            fis.close();
        }


        public Map<String, Set<String>> findMaximalGroups() {
            Map<String, Set<String>> groups = new HashMap<>();
            for (String person : personAbilities.keySet()) {
                for (String ability : personAbilities.get(person)) {
                    groups.computeIfAbsent(ability, k -> new HashSet<>()).add(person);
                }
            }
            return groups;
        }


    }


