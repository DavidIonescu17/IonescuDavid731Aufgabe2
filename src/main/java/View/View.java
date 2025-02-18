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
        Produkt p1 = new Produkt("Kunai", 50.0, "Konoha");
        Produkt p2 = new Produkt("Shuriken", 30.0, "Konoha");
        Produkt p3 = new Produkt("Schwert", 200.0, "Kirigakure");
        Produkt p4 = new Produkt("Heiltrank", 100.0, "Sunagakure");
        Produkt p5 = new Produkt("Sprengsiegel", 75.0, "Iwagakure");
        Produkt p6 = new Produkt("Riesenfächer", 300.0, "Sunagakure");
        Produkt p7 = new Produkt("Giftklinge", 150.0, "Kirigakure");
        Produkt p8 = new Produkt("Explosionskugel", 250.0, "Iwagakure");
        Produkt p9 = new Produkt("Schattendolch", 180.0, "Konoha");
        Produkt p10 = new Produkt("Wasserperle", 90.0, "Kirigakure");
        controller.addProdukt(p1);
        controller.addProdukt(p2);
        controller.addProdukt(p3);
        controller.addProdukt(p4);
        controller.addProdukt(p5);
        controller.addProdukt(p6);
        controller.addProdukt(p7);
        controller.addProdukt(p8);
        controller.addProdukt(p9);
        controller.addProdukt(p10);

        Charakter v1 = new Charakter(1,"Naruto Uzumaki", "Konoha", List.of(p1,p4,p9,p6));
        Charakter v2 = new Charakter(2,"Gaara", "Sunagakure",List.of(p3,p5,p7,p2));
        Charakter v3 = new Charakter(3,"Kisame Hoshigaki", "Kirigakure", List.of(p2,p3,p4,p8,p10));
        Charakter v4 = new Charakter(4,"Deidara", "Iwagakure", List.of(p1,p5,p8,p10));
        Charakter v5 = new Charakter(5,"Itachi Uchiha","Konoha",List.of(p9,p7,p3,p8));
        controller.addCharakter(v1);
        controller.addCharakter(v2);
        controller.addCharakter(v3);
        controller.addCharakter(v4);
        controller.addCharakter(v5);
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
                    controller.addProdukt(new Produkt(data[0].trim(), Double.parseDouble(data[1].trim()), data[2].trim()));
                }
                case 2 -> {
                    System.out.println("Enter name to update:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Produkt details Name, Price, region:");
                    String[] data = scanner.nextLine().split(",");
                    controller.updateProdukt(name, data[0].trim(), Double.parseDouble(data[1].trim()), data[2].trim());
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
                        ProduktArrayList.add(new Produkt(ProduktData[0].trim(), Double.parseDouble(ProduktData[1].trim()), ProduktData[2].trim()));
                        controller.addProdukt(new Produkt(ProduktData[0].trim(), Double.parseDouble(ProduktData[1].trim()), ProduktData[2].trim()));
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
                        ProduktArrayList.add(new Produkt(ProduktData[0].trim(), Double.parseDouble(ProduktData[1].trim()), ProduktData[2].trim()));
                        controller.addProdukt(new Produkt(ProduktData[0].trim(), Double.parseDouble(ProduktData[1].trim()), ProduktData[2].trim()));
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
                case 11 -> {
                    System.out.println("Enter dorf to filter Charakter:");
                    String dorf = scanner.nextLine();
                    controller.filterCharakter(controller.getCharakterList(), dorf);
                }
                case 12 -> {
                    System.out.println("Enter region to get Charakters:");
                    String region = scanner.nextLine();
                    controller.showCharakters(controller.getCharakterList(), region);
                }
                case 13 -> {
                    System.out.println("Enter name of Charakter");
                    String name = scanner.nextLine();
                    System.out.println("Enter Absteigend or anything else for order");
                    String sortMode = scanner.nextLine();
                    controller.sortProdukts(controller.getCharakterList(), name, sortMode);
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