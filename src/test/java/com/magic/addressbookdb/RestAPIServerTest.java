package com.magic.addressbookdb;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.testing.annotations.DataProvider;
import io.restassured.http.ContentType;

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
    @DataProvider(name = "dataForPost")
    public Object[][] dataForPost() {
        return new Object[][] {
                {"Mark","Smith","WestVilla","Kentucky","NewStates","9000056102","mark123@gmail.com"},
                {"Sam","Sam","OxfordRoad","Vegas","LasVegas","990156102","sam@outlook.com"}
        };
    }

    @Test(dataProvider = "dataForPost")
    public void addMultipleRecords_shouldReturn_201statusCode(String firstName, String lastName, String address, String city, String state, String phoneNumber ,String emailId) {
        JSONObject request = new JSONObject();

        request.put("FirstName", firstName);
        request.put("LastName",  lastName);
        request.put("Address", address);
        request.put("City", city);
        request.put("State", state);
        request.put("PhoneNumber", phoneNumber);
        request.put("EmailId", emailId);

        baseURI ="http://localhost";
        port = 3000;

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toString()).
                when().
                post("/Contacts").
                then().
                statusCode(201).
                log().all();
    }
    @Test
    public void addSingleRecords_shouldReturn_201statusCode() {
        JSONObject request = new JSONObject();

        request.put("FirstName", "Nikita");
        request.put("LastName",  "Pardhi");
        request.put("Address", "Tilak Nagar");
        request.put("City","Nagpur");
        request.put("State", "MH");
        request.put("PhoneNumber", "13254678");
        request.put("EmailId", "nikita@rediffmail.com");

        baseURI ="http://localhost";
        port = 3000;

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toString()).
                when().
                post("/Contacts").
                then().
                statusCode(201).
                log().all();
    }
    @Test
    public void updateExistingRecord_shouldReturn_200statusCode() {
        JSONObject request = new JSONObject();
        request.put("firstName", "Pranali" );
        baseURI ="http://localhost";
        port = 3000;
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toString()).
                when().
                patch("/Contacts/4").
                then().
                statusCode(200).
                log().all();
    }
    @Test
    public void deleteData_fromExistingRecord_shouldReturn_200statusCode() {
        baseURI ="http://localhost";
        port = 3000;

        when().
                delete("/Contacts/4").
                then().
                statusCode(200).
                log().all();

    }
}
