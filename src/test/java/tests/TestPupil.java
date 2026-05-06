package tests;

import io.restassured.response.ValidatableResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojos.PupilRequest;
import pojos.PupilResponse;

import java.util.List;

import static io.restassured.RestAssured.given;

public class TestPupil extends RestService {
    private static final Log log = LogFactory.getLog(TestPupil.class);

    @Override
    protected String getBasePath() {
        return "/pupil";
    }

    @Test
    public void getPupilHello() {
        given().spec(REQ_SPEC)
                .when().get()
                .then().statusCode(404)
                .log().body();
    }

    @Test
    public void getAllPupilsBySchoolId() {
        List<PupilResponse> idSchool = given().spec(REQ_SPEC)
                .queryParam("idSchool", 1)
                .when().get("pupils")
                .then().statusCode(200)
                .extract().jsonPath().getList("", PupilResponse.class).stream().toList();
        Assertions.assertNotNull(idSchool);
        log.info(idSchool);
    }

    @Test
    public void getPupilByPupilIdAndSchoolId() {
        PupilResponse pupilResponse = given().spec(REQ_SPEC)
                .queryParam("idSchool", 1)
                .queryParam("idPupil", 1)
                .when().get("pupil")
                .then().statusCode(200)
                .log().all()
                .extract().body().as(PupilResponse.class);
        String firstName = pupilResponse.getFirstName();
        System.out.println(firstName);
    }

    @Test
    public void addPupilInSchoolById() {
        PupilRequest pupilRequest = PupilRequest.builder()
                .firstName("Korben")
                .lastName("Dallazor")
                .gender("MALE")
                .clazz(9)
                .postfixClazz("A").build();

        given().spec(REQ_SPEC)
                .body(pupilRequest)
                .queryParam("idSchool", 1)
                .log().all()
                .when().post("/add")
                .then().statusCode(200).log().body();
    }


    @Test
    public void deletePupilBySchoolIdAndPupilId() {
        ValidatableResponse body = given().spec(REQ_SPEC)
                .queryParam("idSchool", 1)
                .queryParam("idPupil", 46)
                .when().delete("/del")
                .then().statusCode(200).log().body();
        List<PupilResponse> list = body.extract().jsonPath().getList("", PupilResponse.class);
        int idPupil = list.getLast().getIdPupil();
        Assertions.assertEquals(45,idPupil);
    }

    @Test
    public void editPupilBySchoolIdAndPupilId() {
        PupilRequest build = PupilRequest.builder()
                .firstName("Lilu")
                .lastName("Dallas")
                .gender("FEMALE")
                .clazz(9)
                .postfixClazz("A")
                .build();

        given().spec(REQ_SPEC)
                .body(build)
                .queryParam("idSchool", 1)
                .queryParam("idPupil", 2)
                .when().put("/edit")
                .then().statusCode(200)
                .log().all();
    }

}
