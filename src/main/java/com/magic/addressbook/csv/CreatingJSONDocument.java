package com.magic.addressbook.csv;

import org.json.JSONObject;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class CreatingJSONDocument {
    public static void CreateJson() {
        JSONObject jsonObject = new JSONObject();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter First Name");
        String firstName = input.nextLine();
        System.out.println("Enter Last Name");
        String lastName = input.nextLine();
        System.out.println("Enter Address");
        String address = input.nextLine();
        System.out.println("Enter city");
        String city = input.nextLine();
        System.out.println("Enter State");
        String state = input.nextLine();
        System.out.println("Enter Phone Number");
        String phoneNumber = input.nextLine();
        System.out.println("Enter Zip");
        String zip = input.nextLine();
        System.out.println("Enter Email");
        String email = input.nextLine();
        jsonObject.put("First_Name", firstName);
        jsonObject.put("Last_Name", lastName);
        jsonObject.put("Address", address);
        jsonObject.put("City", city);
        jsonObject.put("State", state);
        jsonObject.put("Phone_Number", phoneNumber);
        jsonObject.put("ZIP", zip);
        jsonObject.put("Email", email);
        try {
            FileWriter file = new FileWriter("D:\\Address Book Csv\\OP.json");
            file.write(jsonObject.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: " + jsonObject);
    }
}