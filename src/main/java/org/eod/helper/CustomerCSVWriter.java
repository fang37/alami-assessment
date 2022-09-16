package org.eod.helper;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.eod.model.Customer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomerCSVWriter {
    String filePath;
    String[] header;
    List<Customer> customers;

    public CustomerCSVWriter(String filePath, String[] header, List<Customer> customers){
        this.filePath = filePath;
        this.header = header;
        this.customers = customers;
    }

    public void write() throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        CSVPrinter printer = new CSVPrinter(fileWriter, CSVFormat.newFormat(';').withRecordSeparator('\n').withHeader(header));
        for (Customer c : customers) {
            printer.printRecord(c.getId(), c.getName(), c.getAge(), c.wallet.getBalance(), c.thread2b, c.thread3, c.wallet.getPreviousBalance(), c.wallet.getAverageBalance(), c.thread1, c.wallet.getFreeTransfer(), c.thread2a);
        }
        printer.flush();
    }


}
