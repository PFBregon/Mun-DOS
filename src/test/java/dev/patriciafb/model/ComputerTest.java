package dev.patriciafb.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {

    @Test
    void tesCreateComputer() {
        String brand = "Dell";
        int memory = 16;
        String cpu = "Intel Core i7";
        String os = "Windows 10";
        double price = 699;

        Computer computer = new Computer(brand, memory, cpu, os, price);
        assertThat(computador.getMarca(), is(marca));
        assertThat(computador.getMemoria(), is(memoria));
        assertThat(computador.getProcesador(), is(procesador));
        assertThat(computador.getSistemaOperativo(), is(sistemaOperativo));
        assertThat(computador.getPrecio(), closeTo(precio, 0.01));
    }


}
