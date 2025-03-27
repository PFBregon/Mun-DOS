package dev.patriciafb;

import dev.patriciafb.controller.Controller;
import dev.patriciafb.model.Store;
import dev.patriciafb.view.View;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;


public class App {
    private View view;

    public App(View view) {
        this.view = view;
    }

    public void run() {
        try {
            this.view.start();
        } catch (Exception e) {
            System.err.println("Error al iniciar la vista: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Store store = new Store("Mun-DOS", "Patricia", "123456789");
        Controller controller = new Controller(store);
        Scanner scanner = new Scanner(System.in);

        View view = new View(controller, scanner);
        App app = new App(view);
        app.run();
    }

    @Test
    void testRunHandlesViewExceptions() {
    View mockView = mock(View.class);
    doThrow(new RuntimeException("Error en la vista")).when(mockView).start();
    App app = new App(mockView);
    assertDoesNotThrow(app::run);
}
}
