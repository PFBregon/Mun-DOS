package dev.patriciafb.controller;

import dev.patriciafb.model.Computer;
import dev.patriciafb.model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;

public class ControllerTest {
    private Controller controller;
    private Store mockStore;

    @BeforeEach
    void setUp() {
        mockStore = new Store("Mun-DOS Store", "Patricia", "123456789");
        controller = new Controller(mockStore);
    }

    @Test
    void testAddComputer() {
        Computer computer = new Computer("Dell", 16, "Intel Core i7", "Windows 10", 699);
        controller.addComputer(computer);

        List<Computer> computers = mockStore.listAllComputers();
        assertThat(computers.size(), is(1));
        assertThat(computers.get(0).getBrand(), is("Dell"));
    }

}
