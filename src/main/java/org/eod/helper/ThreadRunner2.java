package org.eod.helper;

import org.eod.model.Customer;

public class ThreadRunner2 implements Runnable {

    Customer customer;
    public ThreadRunner2(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        // Task No. 2
        double MIN_BENEFIT_2A = 100;
        double MAX_BENEFIT_2A = 150;
        double MIN_BENEFIT_2B = 150;
        int FREE_TRANSFER_2A = 5;
        int BALANCED_ADDITION_2B = 25;

        customer.thread2a = Thread.currentThread().getName();
        customer.thread2b = Thread.currentThread().getName();

        if (customer.wallet.getBalance() >= MIN_BENEFIT_2A && customer.wallet.getBalance() <= MAX_BENEFIT_2A) {
            // 2A
            customer.wallet.updateFreeTransfer(FREE_TRANSFER_2A);
        } else if (customer.wallet.getBalance() > MIN_BENEFIT_2B) {
            // 2B
            customer.wallet.addBalance(BALANCED_ADDITION_2B);
        }

    }
}
