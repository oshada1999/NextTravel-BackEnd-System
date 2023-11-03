package lk.ijse.travelPackage.HotelService.entity;


import lk.ijse.travelPackage.HotelService.embeded.Contact;
import lk.ijse.travelPackage.HotelService.embeded.RoomOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    @Column(nullable = false)
    private String hotelName;

    @Column(nullable = false)
    private String hotelCategory;

    @Column(nullable = false)
    private String hotelLocation;

    @Column(nullable = false)
    private String hotelGmapLocation;

    @Column(nullable = false,unique = true)
    private String hotelEmail;

    @Column(nullable = false)
    private Contact hotelContact;

    @Column(nullable = false)
    private String hotelPetAllow;

    @Column(nullable = false)
    private String hotelCancellationCriteria;

    @Column(nullable = false)
    private RoomOption hotelRoomOpt;

    @Lob
    private byte[] hotelImage;

}
