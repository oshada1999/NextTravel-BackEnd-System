package lk.ijse.travelPackage.GuideService.entity;

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
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer guideId;

    @Column(nullable = false)
    private String guideName;

    @Column(nullable = false)
    private String guideAddress;

    @Column(nullable = false)
    private String guideDob;

    @Column(nullable = false)
    private String guideGender;

    @Column(nullable = false)
    private String guideContact;

    @Column(nullable = false)
    private String guideExperience;

    @Column(nullable = false)
    private double guideManDay_value;

    @Column(nullable = false,unique = true)
    private String guideEmail;

    @Column(nullable = false)
    private String guideStatus;

    @Lob
    private byte[] guideNICImageFront;
    @Lob
    private byte[] guideNICImageRear;
    @Lob
    private byte[] guideIDImageFront;
    @Lob
    private byte[] guideIDImageRear;
    @Lob
    private byte[] guideImage;
}
