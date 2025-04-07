package org.example.developer.view;

import org.example.developer.controller.DeveloperController;
import org.example.developer.exceptions.DeveloperException;
import org.example.developer.exceptions.DeveloperNotFoundException;

import java.util.Scanner;

public class DeveloperView {
    private final DeveloperController controller;
    private final Scanner scanner;

    public DeveloperView(DeveloperController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void showMenu(){
        int option;
        while (true){
            System.out.println("1. Agregar desarrollador");
            System.out.println("2. Mostrar lista de desarrolladores");
            System.out.println("3. Salir");

            System.out.println("Ingrese una opción");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1 -> addDeveloperView();
                case 2 -> findAllView();
                case 3 -> {
                    return;
                }
            }
        }
    }

    public void addDeveloperView(){
        System.out.println("Ingrese el nombre del desarrollador");
        String name = scanner.nextLine();

        System.out.println("Ingrese el ID del desarrollador");
        String id = scanner.nextLine();

        System.out.println("Ingrese la edad del desarrollador");
        Integer age = scanner.nextInt();
        scanner.nextLine();

        try {
            controller.addDeveloper(name, id, age);
        } catch (DeveloperNotFoundException | DeveloperException e) {
            System.out.println(e.getMessage());
        }
    }

    public void findAllView(){
        try {
            controller.findAll().forEach(System.out::println);
        } catch (DeveloperException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
