package services;

import pojos.SchoolResponse;

import java.util.List;

import static io.restassured.RestAssured.given;


public class SchoolService extends RestService {
    @Override
    protected String getBasePath() {
        return "school";
    }

    public List<SchoolResponse> getAllSchool() {
        return given().spec(REQ_SPEC)
                .get().jsonPath().getList("schools", SchoolResponse.class);
    }

    public SchoolResponse getSchoolById(int id) {
       return given().get("/" + id)
                .as(SchoolResponse.class);
    }


}




