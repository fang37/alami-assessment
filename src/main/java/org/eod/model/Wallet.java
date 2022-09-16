package org.eod.model;

public class Wallet {
    private double balance;
    private double previousBalance;
    private double averageBalance;
    private int freeTransfer;

    public Wallet(double balance, double previousBalance, double averageBalance, int freeTransfer) {
        this.balance = balance;
        this.previousBalance = previousBalance;
        this.averageBalance = averageBalance;
        this.freeTransfer = freeTransfer;
    }

    public void countBalanceAverage() {
        averageBalance = ( balance + previousBalance ) / 2;
    }

    public void addBalance(double addition) {
        balance += addition;
    }

    public void updateFreeTransfer(int quantity) {
        freeTransfer = quantity;
    }

    public double getBalance() {
        return balance;
    }

    public double getPreviousBalance() {
        return previousBalance;
    }

    public double getAverageBalance() {
        return averageBalance;
    }

    public int getFreeTransfer() {
        return freeTransfer;
    }
}
