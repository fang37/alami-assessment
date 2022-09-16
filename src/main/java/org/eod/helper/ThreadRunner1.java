package org.eod.helper;

import org.eod.model.Customer;

public class ThreadRunner1 implements Runnable {

    Customer customer;
    public ThreadRunner1(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        // Task No. 1
        customer.thread1 = Thread.currentThread().getName();

        customer.wallet.countBalanceAverage();
    }
}
