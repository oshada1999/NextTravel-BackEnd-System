package lk.ijse.travelPackage.PackageService.service.impl;


import lk.ijse.travelPackage.PackageService.dto.TravelPackageDTO;
import lk.ijse.travelPackage.PackageService.entity.TravelPackage;
import lk.ijse.travelPackage.PackageService.repository.TravelPackageRepository;
import lk.ijse.travelPackage.PackageService.service.TravelPackageService;
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
public class TravelPackageImpl implements TravelPackageService {
    @Autowired
    TravelPackageRepository travelPackageRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public TravelPackageDTO saveTravelPackage(TravelPackageDTO travelPackageDTO, MultipartFile file) throws IOException {
        if (!travelPackageRepository.existsById(travelPackageDTO.getTravelPackage_Id())) {
            TravelPackage travelPackage = new TravelPackage();
            travelPackage.setTravelPackage_Id(travelPackageDTO.getTravelPackage_Id());
            travelPackage.setTravelPackage_Category(travelPackageDTO.getTravelPackage_Category());
            travelPackage.setTravelPackage_Areas(travelPackageDTO.getTravelPackage_Areas());
            travelPackage.setGuide_id(travelPackageDTO.getGuide_id());
            travelPackage.setVehicle_id(travelPackageDTO.getVehicle_id());
            travelPackage.setHotel_id(travelPackageDTO.getHotel_id());
            travelPackage.setCustomer_id(travelPackageDTO.getCustomer_id());
            travelPackage.setTravelPackage_Value(travelPackageDTO.getTravelPackage_Value());
            travelPackage.setTravelPackage_PaidValue(travelPackageDTO.getTravelPackage_PaidValue());
            travelPackage.setTravelPackage_NeedGuide(travelPackageDTO.getTravelPackage_NeedGuide());
            travelPackage.setTravelPackage_WithPet(travelPackageDTO.getTravelPackage_WithPet());
            travelPackage.setTravelPackage_HeadCount(travelPackageDTO.getTravelPackage_HeadCount());
            travelPackage.setTravelPackage_No_Child(travelPackageDTO.getTravelPackage_No_Child());
            travelPackage.setTravelPackage_No_Adult(travelPackageDTO.getTravelPackage_No_Adult());
            travelPackage.setTravelPackage_StartDate(travelPackageDTO.getTravelPackage_StartDate());
            travelPackage.setTravelPackage_EndDate(travelPackageDTO.getTravelPackage_EndDate());
            travelPackage.setTravelPackage_DateDuration(travelPackageDTO.getTravelPackage_DateDuration());
            travelPackage.setPaidBankSlip(file.getBytes());

            return mapper.map(travelPackageRepository.save(travelPackage), TravelPackageDTO.class);
        } else {
            throw new RuntimeException("This ID Already exist!");
        }
    }

    @Override
    public List<TravelPackageDTO> getAllTravelPackages() {
        return mapper.map(travelPackageRepository.findAll(), new TypeToken<List<TravelPackageDTO>>() {
        }.getType());
    }

    @Override
    public TravelPackageDTO updateTravelPackage(TravelPackageDTO travelPackageDTO, MultipartFile file) throws IOException {
        if (travelPackageRepository.existsById(travelPackageDTO.getTravelPackage_Id())){
            TravelPackage travelPackage = new TravelPackage();
            travelPackage.setTravelPackage_Id(travelPackageDTO.getTravelPackage_Id());
            travelPackage.setTravelPackage_Category(travelPackageDTO.getTravelPackage_Category());
            travelPackage.setTravelPackage_Areas(travelPackageDTO.getTravelPackage_Areas());
            travelPackage.setGuide_id(travelPackageDTO.getGuide_id());
            travelPackage.setVehicle_id(travelPackageDTO.getVehicle_id());
            travelPackage.setHotel_id(travelPackageDTO.getHotel_id());
            travelPackage.setCustomer_id(travelPackageDTO.getCustomer_id());
            travelPackage.setTravelPackage_Value(travelPackageDTO.getTravelPackage_Value());
            travelPackage.setTravelPackage_PaidValue(travelPackageDTO.getTravelPackage_PaidValue());
            travelPackage.setTravelPackage_NeedGuide(travelPackageDTO.getTravelPackage_NeedGuide());
            travelPackage.setTravelPackage_WithPet(travelPackageDTO.getTravelPackage_WithPet());
            travelPackage.setTravelPackage_HeadCount(travelPackageDTO.getTravelPackage_HeadCount());
            travelPackage.setTravelPackage_No_Child(travelPackageDTO.getTravelPackage_No_Child());
            travelPackage.setTravelPackage_No_Adult(travelPackageDTO.getTravelPackage_No_Adult());
            travelPackage.setTravelPackage_StartDate(travelPackageDTO.getTravelPackage_StartDate());
            travelPackage.setTravelPackage_EndDate(travelPackageDTO.getTravelPackage_EndDate());
            travelPackage.setTravelPackage_DateDuration(travelPackageDTO.getTravelPackage_DateDuration());
            travelPackage.setPaidBankSlip(file.getBytes());



            return mapper.map(travelPackageRepository.save(travelPackage), TravelPackageDTO.class);
        } else {
            throw new RuntimeException("Wrong ID !");
        }
    }

    @Override
    public void deletePackage(int packageId) {
        if (travelPackageRepository.existsById(packageId)) {
            travelPackageRepository.deleteById(packageId);
        } else {
            throw new RuntimeException("Please check the Package ID.. No Such Package..!");
        }
    }
}
