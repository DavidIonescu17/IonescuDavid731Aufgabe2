package View;
import Controller.*;
import Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Spieler\n2. Update Spieler\n3. Delete Spieler\n4. List Spielers");
            System.out.println("5. Add Verein\n6. Update Verein\n7. Delete Verein\n8. List Vereins");
            System.out.println("9. Filter By City \n10. Get Spieler\n11. Get Verein");
            System.out.println("0. Exit");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter details (Name, Alter, Position,\n" +
                            "Marktwert:");
                    String[] data = scanner.nextLine().split(",");
                    controller.addSpieler(new Spieler(data[0].trim(), Integer.parseInt(data[1].trim()), data[2].trim(), Integer.parseInt(data[3].trim())));
                }
                case 2 -> {
                    System.out.println("Enter index to update:");
                    int index = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter new details ((Name, Alter, Position,\n" +
                            "Marktwert):");
                    String[] data = scanner.nextLine().split(",");
                    controller.updateSpieler(index, new Spieler(data[0].trim(), Integer.parseInt(data[1].trim()), data[2].trim(), Integer.parseInt(data[3].trim())));
                }
                case 3 -> {
                    System.out.println("Enter name to delete:");
                    String name = scanner.nextLine();
                    controller.deleteSpielerByName(name);
                }
                case 4 -> controller.getAllSpielere().forEach(System.out::println);
                case 5 -> {
                    System.out.println("Enter Verein details (Id, Name, Stadt):");
                    String[] data = scanner.nextLine().split(",");
                    System.out.println("Enter number of Spielers:");
                    int count = Integer.parseInt(scanner.nextLine());
                    ArrayList<Spieler> Spielers = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Enter Spieler((Name, Alter, Position,\n" +
                                "Marktwert):");
                        String[] SpielerData = scanner.nextLine().split(",");
                        Spielers.add(new Spieler(data[0].trim(), Integer.parseInt(data[1].trim()), data[2].trim(), Integer.parseInt(data[3].trim())));
                        controller.addSpieler(new Spieler(data[0].trim(), Integer.parseInt(data[1].trim()), data[2].trim(), Integer.parseInt(data[3].trim())));
                    }
                    controller.addVerein(new Verein(Integer.parseInt(data[0].trim()), data[1].trim(), data[2].trim(), Spielers));
                }
                case 6 -> {
                    System.out.println("Enter Verein index to update:");
                    int index = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter new Verein details ((Id, Name, Stadt):");
                    String[] data = scanner.nextLine().split(",");
                    System.out.println("Enter number of Spielers:");
                    int count = Integer.parseInt(scanner.nextLine());
                    ArrayList<Spieler> Spielers = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Enter Spieler(Name, Alter, Position,\n" +
                                "Marktwert):");
                        String[] SpielerData = scanner.nextLine().split(",");
                        Spielers.add(new Spieler(data[0].trim(), Integer.parseInt(data[1].trim()), data[2].trim(), Integer.parseInt(data[3].trim())));
                        controller.addSpieler(new Spieler(data[0].trim(), Integer.parseInt(data[1].trim()), data[2].trim(), Integer.parseInt(data[3].trim())));
                    }
                    controller.updateVerein(index, new Verein(Integer.parseInt(data[0].trim()), data[1].trim(), data[2].trim(), Spielers));
                }
                case 7 -> {
                    System.out.println("Enter Verein index to delete:");
                    int index = Integer.parseInt(scanner.nextLine());
                    controller.deleteVerein(index);
                }
                case 8 -> controller.getAllVereins().forEach(System.out::println);
                case 9 -> {
                    System.out.println("Enter city to filter verein by:");
                    String city = scanner.nextLine();
                    controller.filterVerein(controller.getAllVereins(), city);
                }
                case 10 -> {
                    System.out.println("Enter name to get Spieler:");
                    String name = scanner.nextLine();
                    Spieler spieler = controller.getSpielerByName(name);
                    if (spieler != null) {
                        System.out.println(spieler);
                    } else {
                        System.out.println("Spieler not found!");
                    }
                }
                case 11 -> {
                    System.out.println("Enter index to get Verein:");
                    int index = Integer.parseInt(scanner.nextLine());
                    Verein Verein = controller.getVerein(index);
                    if (Verein != null) {
                        System.out.println(Verein);
                    } else {
                        System.out.println("Verein not found!");
                    }
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}