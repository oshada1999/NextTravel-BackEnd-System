package lk.ijse.travelPackage.UserService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {

    private Integer userId;

    private String userName;

    private String password;

    private String age;

    private String contact;

    private String email;

    private String address;

    private String gender;

    private String nic;

    private byte[] profilePic;
}
