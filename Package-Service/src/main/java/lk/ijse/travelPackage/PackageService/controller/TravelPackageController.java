package lk.ijse.travelPackage.PackageService.controller;


import lk.ijse.travelPackage.PackageService.dto.TravelPackageDTO;
import lk.ijse.travelPackage.PackageService.service.TravelPackageService;
import lk.ijse.travelPackage.PackageService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/package")
@CrossOrigin
public class TravelPackageController {
    @Autowired
    TravelPackageService travelPackageService;

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveTravelPackage(@RequestPart("file") MultipartFile file,
                                          @RequestPart("TravelPackage") TravelPackageDTO travelPackageDTO) throws IOException {
        System.out.println("hii");
        return new ResponseUtil(200, "save", travelPackageService.saveTravelPackage(travelPackageDTO, file));
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllTravelPackage() {
        return new ResponseUtil(200, "AllPackagesGet", travelPackageService.getAllTravelPackages());
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateTravelPackage(@RequestPart("file") MultipartFile file,
                                      @RequestPart("TravelPackage") TravelPackageDTO travelPackageDTO) throws IOException {
        return new ResponseUtil(200, "update", travelPackageService.updateTravelPackage(travelPackageDTO, file));
    }
    @DeleteMapping(params = {"packageId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deletePackage(@RequestParam int packageId) {
        travelPackageService.deletePackage(packageId);
        return new ResponseUtil(200, "deleted", null);
    }
}
