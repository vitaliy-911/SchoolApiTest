package pojos;

import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PupilResponse {
    private int idPupil;
    private String firstName;
    private String lastName;
    private String gender;
    private int clazz;
    private String postfixClazz;
}

