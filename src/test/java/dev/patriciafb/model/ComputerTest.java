package dev.patriciafb.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ComputerTest {

    @Test
    void tesCreateComputer() {
        String brand = "Dell";
        int memory = 16;
        String cpu = "Intel Core i7";
        String os = "Windows 10";
        double price = 699;

        Computer computer = new Computer(brand, memory, cpu, os, price);
        assertThat(computer.getBrand(), is(brand));
        assertThat(computer.getMemory(), is(memory));
        assertThat(computer.getCpu(), is(cpu));
        assertThat(computer.getOs(), is(os));
        assertThat((Double) computer.getPrice(), closeTo(price, 0.01));
    }


}
