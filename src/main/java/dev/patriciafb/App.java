package dev.patriciafb;

import dev.patriciafb.view.View;
import dev.patriciafb.controller.Controller;
import dev.patriciafb.model.Store;

import java.util.Scanner;

public class App {
    private View view;

    public App(View view) {
        this.view = view;
        this.view.start();
    }

    public static void main(String[] args) {
        Store store = new Store("Mun-DOS", "Patricia", "123456789");
        Controller controller = new Controller(store);
        Scanner scanner = new Scanner(System.in);

        View view = new View(controller, scanner);
        new App(view);
    }
}
