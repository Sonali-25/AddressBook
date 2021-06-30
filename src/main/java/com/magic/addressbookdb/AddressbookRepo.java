package com.magic.addressbookdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AddressbookRepo {
    public List<Contact> findAll() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        List<Contact> details = new ArrayList<>();
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_service", "root", "root");
            statement = connection.createStatement();
            String query = "Select * from addressbook";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Contact info = new Contact();
                String firstName = result.getString(1);
                info.setFirstName(firstName);
                String lastName = result.getString(2);
                info.setLastName(lastName);
                String address = result.getString(3);
                info.setAddress(address);
                String city = result.getString(4);
                info.setCity(city);
                String phoneNo = result.getString(5);
                info.setPhoneNo(phoneNo);
                details.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return details;
    }
    public void updateContact(String firstName, String phoneNo) {
        Connection connection = null;
        PreparedStatement prestatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_service", "root", "root");
            String query = "update addressbook set PhoneNo = ? where FirstName = ?";
            prestatement = connection.prepareStatement(query);
            prestatement.setString(1, phoneNo);
            prestatement.setString(2, firstName);

            int result = prestatement.executeUpdate();
            System.out.println("Contact Updated");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public List<Contact> findAllForParticularDateRange() throws SQLException {

        Connection connection = null;
        Statement statement = null;

        List<Contact> details=new ArrayList<>();
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_service", "root", "root");
            statement = connection.createStatement();
            String query = "Select * from addressbook where Start_Date between Cast('2020-01-01' as date) and date(now())";

            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                Contact info = new Contact();

                int id=result.getInt(1);
                info.setId(id);

                String firstName = result.getString(2);
                info.setFirstName(firstName);

                String lastName = result.getString(3);
                info.setLastName(lastName);

                String address = result.getString(4);
                info.setAddress(address);

                String city = result.getString(5);
                info.setCity(city);

                String phoneNo = result.getString(8);
                info.setPhoneNo(phoneNo);

                details.add(info);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
        }
        return details;
    }
    public List<Contact> getContactByCity() throws SQLException {

        Connection connection = null;
        Statement statement = null;

        List<Contact> details=new ArrayList<>();
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_service", "root", "root");
            statement = connection.createStatement();
            String query = "select * from addressbook where City = 'Bhandara'";

            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                Contact info = new Contact();

                int id=result.getInt(1);
                info.setId(id);

                String firstName = result.getString(2);
                info.setFirstName(firstName);

                String lastName = result.getString(3);
                info.setLastName(lastName);

                String address = result.getString(4);
                info.setAddress(address);

                String city = result.getString(5);
                info.setCity(city);

                String phoneNo = result.getString(8);
                info.setPhoneNo(phoneNo);

                details.add(info);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
        }
        return details;
    }
}