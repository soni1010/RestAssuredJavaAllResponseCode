package org.harender.testCases;

import com.jayway.jsonpath.ReadContext;
import io.restassured.path.json.JsonPath;
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

    @Test
    public void tryGetRequestToGetIndividualFromListOfResource(){
        System.out.println("\n===========================> Method - 'tryGetRequestToGetIndividualFromListOfResource' output below :");
        String endPointForListOdfResources="unknown/";
        int individualResourceID=2;
        Response response=given().get(URL+endPointForListOdfResources+individualResourceID);
        System.out.println("Response Time (In Milliseconds) - "+response.getTimeIn(TimeUnit.MILLISECONDS));
        System.out.println(response.getBody().asPrettyString());
        System.out.println("\n Content Type- "+response.getContentType()+"\n");
        System.out.println("|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|");

    }

    @Test
    public void tryGetRequestToGetIndividualFromListOfResourceWithJsonPath(){
        System.out.println("\n===========================> Method - 'tryGetRequestToGetIndividualFromListOfResourceWithJsonPath' output below :");
        String endPointForListOdfResources="unknown/";
        int individualResourceID=2;
        Response response=given().get(URL+endPointForListOdfResources+individualResourceID);
        //System.out.println(response.getBody().asPrettyString());
        System.out.println("\nContent Type- "+response.getContentType()+"\n");
        System.out.println("\nResponse Code- "+response.getStatusCode()+"\n");
        System.out.println("|--------------------------------- JSON_Path use ---------------------------------|");
        JsonPath jsonPathEvaluator = response.jsonPath();
        String dataName = jsonPathEvaluator.get("data.name");
        System.out.println("Always use the DataType of Variable whatever it is coming in Response \nLike Here 'ID' is 'Integer' \nso we saved in 'Integer' dataType 'Variable'\n");
        Integer dataId = jsonPathEvaluator.get("data.id");
        String supportURL = jsonPathEvaluator.get("support.url");
        String supportText = jsonPathEvaluator.get("support.text");

        System.out.println(
                "Name- "+dataName+
                "\nID- "+dataId+
                "\nSupportUrl- "+supportURL+
                "\nSupportText- "+supportText
        );

       // System.out.println("|--------------- Json Response Read using 'Jayway.jsonPath' Library ---------------|");
       // response.body().prettyPrint();

       // String responseAsAString=response.asString();
       // System.out.println(responseAsAString);
       // ReadContext ctx= com.jayway.jsonpath.JsonPath.parse(responseAsAString);
       // System.out.println("Name- "+ctx.read("$data.name"));

        System.out.println("|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|");

    }

}
