package dev.patriciafb.model;

public class Computer {
    private String brand;
    private int memory;
    private String cpu;
    private String os;
    private double price;

    public Computer(String brand, int memory, String cpu, String os, double price) {
        this.brand = brand;
        this.memory = memory;
        this.cpu = cpu;
        this.os = os;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getMemory() {
        return memory;
    }

    public String getCpu() {
        return cpu;
    }

    public String getOs() {
        return os;
    }

    public double getPrice() {
        return price;
    }
}
