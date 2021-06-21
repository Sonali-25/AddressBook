package com.magic.addressbook.csv;


import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFile {
    public static void writeDataLineByLine()
    {
        String filePath="D:\\Address Book Csv\\Assignment CSV.csv";
        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = { "First Name", "LastName", "Address","City","State","Phone Number","Zip","Email" };
            writer.writeNext(header);
            String[] data1 = { "Sonali","Ranjan","kpr", "Hajipur", "Bihar","9383828392","844101","Sonali@gmail.com" };
            writer.writeNext(data1);
            String[] data2 = { "Siddharth","Ranjan","kpr", "Hajipur", "Bihar","9308530265","844101","Sid@gmail.com" };
            writer.writeNext(data2);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}