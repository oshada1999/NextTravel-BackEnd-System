package lk.ijse.travelPackage.VehicleService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleId;

    @Column(nullable = false)
    private String vehicleBrand;

    @Column(nullable = false)
    private String vehicleCategory;

    @Column(nullable = false)
    private String vehicleType; //van,car,suv

    @Column(nullable = false)
    private String vehicleHybridOrNot;

    @Column(nullable = false)
    private String vehicleFuelType;

    @Column(nullable = false)
    private int    vehicleFuelUsage;

    @Column(nullable = false)
    private int    vehicleSeatCapacity;

    @Column(nullable = false)
    private String vehicleTransmissionType;

    @Column(nullable = false)
    private double vehicleFee_for_1km;

    @Column(nullable = false)
    private double vehicleFee_for_Day;

    @Column(nullable = false)
    private String vehicleStatus;

    @Column(nullable = false)
    private String vehicleDriverName;

    @Column(nullable = false)
    private String vehicleDriverContact;

    ///////////////////////////////////////////////

    @Lob
    private byte[] vehicleDriverLicense;

    @Lob
    private byte[] frontImage;

    @Lob
    private byte[] rearImage;

    @Lob
    private byte[] sideImage;

    @Lob
    private byte[] frontInteriorImage;

    @Lob
    private byte[] rearInteriorImage;
}
