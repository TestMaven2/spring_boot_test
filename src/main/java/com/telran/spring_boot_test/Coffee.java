package com.telran.spring_boot_test;

public class Coffee {

    private String id;
    private String name;

    public Coffee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Coffee: ID - %s, name - %s", id, name);
    }
}
