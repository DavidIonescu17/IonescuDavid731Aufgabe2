package View;

import Controller.Controller;
import Model.Charakter;
import Model.Produkt;
import Repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Repository repo = new Repository();
        Controller controller = new Controller(repo);
        Produkt s1 = new Produkt("cola", 18, "banat");
        Produkt s2 = new Produkt("fanta", 19, "arad");
        Produkt s3 = new Produkt("sprite", 20, "cluj");

        controller.addProdukt(s1);
        controller.addProdukt(s2);
        controller.addProdukt(s3);

        Charakter v1 = new Charakter(1,"ion", "undeva1", List.of(s1,s2));
        Charakter v2 = new Charakter(2,"ion1", "undeva2",List.of(s1,s3));
        Charakter v3 = new Charakter(3,"ion2", "undeva1", List.of(s2,s3));

        controller.addCharakter(v1);
        controller.addCharakter(v2);
        controller.addCharakter(v3);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\n1. Add Produkt\n2. Update Produkt\n3. Delete Produkt\n4. Get Produkt By Name");
            System.out.println("5. Get All Produkt\n6. Add Charakter\n7. Update Charakter\n8. Delete Charakter");
            System.out.println("9. Get Charakter \n10. Get CharakterList \n11. Filter Charaktere \n12. Filter Produkt \n13. Sort Produkt \n");
            System.out.println("0. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Produkt details Name, Price, region:");
                    String[] data = scanner.nextLine().split(",");
                    controller.addProdukt(new Produkt(data[0].trim(), Integer.parseInt(data[1].trim()), data[2].trim()));
                }
                case 2 -> {
                    System.out.println("Enter name to update:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Produkt details Name, Price, region:");
                    String[] data = scanner.nextLine().split(",");
                    controller.updateProdukt(name, data[0].trim(), Integer.parseInt(data[1].trim()), data[2].trim());
                }
                case 3 -> {
                    System.out.println("Enter name of produkt to delete:");
                    String name = scanner.nextLine();
                    controller.deleteProdukt(name);
                }
                case 4 -> {
                    System.out.println("Enter name of Produkt to get:");
                    String name = scanner.nextLine();
                    System.out.println(controller.getProdukt(name));
                }
                case 5 -> {
                    controller.getProduktList().forEach(System.out::println);
                }
                case 6 -> {
                    System.out.println("Enter Charakter details (Id, Name, dorf):");
                    String[] data = scanner.nextLine().split(",");
                    System.out.println("Enter number of Produkte:");
                    int count = Integer.parseInt(scanner.nextLine());
                    ArrayList<Produkt> ProduktArrayList = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Enter Produkt details Name, Price, region:");
                        String[] ProduktData = scanner.nextLine().split(",");
                        ProduktArrayList.add(new Produkt(ProduktData[0].trim(), Integer.parseInt(ProduktData[1].trim()), ProduktData[2].trim()));
                        controller.addProdukt(new Produkt(ProduktData[0].trim(), Integer.parseInt(ProduktData[1].trim()), ProduktData[2].trim()));
                    }
                    controller.addCharakter(new Charakter(Integer.parseInt(data[0].trim()), data[1].trim(), data[2].trim(), ProduktArrayList));
                }
                case 7 -> {
                    System.out.println("Enter Charakter index to update:");
                    int index = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter Charakter details (Id, Name, dorf):");
                    String[] data = scanner.nextLine().split(",");
                    System.out.println("Enter number of Produkt:");
                    int count = Integer.parseInt(scanner.nextLine());
                    ArrayList<Produkt> ProduktArrayList = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Enter Produkt details Name, Price, region:");
                        String[] ProduktData = scanner.nextLine().split(",");
                        ProduktArrayList.add(new Produkt(ProduktData[0].trim(), Integer.parseInt(ProduktData[1].trim()), ProduktData[2].trim()));
                        controller.addProdukt(new Produkt(ProduktData[0].trim(), Integer.parseInt(ProduktData[1].trim()), ProduktData[2].trim()));
                    }
                    controller.updateCharakter(index, Integer.parseInt(data[0].trim()), data[1].trim(), data[2].trim(), ProduktArrayList);
                }
                case 8 -> {
                    System.out.println("Enter Charakter index to delete:");
                    int index = Integer.parseInt(scanner.nextLine());
                    controller.deleteCharakter(index);
                }
                case 9 -> {
                    System.out.println("Enter Charakter index to get:");
                    int index = Integer.parseInt(scanner.nextLine());
                    System.out.println(controller.getCharakter(index));
                }
                case 10 -> {
                    controller.getCharakterList().forEach(System.out::println);
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