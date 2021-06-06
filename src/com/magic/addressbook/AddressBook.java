package com.magic.addressbook;
import java.util.List;
import java.util.*;
import java.util.ArrayList;

public class AddressBook {
    static List<AddressBookSystemManage> contactList=new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public void addContact(){
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
    public void editContact(){
        Scanner nameInput = new Scanner(System.in);
        System.out.println("Enter First Name");
        String firstName = nameInput.nextLine();
        for(int i = 0; i < contactList.size(); i++){
            if (contactList.get(i).getFirstName().equals(firstName)){
                contactList.remove(i);
                AddressBook addressBook = new AddressBook();
                addressBook.addContact();
            }
            else{
                System.out.println("No Contact");
            }

        }
    }
    public void deleteContact(){
        Scanner deleteNameInput = new Scanner(System.in);
        System.out.println("Enter First Name of the Person You Want To Remove");
        String deleteFirstName = deleteNameInput.nextLine();
        for(int increase = 0; increase < contactList.size(); increase++){
            if(contactList.get(increase).getFirstName().equals(deleteFirstName)){
                contactList.remove(increase);
            }
            else{
                System.out.println("Name does not exist");
            }
        }
    }




}
