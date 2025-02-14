package org.Rifqi;

import org.Rifqi.entity.Material;
import org.Rifqi.libraryMaterials.Book;
import org.Rifqi.libraryMaterials.DVD;
import org.Rifqi.libraryMaterials.Magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private final Scanner scanner=new Scanner(System.in);
    private List<Material> libraryCollectio = new ArrayList<>();

    public void runSystem() {
        while (true) {
            System.out.println("================================");
            System.out.println("|||| WELCOME TO THE LIBRARY ||||");
            System.out.println("================================");
            System.out.println("1. Create new Material");
            System.out.println("2. Borrow Material");
            System.out.println("3. Return Material");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> createMaterial();
                case 2 -> borrowMaterial();
                case 3 -> returnMaterial();
                case 4 -> {
                    System.out.println("Good Bye......");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void borrowMaterial() {
        if (libraryCollectio.isEmpty()){
            System.out.println(" THERE IS NO AVALAIBLE MATERIAL ");
        }
        System.out.println("|||| AVAILABLE MATERIAL ||||");
        for (int i = 0; i < libraryCollectio.size(); i++) {
            System.out.print((i + 1) + ". ");
            libraryCollectio.get(i).displayInfo();
        }
        System.out.println("\n|||| PLEASE CHOOSE THE MATERIAL BY NUMBER |||| ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice < 1 || choice > libraryCollectio.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Material selectedMaterial = libraryCollectio.get(choice - 1);
        if (!selectedMaterial.isAvailable()) {
            System.out.println("Sorry, this material is already borrowed.");
        } else {
            selectedMaterial.borrow();
            System.out.print("You have successfully borrowed: ");
            selectedMaterial.displayInfo();
            scanner.nextLine();
        }
    }

    private void returnMaterial() {
        System.out.println("Borrowed materials:");
        List<Material> borrowedMaterials = new ArrayList<>();

        for (Material material : libraryCollectio) {
            if (!material.isAvailable()) {
                borrowedMaterials.add(material);
                System.out.print(borrowedMaterials.size() + ". " );
                material.displayInfo();
            }
        }

        if (borrowedMaterials.isEmpty()) {
            System.out.println("NO BORROWED MATERIAL TO RETURN");
            return;
        }

        System.out.println("\n|||| PLEASE CHOOSE THE MATERIAL BY NUMBER |||| ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > borrowedMaterials.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        borrowedMaterials.get(choice - 1).returnMaterial();
    }


    private void createMaterial() {
        while (true) {
            System.out.println("|||| PLEASE ENTER THE TITLE ||||");
            String title= scanner.nextLine();
            System.out.println("|||| PLEASE CHOOSE TYPE YOU WANT TO CREATE ||||");
            System.out.println("1. Book");
            System.out.println("2. Magazine");
            System.out.println("3. DVD");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            String type ="";

            switch (choice) {
                case 1 -> type="book";
                case 2 -> type="magazine";
                case 3 -> type="dvd";
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

            Material newMaterial = null;
            switch (type){
                case "book" ->{
                    System.out.println("|||| PLEASE ENTER THE AUTHOR ||||");
                    String author = scanner.nextLine();
                    newMaterial=(new Book(title,author));

                }
                case "magazine"->{
                    System.out.println("|||| PLEASE ENTER THE ISSUE NUMBER ||||");
                    int issueNumber = scanner.nextInt();
                    newMaterial=(new Magazine(title,issueNumber));
                }
                case "dvd"->{
                    System.out.println("|||| PLEASE ENTER THE DIRECTOR ||||");
                    String director = scanner.nextLine();
                    newMaterial=(new DVD(title,director));
                }
            }
            libraryCollectio.add(newMaterial);
            System.out.println("|||| MATERIAL CREATION SUCCESS ||||");
            libraryCollectio.get(libraryCollectio.size() - 1).displayInfo();
            scanner.nextLine();
            return;

        }
        
    }
}
