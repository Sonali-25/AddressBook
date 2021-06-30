package com.magic.addressbookdb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;


import java.sql.SQLException;
import java.util.List;

public class AddressBookTest {

    @Test
    public void shouldAnswerWithTrue()
    {
        Assertions.assertTrue( true );
    }

    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() throws SQLException {
        AddressbookRepo repo = new AddressbookRepo();
        List<Contact> contactData = repo.findAll();
        Assertions.assertEquals(10, contactData.size());
    }
    @Test
    public void insertionOf_Multiple_Person_multithreadingBased() throws SQLException{
        AddressbookData[] data = {
                new AddressbookData("Mark","Smith","WestVilla","Kentucky","NewStates","510034","9000056102","mark123@gmail.com","2020-04-21"),
                new AddressbookData("Gary","Lu","CrossHill","Missouri","Texas","120000","911456102","lu@gmail.com","2020-05-11"),
                new AddressbookData("Sam","Sam","OxfordRoad","Vegas","LasVegas","842300","990156102","sam@outlook.com","2020-05-25")
        };

        AddressbookRepo repo = new AddressbookRepo();
        Instant start = Instant.now();

        Arrays.stream(data).forEach(value -> {
            Runnable task = () ->{
                try {
                    repo.insertMultipleRecord(value);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            };
            Thread thread = new Thread(task, value.getFirstName());
            thread.start();
        });
        Instant end = Instant.now();
        System.out.println("Duration with thread:" +Duration.between(start, end));
    }

}



