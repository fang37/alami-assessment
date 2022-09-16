package org.eod.helper;

import org.eod.model.Customer;

public class ThreadRunner3 implements Runnable {
    Customer customer;
    public ThreadRunner3(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        // Task No.3
        int MIN_ID_3 = 1;
        int MAX_ID_3 = 100;
        double BALANCE_EXTRA_3 = 10;

        customer.thread3 = Thread.currentThread().getName();
        if (customer.getId() >= MIN_ID_3 && customer.getId() <= MAX_ID_3) {
            customer.wallet.addBalance(BALANCE_EXTRA_3);
        }
    }
}
