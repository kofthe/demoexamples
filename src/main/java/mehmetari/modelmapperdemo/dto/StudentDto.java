package mehmetari.modelmapperdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String name;
    private String lastName;
    private int studentNo;
    private String email;

}
