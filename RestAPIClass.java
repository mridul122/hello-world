package TestngPackage;

//import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseLogSpecification;
import jdk.jfr.events.ThrowablesEvent;
import jdk.management.resource.SimpleMeter;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;


public class RestAPIClass {


    //private static ThrowablesEvent httpRequest;

    public static void main (String [] args)
  {

      RestAssured.baseURI="https://maps.googleapis.com";



               Response res=given()
              .param("input", "mongolian%20grill")
              .param("inputtype  ", "textquery")
              .param("fields", "photos,formatted_address,name,opening_hours,rating")
              .param("locationbias", "circle:2000@47.6918452,-122.2226413")
              .param("key", "YOURKEY")  //please use your key
              .when().get("/maps/api/place/findplacefromtext/json")
              .then().assertThat().statusCode(200).and().body("status",equalTo("REQUEST_DENIED")).extract().response();
               String response = res.asString();

               System.out.println(response);
    /*Converting the string to Json and exacting a field value as String*/
      JsonPath js = new JsonPath(response);
      String status=js.get("error_message");
      System.out.println(status);

	  



  }
}
