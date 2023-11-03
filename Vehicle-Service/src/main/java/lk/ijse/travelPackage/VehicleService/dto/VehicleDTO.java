package lk.ijse.travelPackage.VehicleService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleDTO {
    private Integer vehicleId;
    private String vehicleBrand;
    private String vehicleCategory; //Rconomy,Mid-range,Luxury,Super Luxury
    private String vehicleType; //van,car,suv
    private String vehicleHybridOrNot;
    private String vehicleFuelType;
    private int    vehicleFuelUsage;
    private int    vehicleSeatCapacity;
    private double vehicleFee_for_1km;
    private double vehicleFee_for_Day;
    private String vehicleStatus;
    private String vehicleTransmissionType;//auto/manual
    private String vehicleDriverName;
    private String vehicleDriverContact;

    private byte[] vehicleDriverLicense;
    private byte[] frontImage;
    private byte[] rearImage;
    private byte[] sideImage;
    private byte[] frontInteriorImage;
    private byte[] rearInteriorImage;
}
