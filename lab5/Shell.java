package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shell {
    private final Map<String, Command> commands = new HashMap<>();
    public Shell(Repository repository) throws ReportGenerationException {
        commands.put("view", new View());
        commands.put("report", new Report(repository));
        commands.put("export", new Export(repository));

    }
        public void start() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("shell> ");
                String input = scanner.nextLine();
                /**
                 * Împart intrarea în două părți
                 * Prima parte este numele comenzii
                 * doua parte sunt argumentele comenzii.
                 */
                String[] parts = input.split(" ", 2);
                String commandName = parts[0];
                //Dacă există argumente, le împarte într-un array de string-uri. Dacă nu există argumente, creează un array gol
                String[] args = parts.length > 1 ? parts[1].split(" ") : new String[0];
                if ("exit".equals(input)) {
                    break;
                } else {
                Command command = commands.get(commandName);
                if (command == null) {
                    System.out.println("Comandă necunoscută: " + commandName);
                } else {
                    try {
                        command.execute(args);
                    } catch (InvalidCommandException e) {
                        System.err.println(e.getMessage());
                    } catch (InvalidArgumentsException e) {
                        System.err.println("Argumente invalide: " + e.getMessage());
                    } catch (DocumentNotFoundException e) {
                        System.err.println("Documentul nu a fost găsit: " + e.getMessage());
                    } catch (ReportGenerationException e) {
                        System.err.println("Eroare la generarea raportului: " + e.getMessage());
                    } catch (ExportFailedException e) {
                        System.err.println("Eroare la export: " + e.getMessage());
                    }
                }
            }


            }

            scanner.close();
        }

}
