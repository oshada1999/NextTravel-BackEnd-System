package lk.ijse.travelPackage.VehicleService.service;


import lk.ijse.travelPackage.VehicleService.dto.VehicleDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO vehicleDTO, List<MultipartFile> files) throws IOException;

    List<VehicleDTO> getAllVehicles();

    VehicleDTO updateVehicle(VehicleDTO vehicleDTO, List<MultipartFile> file) throws IOException;

    void deleteVehicle(int vehicleId);

    VehicleDTO searchVehicle(Integer vehicleId);

    List<VehicleDTO> searchVehicleByCategory(String category);


   /* UserDTO updateUser(UserDTO userDTO, MultipartFile file) throws IOException;

    void deleteUser(int userId);

    List<UserDTO> getAllUsers();*/
}
