package org.example;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----Compulsory-----");
        try {
            Repository repo = new Repository("C:\\Users\\Gabriela\\Documents\\BalanGabriela_Pa_2024\\LAB5\\masterFile");
            repo.displayContent();

            System.out.println("-----Homework-----");
            Shell shell = new Shell(repo);
            shell.start();

            Excel abilityGroups = new Excel();
            abilityGroups.loadAbilities("C:\\Users\\Gabriela\\Documents\\BalanGabriela_Pa_2024\\LAB5\\untitled2\\src\\main\\resources\\abilities.xlsx");
            Map<String, Set<String>> groups = abilityGroups.findMaximalGroups();
            for (String ability : groups.keySet()) {
                System.out.println("Grupa " + ability + ": " + groups.get(ability));
            }
        }
        catch (InvalidRepositoryException | MasterRepositoryWrongException | ReportGenerationException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
       }
    }
    // ultimul ex : java -jar untitled2-1.0-SNAPSHOT.jar
    // in drapta Maven-> plugins -> jar:jar -> a creat in target
}
