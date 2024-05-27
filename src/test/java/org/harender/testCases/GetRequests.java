package org.harender.testCases;


import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;

public class GetRequests {

    private static final String URL = "https://reqres.in/api/";

    @Test(priority = 1)
    public void getRequestGetAllUsers(){
        System.out.println("\n===========================> Method - 'getRequestGetAllUsers' output below :");
        String allUsersBody=given().when().get(URL+"users/").getBody().asPrettyString();
        System.out.println(allUsersBody);
        System.out.println("|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|");

    }

    @Test(priority = 2)
    public void getRequestGetParticularUserInformation(){
        System.out.println("\n===========================> Method - 'getRequestGetParticularUserInformation' output below :");

        int userID=2;
        Response response=given().when().get(URL+"users/"+userID);
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
        System.out.println("|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|");

    }

    @Test(priority = 3)
    public void tryGetRequestGetParticularUserInformationWhichIsNotAvailable(){
        System.out.println("\n===========================> Method - 'tryGetRequestGetParticularUserInformationWhichIsNotAvailable' output below :");
        int notAvailableRecordUserID=23;
        Response response=given().when().get(URL+"users/"+notAvailableRecordUserID);
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
                "\n\nresponse.getStatusLine() - "+response.getStatusLine());
        System.out.println("|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|");

    }

    @Test(priority = 4)
    public void tryGetRequestListOfResources(){
        System.out.println("\n===========================> Method - 'tryGetRequestListOfResources' output below :");
        String endPointForListOdfResources="unknown";
        Response response=given().when().get(URL+endPointForListOdfResources);
        System.out.println("Status Code - "+response.getStatusCode()+
                        "\nSimple Response.getTime -"+response.getTime()+
                        "\n\nResponse.getTime(TimeUnit.MILLISECONDS(Default)) - "+response.getTimeIn(TimeUnit.MILLISECONDS)+
                        "\nResponse.getTime(TimeUnit.SECONDS) - "+response.getTimeIn(TimeUnit.SECONDS)+
                        "\nWe can take in Minutes,Days,Hours,Seconds,Nanoseconds,Microseconds,MilliSeconds also"+

                        "\n\nresponse.getContentType() - "+response.getContentType()+

                        "\n\nresponse.getHeaders() - "+response.getHeaders()+
                        "\n\nresponse.getHeader('Report-To') - "+response.getHeader("Report-To")+
                        "\n\nresponse.getHeader('Reporting-Endpoints') - "+response.getHeader("Reporting-Endpoints")+

                        "\n\nresponse.getSessionId() - "+response.getSessionId()+
                        "\n\nresponse.getCookies() - "+response.getCookies()+
                        "\n\nresponse.getDetailedCookies() - "+response.getDetailedCookies()+
                        "\n\nresponse.getStatusLine() - "+response.getStatusLine()+
                "\n\n Response "+ response.getBody().asPrettyString()
                );
        System.out.println("|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|");

    }


}
