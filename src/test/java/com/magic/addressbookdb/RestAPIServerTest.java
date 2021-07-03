package com.magic.addressbookdb;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class RestAPIServerTest {
    @Test
    public void given_EmployeeData_InJSONServer_WhenRetrieved_ShouldMatchTheCount()
    {
        given().
                get("http://localhost:3000/Contacts").
                then().
                statusCode(200).
                log().all();
    }
}
