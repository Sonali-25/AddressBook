package com.magic.addressbook.csv;

import java.io.File;
import java.util.Scanner;

public class AddressBookSystem {
    public static void entryOptions(){
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        int flag = 1 ;
        while(flag == 1)
        {
            System.out.println(" Select a choice : 1. Add Contact 2.Edit Contact  3.Delete Contact 4.Search by City 5.View Person by City 6.Count of Person By City 7.Sorting By Name 8.Sort By City 9.Writing Contacts Details To File 10.Write into Csv File 11.Write Into Json 12.Exit");
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
                case 6 : addressBook.countOfPersonsByCity();
                    break;
                case 7 : addressBook.sortingByName();
                    break;
                case 8 : addressBook.sortingByCity();
                    break;
                case 9 : addressBook.writingContactDetailsToFile();
                break;
                case 10 : {
                    WriteCSVFile wr = new WriteCSVFile();
                    wr.writeDataLineByLine();
                break;
                }
                case 11 : {
                    CreatingJSONDocument cj = new CreatingJSONDocument();
                    cj.CreateJson();
                    break;
                }
                case 12 : flag = 0 ;
                    break;
                default: System.out.println(" Enter a valid choice");
                    break;
            }
            System.out.println(addressBook.contactList);
        }
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Welcome To Address Book");
        entryOptions();


    }
}




