package lk.ijse.travelPackage.HotelService.service;

import lk.ijse.travelPackage.HotelService.dto.HotelDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotelDTO, MultipartFile file) throws IOException;

    List<HotelDTO> getAllHotels();

    HotelDTO updateHotel(HotelDTO hotelDTO, MultipartFile file) throws IOException;

    void deleteHotel(int hotelId);

    HotelDTO searchHotel(Integer hotelId);

    List<HotelDTO> searchHotelByCategory(String category);
}
