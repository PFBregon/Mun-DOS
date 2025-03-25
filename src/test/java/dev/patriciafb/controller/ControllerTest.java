package dev.patriciafb.controller;

import dev.patriciafb.model.Computer;
import dev.patriciafb.model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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

}
