package lk.ijse.travelPackage.PackageService.entity;

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
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelPackage_Id;

    @Column(nullable = false)
    private String travelPackage_Category;

    @Column(nullable = false)
    private String travelPackage_Areas;

    @Column(nullable = false)
    private String guide_id;

    @Column(nullable = false)
    private String vehicle_id;

    @Column(nullable = false)
    private String hotel_id;

    @Column(nullable = false)
    private String customer_id;

    @Column(nullable = false)
    private double travelPackage_Value;

    @Column(nullable = false)
    private double travelPackage_PaidValue;

    @Column(nullable = false)
    private String travelPackage_NeedGuide;

    @Column(nullable = false)
    private String travelPackage_WithPet;

    @Column(nullable = false)
    private int travelPackage_HeadCount;

    @Column(nullable = false)
    private int travelPackage_No_Child;

    @Column(nullable = false)
    private int travelPackage_No_Adult;

    @Column(nullable = false,columnDefinition = "DATE")
    //@JsonFormat(pattern = "yyyy-mm-dd")
    private String travelPackage_StartDate;

    @Column(nullable = false,columnDefinition = "DATE")
    //@JsonFormat(pattern = "yyyy-mm-dd")
    private String travelPackage_EndDate;

    @Column(nullable = false)
    private String travelPackage_DateDuration;

    @Lob
    private byte[] paidBankSlip;

}
