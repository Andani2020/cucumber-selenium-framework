package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.devtools.v102.fetch.model.AuthChallengeResponse;
import stepDefinations.WebActionStepDefs;

import static io.restassured.RestAssured.given;

public class GetSkinColour {

    private static final Logger logger = LogManager.getLogger(GetSkinColour.class);


    @Test
    public void getSkinColour(){

        //base URI
        RestAssured.baseURI="https://swapi.dev/api";

        //Request object
        RequestSpecification httpRequest= given();

        //Response Object
        Response response =httpRequest.request(Method.GET,"people");

        //Print response
        String  responseBody = response.getBody().asString();
        logger.debug("Response Body is "+ responseBody);

        //Response  validation

        int statusCode =response.getStatusCode();
        logger.debug("Status code is "+ statusCode);
        Assert.assertEquals(statusCode,200);

        String name = given().contentType(ContentType.JSON).log().all().get("R2-D2").then().extract().path("name");
        String skinColor = given().contentType(ContentType.JSON).log().all().get("white, blue").then().extract().path("skin_color");
        logger.debug("the skin colour of  "+ name+" is "+skinColor);
        Assert.assertEquals(name,"R2-D2");
        Assert.assertEquals(skinColor,"white, blue");


    }

}
