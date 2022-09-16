package org.eod.helper;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.eod.Main;
import org.eod.model.Customer;
import org.eod.model.Wallet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CustomerCSVReader {

    String fileName;
    List<Customer> customers;

    public CustomerCSVReader(String fileName){
        this.fileName = fileName;
    }

    public List<Customer> getCustomers() throws IOException {
        InputStream inputStream = Main.class.getResourceAsStream("/"+fileName);
        InputStreamReader reader = new InputStreamReader(inputStream);
        CSVParser records = CSVFormat.newFormat(';').withFirstRecordAsHeader().parse(reader);

        List<Customer> customers = new ArrayList<Customer>();

        for (CSVRecord record : records) {
            int id = Integer.parseInt(record.get("id"));
            String name = record.get("Nama");
            int age = Integer.parseInt(record.get("Age"));
            Double balanced = Double.valueOf(record.get("Balanced"));
            Double previousBalanced = Double.valueOf(record.get("Previous Balanced"));
            Double averageBalanced = Double.valueOf(record.get("Average Balanced"));
            int freeTransfer = Integer.parseInt(record.get("Free Transfer"));

            Wallet wallet = new Wallet(balanced, previousBalanced, averageBalanced, freeTransfer);
            Customer customer = new Customer(id, name, age, wallet);

            customers.add(customer);
        }
        return customers;
    }

}
