package com.magic.addressbook.csv;

public class AddressBookSystemManage {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String phoneNumber;
    private String zip;
    private String email;

    public AddressBookSystemManage(String firstName,String lastName,String address,String city,String state,String phoneNumber,String zip,String email){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.zip = zip;
        this.email = email;
    }
    @Override
    public String toString(){
        return "[firstName=" + firstName + "\n"+ " lastName=" + lastName + "\n"+ " address=" + address + "\n"+ "city=" + city + "\n"+ " state=" + state + "\n"+ " phoneNumber=" + phoneNumber + "\n"+ " zip=" + zip + "\n"+ " email=" + email + "\n"+"]";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getZip() {
        return zip;
    }

    public String getEmail() {
        return email;
    }
}
