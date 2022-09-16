package org.eod.model;

import org.eod.model.Wallet;

public class Customer {
    int id;
    String name;
    int age;
    public String thread1;
    public String thread2a;
    public String thread2b;
    public String thread3;

    public Wallet wallet;

    public Customer(int id, String name, int age, Wallet wallet) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
