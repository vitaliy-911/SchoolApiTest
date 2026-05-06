package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class TestSchool extends RestService{

    @Override
    protected String getBasePath() {
        return "/school";
    }


    @Test
    public void getAllSchools (){
        Response response= given().spec(REQ_SPEC )
                .get("/schools");
        List<Object> id = response.jsonPath().getList("id");
        List<Object> list = response.jsonPath().getList("pupilList");

        System.out.println(list);

    }

    @Test
    public void getSchoolHello (){
        given().spec(REQ_SPEC)
                .when().get()
                .then().statusCode(404)
                .log().body();
    }

    @Test
    public void getSchoolById(){
        given().spec(REQ_SPEC)
                .queryParam("idSchool",1)
                .when().get("schoolId")
                .then().statusCode(200)
                .log().body();
    }
}
