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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
    }
