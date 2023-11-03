package lk.ijse.travelPackage.VehicleService.service.impl;

import lk.ijse.travelPackage.VehicleService.dto.VehicleDTO;
import lk.ijse.travelPackage.VehicleService.entity.Vehicle;
import lk.ijse.travelPackage.VehicleService.repository.VehicleRepository;
import lk.ijse.travelPackage.VehicleService.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO, List<MultipartFile> files) throws IOException {

        if (!vehicleRepository.existsById(vehicleDTO.getVehicleId())) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleId(vehicleDTO.getVehicleId());
            vehicle.setVehicleBrand(vehicleDTO.getVehicleBrand());
            vehicle.setVehicleCategory(vehicleDTO.getVehicleCategory());
            vehicle.setVehicleType(vehicleDTO.getVehicleType());
            vehicle.setVehicleHybridOrNot(vehicleDTO.getVehicleHybridOrNot());
            vehicle.setVehicleFuelType(vehicleDTO.getVehicleFuelType());
            vehicle.setVehicleFuelUsage(vehicleDTO.getVehicleFuelUsage());
            vehicle.setVehicleSeatCapacity(vehicleDTO.getVehicleSeatCapacity());
            vehicle.setVehicleTransmissionType(vehicleDTO.getVehicleTransmissionType());
            vehicle.setVehicleFee_for_1km(vehicleDTO.getVehicleFee_for_1km());
            vehicle.setVehicleFee_for_Day(vehicleDTO.getVehicleFee_for_Day());
            vehicle.setVehicleStatus(vehicleDTO.getVehicleStatus());
            vehicle.setVehicleDriverName(vehicleDTO.getVehicleDriverName());
            vehicle.setVehicleDriverContact(vehicleDTO.getVehicleDriverContact());


                vehicle.setVehicleDriverLicense(files.get(0).getBytes());
                vehicle.setFrontImage(files.get(1).getBytes());
                vehicle.setRearImage(files.get(2).getBytes());
                vehicle.setSideImage(files.get(3).getBytes());
                vehicle.setFrontInteriorImage(files.get(4).getBytes());
                vehicle.setRearInteriorImage(files.get(5).getBytes());



            return mapper.map(vehicleRepository.save(vehicle), VehicleDTO.class);
        } else {
            throw new RuntimeException("This ID Already exist!");
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return mapper.map(vehicleRepository.findAll(), new TypeToken<List<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO, List<MultipartFile> files) throws IOException {
        if (vehicleRepository.existsById(vehicleDTO.getVehicleId())){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleId(vehicleDTO.getVehicleId());
            vehicle.setVehicleBrand(vehicleDTO.getVehicleBrand());
            vehicle.setVehicleCategory(vehicleDTO.getVehicleCategory());
            vehicle.setVehicleType(vehicleDTO.getVehicleType());
            vehicle.setVehicleHybridOrNot(vehicleDTO.getVehicleHybridOrNot());
            vehicle.setVehicleFuelType(vehicleDTO.getVehicleFuelType());
            vehicle.setVehicleFuelUsage(vehicleDTO.getVehicleFuelUsage());
            vehicle.setVehicleSeatCapacity(vehicleDTO.getVehicleSeatCapacity());
            vehicle.setVehicleTransmissionType(vehicleDTO.getVehicleTransmissionType());
            vehicle.setVehicleFee_for_1km(vehicleDTO.getVehicleFee_for_1km());
            vehicle.setVehicleFee_for_Day(vehicleDTO.getVehicleFee_for_Day());
            vehicle.setVehicleStatus(vehicleDTO.getVehicleStatus());
            vehicle.setVehicleDriverName(vehicleDTO.getVehicleDriverName());
            vehicle.setVehicleDriverContact(vehicleDTO.getVehicleDriverContact());


            vehicle.setVehicleDriverLicense(files.get(0).getBytes());
            vehicle.setFrontImage(files.get(1).getBytes());
            vehicle.setRearImage(files.get(2).getBytes());
            vehicle.setSideImage(files.get(3).getBytes());
            vehicle.setFrontInteriorImage(files.get(4).getBytes());
            vehicle.setRearInteriorImage(files.get(5).getBytes());



            return mapper.map(vehicleRepository.save(vehicle), VehicleDTO.class);
        } else {
            throw new RuntimeException("Wrong ID !");
        }
    }

    @Override
    public void deleteVehicle(int vehicleId) {
        if (vehicleRepository.existsById(vehicleId)) {
            vehicleRepository.deleteById(vehicleId);
        } else {
            throw new RuntimeException("Please check the Vehicle ID.. No Such Vehicle..!");
        }
    }

    @Override
    public VehicleDTO searchVehicle(Integer vehicleId) {
        if (vehicleRepository.existsById(vehicleId)) {
            return mapper.map(vehicleRepository.getByVehicleId(vehicleId), VehicleDTO.class);
        } else {
            throw new RuntimeException("Search Failed, No Vehicle Available For " + vehicleId);
        }
    }

    @Override
    public List<VehicleDTO> searchVehicleByCategory(String category) {
        if (vehicleRepository.existsByVehicleCategory(category)) {
            if (vehicleRepository.existsByVehicleStatus("Available")){
                return mapper.map(vehicleRepository.getAllByVehicleCategoryAndVehicleStatus(category,"Available"), new TypeToken<List<VehicleDTO>>() {
                }.getType());
            }else {
                throw new RuntimeException("Search Failed, No Vehicle Available For " + category);
            }
        } else {
            throw new RuntimeException("Search Failed, No Vehicle Available For " + category);
        }
    }
}
