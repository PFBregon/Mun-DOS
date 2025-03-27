package dev.patriciafb.view;

import dev.patriciafb.controller.Controller;
import dev.patriciafb.model.Computer;

import java.util.List;
import java.util.Scanner;

public class View {
    private final Controller controller;
    private final Scanner scanner;

    public View(Controller controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
        }

    private String readInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
        }

    public void addComputer() {
        System.out.println("Introduzca la marca:");
        String brand = scanner.nextLine();
        System.out.println("Introduzca la RAM:");
        int ram = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduzca el modelo de CPU:");
        String processor = scanner.nextLine();
        System.out.println("Introduzca el sistema operativo:");
        String os = scanner.nextLine();
        System.out.println("Introduzca el precio:");
        double price = Double.parseDouble(scanner.nextLine());

        controller.addComputer(new Computer(brand, ram, processor, os, price));
    }

    public void removeComputerByBrand() {
        System.out.println("Introduzca la marca:");
        String brand = scanner.nextLine();
        boolean removed = controller.removeComputerByBrand(brand);
        if (removed) {
            System.out.println("Ordenador(es) eliminado(s) exitosamente.");
        }
        else {
            System.out.println("No se encontraron ordenadores con esa marca.");
        }
    }

    public void searchComputerByBrand() {
        String brand = readInput("Introduzca la marca del ordenador que quiere buscar: ");
        List<Computer> result = controller.searchComputerByBrand(brand);
        if (result.isEmpty()) {
            System.out.println("No se encontraron ordenadores de esa marca.");
        }
        else {
            System.out.println("Resultados:");
            for (Computer computer : result) {
                System.out.println(computer.toString());
            }
        }
    }

    public void listAllComputers() {
        List<Computer> computers = controller.listAllComputers();
        if (computers.isEmpty()) {
            System.out.println("No hay ordenadores en la tienda actualmente.");
        }
        else {
            System.out.println("Lista de ordenadores:");
            for (Computer computer : computers) {
                System.out.println(computer.toString());
            }
        }
    }

    public void start() {
        System.out.println("=== Bienvenido a Mun-DOS ===");
        while (true) {
            showMenu();
            int option = readOption();
            if (!processOption(option)) {
                break;
            }
        }
        System.out.println("Gracias por usar nuestro programa. ¡Hasta luego!");
    }

    private void showMenu() {
        System.out.println("\n=== Menú de la Tienda ===");
        System.out.println("1. Agregar ordenador");
        System.out.println("2. Eliminar ordenador por Marca");
        System.out.println("3. Buscar ordenador por Marca");
        System.out.println("4. Ver todos los ordenadores disponibles");
        System.out.println("5. Salir");
    }

    int readOption() {
        while (true){
        System.out.print("Seleccione una opción: ");
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
        }
    }
    }

    private boolean processOption(int option) {
        switch (option) {
            case 1:
                addComputer();
                break;
            case 2:
                removeComputerByBrand();
                break;
            case 3:
                searchComputerByBrand();
                break;
            case 4:
                listAllComputers();
                break;
            case 5:
                System.out.println("Saliendo...");
                return false;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
        return true;
    }
    }
