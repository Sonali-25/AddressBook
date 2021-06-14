package com.magic.addressbook.csv;

import java.util.List;
import java.util.*;
import java.util.ArrayList;
import java.io.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class AddressBook {
    static List<AddressBookSystemManage> contactList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public void addContact() {
        System.out.println("Enter First Name");
        String firstName = input.nextLine();
        for (int index = 0; index < contactList.size(); index++) {
            if (firstName.equals(contactList.get(index).getFirstName())) {
                System.out.println(" The name already exists ");
                AddressBookSystem.entryOptions();
            }
        }
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
        AddressBookSystemManage addressBook = new AddressBookSystemManage(firstName, lastName, address, city, state, phoneNumber, zip, email);
        contactList.add(addressBook);

    }

    public void editContact() {
        Scanner nameInput = new Scanner(System.in);
        System.out.println("Enter First Name");
        String firstName = nameInput.nextLine();
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getFirstName().equals(firstName)) {
                contactList.remove(i);
                AddressBook addressBook = new AddressBook();
                addressBook.addContact();
            } else {
                System.out.println("No Contact");
            }

        }
    }

    public void deleteContact() {
        Scanner deleteNameInput = new Scanner(System.in);
        System.out.println("Enter First Name of the Person You Want To Remove");
        String deleteFirstName = deleteNameInput.nextLine();
        for (int increase = 0; increase < contactList.size(); increase++) {
            if (contactList.get(increase).getFirstName().equals(deleteFirstName)) {
                contactList.remove(increase);
            } else {
                System.out.println("Contact Deleted");
            }
        }
    }

    public void searchByCity() {
        Scanner cityInput = new Scanner(System.in);
        System.out.println(" Enter the city name you want to get contact details ");
        String city = cityInput.nextLine();
        for (AddressBookSystemManage cityList : contactList) {
            if (cityList.getCity().equals(city))
                System.out.println(cityList);
        }

    }

    public void viewPersonByCity() {
        Scanner cityViewInput = new Scanner(System.in);
        System.out.println(" Enter the city name you want to get the person details");
        String city = cityViewInput.nextLine();
        for (AddressBookSystemManage cityList : contactList) {
            if (cityList.getCity().equals(city))
                System.out.println(cityList);
        }
    }

    public void countOfPersonsByCity() {
        int count = 0;
        Collections.sort(contactList, new SortByName());
        Scanner cityCountInput = new Scanner(System.in);
        System.out.println(" Enter the city ");
        String city = cityCountInput.nextLine();
        for (int index = 0; index + 1 < contactList.size(); index++) {
            if (contactList.get(index).getCity().equals(city))
                if (contactList.get(index).getCity().equals(contactList.get(index + 1).getCity())) {
                    count += 1;
                }

        }
        count++;
        System.out.println(" The number of persons from the city " + city + " is " + count);
    }

    public void sortingByName()
    {
        Comparator<AddressBookSystemManage> sortingNameList = (firstAddressObject , secondAddessObject) -> firstAddressObject.getFirstName().compareTo(secondAddessObject.getFirstName());
        List<AddressBookSystemManage> sortedNames = contactList.stream().sorted(sortingNameList).collect(Collectors.toList());
        System.out.println(sortedNames);
    }
    public void sortingByCity()
    {
        Comparator<AddressBookSystemManage> sortingCityList = (firstAddressObject , secondAddessObject) -> firstAddressObject.getCity().compareTo(secondAddessObject.getCity());
        List<AddressBookSystemManage> sortedCity = contactList.stream().sorted(sortingCityList).collect(Collectors.toList());
        System.out.println(sortedCity);
    }
}

