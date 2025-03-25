package dev.patriciafb.controller;

import dev.patriciafb.model.Computer;
import dev.patriciafb.model.Store;

public class Controller {
    private Store store;

    public Controller(Store store) {
       this.store = store;
    }

    public void addComputer(Computer computer) {
        store.addComputer(computer);
    }

    public boolean removeComputerByBrand(String brand) {
        return store.removeComputerByBrand(brand);
    }

}

