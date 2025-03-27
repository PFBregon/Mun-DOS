package dev.patriciafb.view;

import dev.patriciafb.controller.Controller;
import dev.patriciafb.model.Computer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class viewTest {

    private Controller mockController;
    private View view;
    private Scanner mockScanner;

    @BeforeEach
    void setUp() {
        mockController = mock(Controller.class);
        mockScanner = Mockito.mock(Scanner.class);
        view = new View(mockController, mockScanner);
    }

    @Test
    void testAddComputer() {
        Computer computer = new Computer("Dell", 16, "Intel Core i7", "Windows 10", 699);
        when(mockScanner.nextLine()).thenReturn("Dell", "16", "Intel Core i7", "Windows 10", "699");
        view.addComputer();
        verify(mockController).addComputer(any(Computer.class));
    }

    @Test
    void testRemoveComputerByBrand() {
        when(mockScanner.nextLine()).thenReturn("Dell");
        when(mockController.removeComputerByBrand("Dell")).thenReturn(true);
        view.removeComputerByBrand();
        verify(mockController).removeComputerByBrand("Dell");
    }

    @Test
    void testSearchComputerByBrand() {
        when(mockScanner.nextLine()).thenReturn("Dell");
        List<Computer> mockResult = Arrays.asList(new Computer("Dell", 16, "Intel Core i7", "Windows 10", 699));
        when(mockController.searchComputerByBrand("Dell")).thenReturn(mockResult);
        view.searchComputerByBrand();
        verify(mockController).searchComputerByBrand("Dell");
    }

    @Test
    void testListAllComputers() {
        List<Computer> mockResult = Arrays.asList(
                new Computer("Dell", 16, "Intel Core i7", "Windows 10", 699),
                new Computer("HP", 8, "AMD Ryzen 5", "Windows 10", 499)
        );
        when(mockController.listAllComputers()).thenReturn(mockResult);
        view.listAllComputers();
        verify(mockController).listAllComputers();
    }

    @Test
void testReadOption_ValidInput() throws Exception {
    when(mockScanner.nextLine()).thenReturn("1");
    java.lang.reflect.Method method = View.class.getDeclaredMethod("readOption");
    method.setAccessible(true);
    int option = (int) method.invoke(view);
    assertEquals(1, option);
}

@Test
void testReadOption_InvalidInput() throws Exception {
    when(mockScanner.nextLine()).thenReturn("abc", "1");
    int option = -1;
    while (option == -1) {
        option = view.readOption();
    }
    assertEquals(1, option);
}
};

