package com.magic.addressbookdb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}
