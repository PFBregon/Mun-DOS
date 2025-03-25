package dev.patriciafb.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;

public class StoreTest {

    private Store store;

    @BeforeEach
    void setUp() {
        store = new Store("Mun-DOS Store", "Patricia", "123456789");
    }

    @Test
    void testAddComputer() {
        Computer computer = new Computer("Dell", 16, "Intel Core i7", "Windows 10", 699);
        store.addComputer(computer);

        List<Computer> computers = store.listAllComputers();
        assertThat(computers.size(), is(1));
        assertThat(computers.get(0).getBrand(), is("Dell"));
    }
    @Test
    void testRemoveComputerByBrand() {
      store.addComputer(new Computer("Dell", 16, "Intel Core i7", "Windows 10", 699));
      store.addComputer(new Computer("HP", 8, "AMD Ryzen 5", "Windows 10", 499));
      boolean removed = store.removeComputerByBrand("Dell");

      assertThat(removed, is(true));
      List<Computer> computers = store.listAllComputers();
      assertThat(computers.size(), is(1));
      assertThat(computers.get(0).getBrand(), is("HP"));
    }

    @Test
    void testSearchComputerByBrand() {
      store.addComputer(new Computer("Dell", 16, "Intel Core i7", "Windows 10", 699));
      store.addComputer(new Computer("HP", 8, "AMD Ryzen 5", "Windows 10", 499));

      List<Computer> result = store.searchComputerByBrand("Dell");
      assertThat(result.size(), is(1));
      assertThat(result.get(0).getBrand(), is("Dell"));
    }
}
