package lk.ijse.travelPackage.UserService.service;

import lk.ijse.travelPackage.UserService.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO, MultipartFile file) throws IOException;

    UserDTO updateUser(UserDTO userDTO, MultipartFile file) throws IOException;

    void deleteUser(int userId);

    List<UserDTO> getAllUsers();

    void loginUserFind(String email,String password);

    UserDTO searchUser(String nic);
}
