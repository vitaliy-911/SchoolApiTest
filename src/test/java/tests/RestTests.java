package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojos.PupilResponse;
import pojos.SchoolResponse;
import services.PupilService;
import services.SchoolService;

import java.util.List;

public class RestTests {
    private final SchoolService schoolService = new SchoolService();
    private final PupilService pupilService = new PupilService();

    @Test
    public void getAllSchools() {
        List<SchoolResponse> allSchool = schoolService.getAllSchool();
        Assertions.assertNotNull(allSchool, " лист не пустой");
    }

    @Test
    public void getSchoolById() {
        SchoolResponse schoolById = schoolService.getSchoolById(1);
        Assertions.assertNotNull(schoolById, "не null");
    }

    @Test
    public void getAllPupilsBySchoolId() {
        List<PupilResponse> allPupilsBySchoolId = pupilService.getAllPupilsBySchoolId(1);
        Assertions.assertNotNull(allPupilsBySchoolId, " лист не пустой");

    }

}


