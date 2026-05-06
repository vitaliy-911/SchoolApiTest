package pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PupilRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private int clazz;
    private String postfixClazz;

}
