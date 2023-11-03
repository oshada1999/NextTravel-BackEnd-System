package lk.ijse.travelPackage.GuideService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuideDTO {
    private Integer guideId;
    private String guideName;
    private String guideAddress;
    private String guideDob;
    private String guideGender;
    private String guideContact;
    private String guideExperience;
    private double guideManDay_value;
    private String guideEmail;
    private String guideStatus;

    private byte[] guideNICImageFront;
    private byte[] guideNICImageRear;
    private byte[] guideIDImageFront;
    private byte[] guideIDImageRear;
    private byte[] guideImage;
}
