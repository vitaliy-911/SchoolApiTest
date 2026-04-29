package services;

import pojos.PupilResponse;
import pojos.SchoolResponse;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PupilService extends RestService{


    @Override
    protected String getBasePath() {
        return "pupil";
    }

    public List<PupilResponse>getAllPupilsBySchoolId(int id){
        return given().spec(REQ_SPEC)
                .get().jsonPath().getList("pupils", PupilResponse.class);
    }
}
