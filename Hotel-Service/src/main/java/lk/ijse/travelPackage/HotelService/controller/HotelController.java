package lk.ijse.travelPackage.HotelService.controller;

import lk.ijse.travelPackage.HotelService.dto.HotelDTO;
import lk.ijse.travelPackage.HotelService.service.HotelService;
import lk.ijse.travelPackage.HotelService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/hotel")
@CrossOrigin
public class HotelController {
    @Autowired
    HotelService hotelService;

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveHotel(@RequestPart("file") MultipartFile file,
                                  @RequestPart("hotel") HotelDTO hotelDTO) throws IOException {
        System.out.println("hii");
        return new ResponseUtil(200, "save", hotelService.saveHotel(hotelDTO, file));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllHotel() {
        return new ResponseUtil(200, "AllHotelsGet", hotelService.getAllHotels());
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateHotel(@RequestPart("file") MultipartFile file,
                                      @RequestPart("hotel") HotelDTO hotelDTO) throws IOException {
        return new ResponseUtil(200, "update", hotelService.updateHotel(hotelDTO, file));
    }

    @DeleteMapping(params = {"hotelId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteHotel(@RequestParam int hotelId) {
        hotelService.deleteHotel(hotelId);
        return new ResponseUtil(200, "deleted", null);
    }
    @GetMapping("/search")
    public ResponseUtil searchHotel(@RequestParam(value = "hotelId") Integer hotelId) {

        return new ResponseUtil(200,"Ok",hotelService.searchHotel(hotelId));
    }
    @GetMapping("/get")
    public ResponseUtil searchHotelByCategory(@RequestParam(value = "category") String category) {

        return new ResponseUtil(200,"Ok",hotelService.searchHotelByCategory(category));
    }

}
