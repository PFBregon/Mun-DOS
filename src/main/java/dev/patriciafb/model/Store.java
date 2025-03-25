package dev.patriciafb.model;

import java.util.ArrayList;
import java.util.List;

public class Store {

        private String storeName;
        private String owner;
        private String taxId;
        private List<Computer> computers;

        public Store(String storeName, String owner, String taxId) {
            this.storeName = storeName;
            this.owner = owner;
            this.taxId = taxId;
            this.computers = new ArrayList<>();
        }

        public String getStoreName() {
            return storeName;
        }

        public String getOwner() {
            return owner;
        }

        public String taxId() {
            return taxId;

        }

        public void addComputer(Computer computer) {
            computers.add(computer);
        }

        public List<Computer> listAllComputers() {
            return computers;
        }

        public boolean removeComputerByBrand(String string) {
            return computers.removeIf(computer -> computer.getBrand().equals(string));
        }
    }
