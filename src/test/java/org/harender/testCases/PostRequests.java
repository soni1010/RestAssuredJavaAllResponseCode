package org.harender.testCases;

import io.restassured.*;

import io.restassured.config.*;
import io.restassured.filter.log.*;
import io.restassured.http.*;
import io.restassured.response.*;
import io.restassured.specification.*;
import net.minidev.json.*;
import org.harender.utils.Users;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PostRequests {
    Response response;
    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;

    @BeforeClass(enabled = false)
    public void setup() {
        // Setting the Global Request and Response Logging Configuration
        RestAssured.config = RestAssured.config()
                .logConfig(LogConfig.logConfig()
                        .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.STATUS)
                        .enablePrettyPrinting(true));
        // Enable global request and response logging filters
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test(enabled = false, description = "This Test was to try 'POST' request and get various response " +
            "output including Automation created 'ID' by the request to create new record")
    public void postRequestWithAutomaticallyGeneratedID_Response(){
        // Data To Create Record
        String jsonString = "{\"name\":\"Harender\",\"job\":\"Leader\"}";

        //Got Response and from response further we can get all required other fields
        response=given().body(jsonString)
                .when().post(BaseTest.baseURI_Post);

        // Receiving newly created Record ID and that ID is created automatically by the Post Request
        String newlyCreatedRecordID=response.then().extract().path("id");
        System.out.println("New Created Id(Got Value Using Response.Then().Extract.Path) - "+newlyCreatedRecordID);

        // We can Extract from Response object also like Below
        System.out.println(
                "Using       --> [response.getStatusCode] \nValue we got--> "+response.getStatusCode()+"\n\n"+
                "Using       --> [response.getStatusLine] \nValue we got--> "+response.getStatusLine()+"\n\n"+
                "Using       --> [response.getTimeIn] \nValue we got--> "+response.getTimeIn(TimeUnit.MILLISECONDS)+"\n\n"+
                "Using       --> [response.getContentType] \nValue we got--> "+response.getContentType()+"\n\n"+
                "Using       --> [response.getHeader('Content-Length')] \nValue we got--> "+response.getHeader("Content-Length")+"\n\n"+
                "Using       --> [response.getBody().path('id')] \nValue we got--> "+response.getBody().path("id")
        );
    }

    @Test(enabled = false)
    public void SimplePostRequest(){

        String jsonString = "{\"name\":\"Harender\",\"job\":\"Leader\"}";

        RestAssured.baseURI = "https://reqres.in/api/users";

        // Create a request specification
        requestSpecification = RestAssured.given();

        // Setting content type to specify format in which request payload will be sent.
        requestSpecification.contentType(ContentType.JSON);

        // Adding body as string
        requestSpecification.body(jsonString);

        // Calling POST method
        response = requestSpecification.post();

        String id=response.then().extract().path("id");
        System.out.println("New Record Created Successfully with ID - "+id);

        // Let's print response body.
        String responseString = response.prettyPrint();

        /*
         * To perform validation on response, we need to get ValidatableResponse type of
         * response
         */
        validatableResponse = response.then();

        // Check status code
        validatableResponse.statusCode(201);

        // It will check if status line is as expected
        validatableResponse.statusLine("HTTP/1.1 201 Created");

        // Check response body - name attribute
        validatableResponse.body("name", equalTo("Harender"));




    }

    @Test(description = "")
    public void SimplePostRequestWithPOJO_ToCreateRecord(){
        Users user=new Users("Harender","Leader");

        response=
        given().
                contentType(ContentType.JSON).
                body(user).
        when().
                post(BaseTest.baseURI_Post);

        if(response.getStatusCode()==201)
            System.out.println("Record with 'ID - "+response.then().extract().path("id")+"' Created Successfully !");

        System.out.println(
                "Created With ID - "+response.then().extract().path("id")+"\n"+
                "Name - "+response.then().extract().path("name")+"\n"+
                "Job - "+response.then().extract().path("job")+"\n"+
                "Created At - "+response.then().extract().path("createdAt")+"\n"+
                "Response Code - "+response.getStatusCode()+"\n"+
                "Response Time - "+response.getTimeIn(TimeUnit.MILLISECONDS) +"MilliSeconds"
        );
    }


}
