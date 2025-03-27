package dev.patriciafb.view;

import dev.patriciafb.controller.Controller;
import dev.patriciafb.model.Computer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static org.mockito.Mockito.*;

public class viewTest {

    private Controller mockController;
    private View view;
    private Scanner mockScanner;

    @BeforeEach
    void setUp() {
        mockController = mock(Controller.class);
        mockScanner = Mockito.mock(Scanner.class);
        view = new View(mockController);
    }

    @Test
    void testAddComputer() {
        Computer computer = new Computer("Dell", 16, "Intel Core i7", "Windows 10", 699);
        when(mockScanner.nextLine()).thenReturn("Dell", "16", "Intel Core i7", "Windows 10", "699");
        view.addComputer();
        verify(mockController).addComputer(computer);
    }

};

