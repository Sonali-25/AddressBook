package com.magic.addressbook;
import javax.swing.*;
import java.util.List;
import java.util.*;
import java.util.ArrayList;

public class AddressBookSystem {
    static List<AddressBookSystemManage> contactList=new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void addContact(){
        System.out.println("Enter First Name");
        String firstName=input.nextLine();
        System.out.println("Enter Last Name");
        String lastName=input.nextLine();
        System.out.println("Enter Address");
        String address=input.nextLine();
        System.out.println("Enter city");
        String city=input.nextLine();
        System.out.println("Enter State");
        String state=input.nextLine();
        System.out.println("Enter Phone Number");
        String phoneNumber=input.nextLine();
        System.out.println("Enter Zip");
        String zip=input.nextLine();
        System.out.println("Enter Email");
        String email=input.nextLine();
        AddressBookSystemManage addressBook = new AddressBookSystemManage(firstName,lastName,address,city,state,phoneNumber,zip,email);
        contactList.add(addressBook);

    }

    public static void main(String[] args) {
        System.out.println("Welcome To the AddressBook");
        addContact();
        System.out.println(contactList);

    }
}
