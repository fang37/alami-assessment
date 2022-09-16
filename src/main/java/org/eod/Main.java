package org.eod;

import org.eod.helper.*;
import org.eod.model.Customer;

import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFileName = "Before Eod.csv";   // Put file on ./src/main/resources/
        String outputPath = "./src/main/resources/After Eod.csv";

        // Read CSV file
        CustomerCSVReader customerCSVReader = new CustomerCSVReader(inputFileName);

        List<Customer> customers = customerCSVReader.getCustomers();

        // Task No. 1
        int THREAD_1 = 4;
        ExecutorService executorService1 = Executors.newFixedThreadPool(THREAD_1, new NumberThreadFactory());
        for (Customer customer : customers ) {
            ThreadRunner1 threadRunner1 = new ThreadRunner1(customer);
            executorService1.submit(threadRunner1);
        }
        executorService1.shutdown();

        // Task No. 2
        int THREAD_2 = 6;
        ExecutorService executorService2 = Executors.newFixedThreadPool(THREAD_2, new NumberThreadFactory());
        for (Customer customer : customers ) {
            ThreadRunner2 threadRunner2 = new ThreadRunner2(customer);
            executorService2.submit(threadRunner2);
        }
        executorService2.shutdown();

        // Task No.3
        int THREAD_3 = 8;
        ExecutorService executorService3 = Executors.newFixedThreadPool(THREAD_3, new NumberThreadFactory());
        for (Customer customer : customers ) {
            ThreadRunner3 threadRunner3 = new ThreadRunner3(customer);
            executorService3.submit(threadRunner3);
        }
        executorService3.shutdown();

        // Write CSV File
        String[] outputHeader = {"id", "Nama", "Age", "Balanced", "No 2b Thread-No", "No 3 Thread-No", "Previous Balanced", "Average Balanced", "No 1 Thread-No","Free Transfer", "No 2a Thread-No"};
        CustomerCSVWriter csvWriter = new CustomerCSVWriter(outputPath, outputHeader, customers);
        csvWriter.write();

    }
}