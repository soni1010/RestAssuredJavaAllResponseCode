package org.harender.testCases;


import org.harender.utils.Log;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetRequests {

    private static final String URL = "https://reqres.in/api/users/";

    @DataProvider(name = "getUserData")
    public Iterator<Object[]> getUsers() {
        final List<Object[]> getData = new ArrayList<>();
        getData.add(new Object[]{2});
        return getData.iterator();
    }

    @Test(dataProvider = "getUserData")
    public void getRequestTest(final int userId) {
        given().when()
                .get(URL + userId)
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("data.id", equalTo(userId));

        System.out.println(given().when().get(URL+userId).body().prettyPrint());
        final int statusCode = given().when()
                .get(URL + userId)
                .statusCode();
        Log.info(statusCode);

        final String responseBody = given().when()
                .get(URL + userId)
                .getBody()
                .asString();
        Log.info(responseBody);
    }

    @Test(dataProvider = "getUserData")
    public void getRequestTestWithQueryParam(final int userPage) {
        given().when()
                .queryParam("page", userPage)
                .get(URL)
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("page", equalTo(userPage));

        final String responseBody = given().when()
                .queryParam("page", userPage)
                .get(URL)
                .getBody()
                .asString();
        Log.info(responseBody);
    }

}
