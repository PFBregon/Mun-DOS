package dev.patriciafb.controller;

import dev.patriciafb.model.Computer;
import dev.patriciafb.model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

public class ControllerTest {
    private Store mockStore;
    private Controller controller;

    @BeforeEach
    void setUp() {
        mockStore = Mockito.mock(Store.class);
        controller = new Controller(mockStore);
    }

    @Test
    void testAddComputer() {
        Computer computer = new Computer("Dell", 16, "Intel Core i7", "Windows 10", 699);
        controller.addComputer(computer);
        verify(mockStore).addComputer(computer);
    }

    @Test
    void testRemoveComputerByBrand() {
        when (mockStore.removeComputerByBrand("Dell")).thenReturn(true);
        boolean removed = controller.removeComputerByBrand("Dell");
        assertThat(removed, is(true));
        verify(mockStore).removeComputerByBrand("Dell");
    }

    @Test
    void testSearchComputerByBrand() {
        List<Computer> mockResult = Arrays.asList(new Computer ("Dell", 16, "Intel Core i7", "Windows 10", 699));
        when(mockStore.searchComputerByBrand("Dell")).thenReturn(mockResult);
        List<Computer> result = controller.searchComputerByBrand("Dell");
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getBrand(), is("Dell"));
        verify(mockStore).searchComputerByBrand("Dell");
    }

    @Test
    void testListAllComputers() {
        List<Computer> mockResult = Arrays.asList(
            new Computer("Dell", 16, "Intel Core i7", "Windows 10", 699),
            new Computer("HP", 8, "AMD Ryzen 5", "Windows 10", 499)
        );
        when (mockStore.listAllComputers()).thenReturn(mockResult);
        List<Computer> computers = controller.listAllComputers();
        assertThat(computers.size(), is(2));
        assertThat(computers.get(0).getBrand(), is("Dell"));
        assertThat(computers.get(1).getBrand(), is("HP"));
        verify(mockStore).listAllComputers();
    }


}
