package etiya.SportsClub.dto;

import etiya.SportsClub.entity.Role;
import etiya.SportsClub.entity.UserCourseBundleRecord;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
