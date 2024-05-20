package org.harender.testCases;


import io.restassured.response.Response;
import org.harender.utils.Log;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetRequests {

    private static final String URL = "https://reqres.in/api/users/";

    @Test(priority = 1)
    public void getRequestGetAllUsers(){
        String allUsersBody=given().when().get(URL).getBody().asPrettyString();
        System.out.println(allUsersBody);
    }

    @Test(priority = 2)
    public void getRequestGetParticularUserInformation(){
        int userID=2;
        Response response=given().when().get(URL+userID);
        System.out.println(
                "Status Code - "+response.getStatusCode()+
                "\nSimple Response.getTime -"+response.getTime()+
                "\n\nResponse.getTime(TimeUnit.MILLISECONDS(Default)) - "+response.getTimeIn(TimeUnit.MILLISECONDS)+
                "\nResponse.getTime(TimeUnit.SECONDS) - "+response.getTimeIn(TimeUnit.SECONDS)+
                "\nWe can take in Minutes,Days,Hours,Seconds,Nanoseconds,Microseconds,MilliSeconds also"+
                "\n\nresponse.getContentType()) - "+response.getContentType()+
                "\n\nresponse.getHeaders() - "+response.getHeaders()+
                "\n\nresponse.getHeader('Report-To') - "+response.getHeader("Report-To")+
                "\n\nresponse.getHeader('Reporting-Endpoints') - "+response.getHeader("Reporting-Endpoints")+
                "\n\nresponse.getSessionId() - "+response.getSessionId()+
                "\n\nresponse.getCookies() - "+response.getCookies()+
                "\n\nresponse.getDetailedCookies() - "+response.getDetailedCookies()+
                "\n\nresponse.getStatusLine() - "+response.getStatusLine()
        );

    }

//    @DataProvider(name = "getUserData")
//    public Iterator<Object[]> getUsers() {
//        final List<Object[]> getData = new ArrayList<>();
//        getData.add(new Object[]{2});
//        return getData.iterator();
//    }

//    @Test(dataProvider = "getUserData")
//    public void getRequestTest(final int userId) {
//        given().when()
//                .get(URL + userId)
//                .then()
//                .statusCode(200)
//                .and()
//                .assertThat()
//                .body("data.id", equalTo(userId));
//
//        System.out.println(given().when().get(URL+userId).body().prettyPrint());
//        final int statusCode = given().when()
//                .get(URL + userId)
//                .statusCode();
//        Log.info(statusCode);
//
//        final String responseBody = given().when()
//                .get(URL + userId)
//                .getBody()
//                .asString();
//        Log.info(responseBody);
//    }
//
//    @Test(dataProvider = "getUserData")
//    public void getRequestTestWithQueryParam(final int userPage) {
//        given().when()
//                .queryParam("page", userPage)
//                .get(URL)
//                .then()
//                .statusCode(200)
//                .and()
//                .assertThat()
//                .body("page", equalTo(userPage));
//
//        final String responseBody = given().when()
//                .queryParam("page", userPage)
//                .get(URL)
//                .getBody()
//                .asString();
//        Log.info(responseBody);
//    }

}
