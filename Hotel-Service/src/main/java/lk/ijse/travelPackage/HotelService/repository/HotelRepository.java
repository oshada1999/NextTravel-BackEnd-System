package lk.ijse.travelPackage.HotelService.repository;


import lk.ijse.travelPackage.HotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    boolean existsByHotelEmail(String email);
    boolean existsByHotelCategory(String category);
    Hotel getByHotelEmail(String email);
    List<Hotel> getAllByHotelCategory(String category);
    Hotel getByHotelId(Integer hotelId);
}
