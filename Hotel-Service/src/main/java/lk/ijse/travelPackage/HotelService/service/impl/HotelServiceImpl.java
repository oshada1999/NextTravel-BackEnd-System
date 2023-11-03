package lk.ijse.travelPackage.HotelService.service.impl;

import lk.ijse.travelPackage.HotelService.dto.HotelDTO;
import lk.ijse.travelPackage.HotelService.entity.Hotel;
import lk.ijse.travelPackage.HotelService.repository.HotelRepository;
import lk.ijse.travelPackage.HotelService.service.HotelService;
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
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public HotelDTO saveHotel(HotelDTO hotelDTO, MultipartFile file) throws IOException {
        if (!hotelRepository.existsById(hotelDTO.getHotelId())) {
            if (!hotelRepository.existsByHotelEmail(hotelDTO.getHotelEmail())) {
                Hotel hotel = new Hotel();
                hotel.setHotelId(hotelDTO.getHotelId());
                hotel.setHotelName(hotelDTO.getHotelName());
                hotel.setHotelCategory(hotelDTO.getHotelCategory());
                hotel.setHotelLocation(hotelDTO.getHotelLocation());
                hotel.setHotelGmapLocation(hotelDTO.getHotelGmapLocation());
                hotel.setHotelEmail(hotelDTO.getHotelEmail());
                hotel.setHotelContact(hotelDTO.getHotelContact());
                hotel.setHotelPetAllow(hotelDTO.getHotelPetAllow());
                hotel.setHotelCancellationCriteria(hotelDTO.getHotelCancellationCriteria());
                hotel.setHotelRoomOpt(hotelDTO.getHotelRoomOpt());
                hotel.setHotelImage(file.getBytes());

                return mapper.map(hotelRepository.save(hotel), HotelDTO.class);
            } else {
                throw new RuntimeException("This Email Already exist!");
            }
        } else {
            throw new RuntimeException("This ID Already exist!");
        }
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        return mapper.map(hotelRepository.findAll(), new TypeToken<List<HotelDTO>>() {
        }.getType());
    }

    @Override
    public HotelDTO updateHotel(HotelDTO hotelDTO, MultipartFile file) throws IOException {
        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelDTO.getHotelId());
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setHotelCategory(hotelDTO.getHotelCategory());
        hotel.setHotelLocation(hotelDTO.getHotelLocation());
        hotel.setHotelGmapLocation(hotelDTO.getHotelGmapLocation());
        hotel.setHotelEmail(hotelDTO.getHotelEmail());
        hotel.setHotelContact(hotelDTO.getHotelContact());
        hotel.setHotelPetAllow(hotelDTO.getHotelPetAllow());
        hotel.setHotelCancellationCriteria(hotelDTO.getHotelCancellationCriteria());
        hotel.setHotelRoomOpt(hotelDTO.getHotelRoomOpt());
        hotel.setHotelImage(file.getBytes());

        if (hotelRepository.existsById(hotelDTO.getHotelId())) {
            if (hotelRepository.existsByHotelEmail(hotelDTO.getHotelEmail())) {
                if (hotelRepository.getByHotelEmail(hotelDTO.getHotelEmail()).getHotelId().equals(hotelDTO.getHotelId())){
                    return mapper.map(hotelRepository.save(hotel), HotelDTO.class);
                }else {
                    throw new RuntimeException("This Email Already exist!");
                }
            }else {
                return mapper.map(hotelRepository.save(hotel), HotelDTO.class);
            }
        } else {
            throw new RuntimeException("Wrong ID !");
        }
    }

    @Override
    public void deleteHotel(int hotelId) {
        if (hotelRepository.existsById(hotelId)) {
            hotelRepository.deleteById(hotelId);
        } else {
            throw new RuntimeException("Please check the Hotel ID.. No Such Hotel..!");
        }
    }

    @Override
    public HotelDTO searchHotel(Integer hotelId) {
        if (hotelRepository.existsById(hotelId)) {
            return mapper.map(hotelRepository.getByHotelId(hotelId), HotelDTO.class);
        } else {
            throw new RuntimeException("Search Failed, No Hotel Available For " + hotelId);
        }
    }

    @Override
    public List<HotelDTO> searchHotelByCategory(String category) {
        if (hotelRepository.existsByHotelCategory(category)) {
            return mapper.map(hotelRepository.getAllByHotelCategory(category), new TypeToken<List<HotelDTO>>() {
            }.getType());
        } else {
            throw new RuntimeException("Search Failed, No Hotel Available For " + category);
        }
    }
}
