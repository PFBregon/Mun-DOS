package dev.patriciafb.controller;

import dev.patriciafb.model.Computer;
import dev.patriciafb.model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

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
    void testRemovecomputerByBrand() {
        when (mockStore.removeComputerByBrand("Dell")).thenReturn(true);
        boolean removed = controller.removeComputerByBrand("Dell");
        assertThat(removed, is(true));
        verify(mockStore).removeComputerByBrand("Dell");
    }

}
