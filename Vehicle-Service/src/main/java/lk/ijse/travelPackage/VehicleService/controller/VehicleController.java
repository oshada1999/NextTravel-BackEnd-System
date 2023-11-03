package lk.ijse.travelPackage.VehicleService.controller;


import lk.ijse.travelPackage.VehicleService.dto.VehicleDTO;
import lk.ijse.travelPackage.VehicleService.service.VehicleService;
import lk.ijse.travelPackage.VehicleService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(@RequestPart("file") List<MultipartFile> file,
                                    @RequestPart("vehicle") VehicleDTO vehicleDTO) throws IOException {
        return new ResponseUtil(200, "save", vehicleService.saveVehicle(vehicleDTO, file));
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicle(@RequestPart("file") List<MultipartFile> file,
                                 @RequestPart("vehicle") VehicleDTO vehicleDTO) throws IOException {
        return new ResponseUtil(200, "update", vehicleService.updateVehicle(vehicleDTO, file));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicle() {
        return new ResponseUtil(200, "AllVehiclesGet", vehicleService.getAllVehicles());
    }
    @DeleteMapping(params = {"vehicleId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicle(@RequestParam int vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseUtil(200, "deleted", null);
    }
    @GetMapping("/search")
    public ResponseUtil searchVehicle(@RequestParam(value = "vehicleId") Integer vehicleId) {

        return new ResponseUtil(200,"Ok",vehicleService.searchVehicle(vehicleId));
    }
    @GetMapping("/get")
    public ResponseUtil searchVehicleByCategory(@RequestParam(value = "category") String category) {

        return new ResponseUtil(200,"Ok",vehicleService.searchVehicleByCategory(category));
    }

}
