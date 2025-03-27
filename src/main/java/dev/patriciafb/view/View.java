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

    public void addComputer() {
        System.out.println("Enter brand:");
        String brand = scanner.nextLine();
        System.out.println("Enter RAM:");
        int ram = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter processor:");
        String processor = scanner.nextLine();
        System.out.println("Enter OS:");
        String os = scanner.nextLine();
        System.out.println("Enter price:");
        double price = Double.parseDouble(scanner.nextLine());

        controller.addComputer(new Computer(brand, ram, processor, os, price));
    }
}
