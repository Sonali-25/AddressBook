package com.magic.addressbook;

import java.util.Scanner;

public class AddressBookSystem {
    public static void entryOptions(){
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        int flag = 1 ;
        while(flag == 1)
        {
            System.out.println(" Select a choice : 1. Add Contact 2.Edit Contact  3.Delete Contact 4.Search by City 5.View Person by City 6.Exit");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1 : addressBook.addContact();
                    break;
                case 2 : if (addressBook.contactList.isEmpty())
                {
                    System.out.println(" Address Book is empty ");
                    break;
                }
                    addressBook.editContact();
                    break;
                case 3 : if (addressBook.contactList.isEmpty())
                {
                    System.out.println("Contact Not Found");
                    break;
                }
                    addressBook.deleteContact();
                    break;
                case 4 : addressBook.searchByCity();
                    break;
                case 5 : addressBook.viewPersonByCity();
                    break;
                case 6 : flag = 0 ;
                    break;
                default: System.out.println(" Enter a valid choice");
                    break;
            }
            System.out.println(addressBook.contactList);
        }
    }


    public static void main(String[] args) {
        System.out.println("Welcome To Address Book");
        entryOptions();

    }
}




