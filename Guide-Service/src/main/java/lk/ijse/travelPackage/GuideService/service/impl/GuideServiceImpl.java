package lk.ijse.travelPackage.GuideService.service.impl;


import lk.ijse.travelPackage.GuideService.dto.GuideDTO;
import lk.ijse.travelPackage.GuideService.entity.Guide;
import lk.ijse.travelPackage.GuideService.repository.GuideRepository;
import lk.ijse.travelPackage.GuideService.service.GuideService;
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
public class GuideServiceImpl implements GuideService {
    @Autowired
    GuideRepository guideRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public GuideDTO saveGuide(GuideDTO guideDTO, List<MultipartFile> files) throws IOException {
        if (!guideRepository.existsById(guideDTO.getGuideId())) {
            if (!guideRepository.existsByGuideEmail(guideDTO.getGuideEmail())) {
                Guide guide = new Guide();
                guide.setGuideId(guideDTO.getGuideId());
                guide.setGuideName(guideDTO.getGuideName());
                guide.setGuideAddress(guideDTO.getGuideAddress());
                guide.setGuideDob(guideDTO.getGuideDob());
                guide.setGuideGender(guideDTO.getGuideGender());
                guide.setGuideContact(guideDTO.getGuideContact());
                guide.setGuideExperience(guideDTO.getGuideExperience());
                guide.setGuideManDay_value(guideDTO.getGuideManDay_value());
                guide.setGuideEmail(guideDTO.getGuideEmail());
                guide.setGuideStatus(guideDTO.getGuideStatus());



                guide.setGuideNICImageFront(files.get(0).getBytes());
                guide.setGuideNICImageRear(files.get(1).getBytes());
                guide.setGuideIDImageFront(files.get(2).getBytes());
                guide.setGuideIDImageRear(files.get(3).getBytes());
                guide.setGuideImage(files.get(4).getBytes());



                return mapper.map(guideRepository.save(guide), GuideDTO.class);
            } else {
                throw new RuntimeException("This Email Already exist!");
            }
        } else {
            throw new RuntimeException("This ID Already exist!");
        }
    }

    @Override
    public List<GuideDTO> getAllGuides() {
        return mapper.map(guideRepository.findAll(), new TypeToken<List<GuideDTO>>() {
        }.getType());
    }

    @Override
    public GuideDTO updateGuide(GuideDTO guideDTO, List<MultipartFile> files) throws IOException {
        Guide guide = new Guide();
        guide.setGuideId(guideDTO.getGuideId());
        guide.setGuideName(guideDTO.getGuideName());
        guide.setGuideAddress(guideDTO.getGuideAddress());
        guide.setGuideDob(guideDTO.getGuideDob());
        guide.setGuideGender(guideDTO.getGuideGender());
        guide.setGuideContact(guideDTO.getGuideContact());
        guide.setGuideExperience(guideDTO.getGuideExperience());
        guide.setGuideManDay_value(guideDTO.getGuideManDay_value());
        guide.setGuideEmail(guideDTO.getGuideEmail());
        guide.setGuideStatus(guideDTO.getGuideStatus());


        guide.setGuideNICImageFront(files.get(0).getBytes());
        guide.setGuideNICImageRear(files.get(1).getBytes());
        guide.setGuideIDImageFront(files.get(2).getBytes());
        guide.setGuideIDImageRear(files.get(3).getBytes());
        guide.setGuideImage(files.get(4).getBytes());

        if (guideRepository.existsById(guideDTO.getGuideId())) {
            if (guideRepository.existsByGuideEmail(guideDTO.getGuideEmail())) {
                if (guideRepository.getByGuideEmail(guideDTO.getGuideEmail()).getGuideId().equals(guideDTO.getGuideId())){
                    return mapper.map(guideRepository.save(guide), GuideDTO.class);
                }else {
                    throw new RuntimeException("This Email Already exist!");
                }
            }else {
                return mapper.map(guideRepository.save(guide), GuideDTO.class);
            }
        } else {
            throw new RuntimeException("Wrong ID !");
        }
    }

    @Override
    public void deleteGuide(int guideId) {
        if (guideRepository.existsById(guideId)) {
            guideRepository.deleteById(guideId);
        } else {
            throw new RuntimeException("Please check the Guide ID.. No Such Guide..!");
        }
    }

    @Override
    public GuideDTO searchGuide(Integer guideId) {
        if (guideRepository.existsById(guideId)) {
            return mapper.map(guideRepository.getByGuideId(guideId), GuideDTO.class);
        } else {
            throw new RuntimeException("Search Failed, No Guide ID Available For " + guideId);
        }
    }

    @Override
    public List<GuideDTO> getAllAvailableGuide() {
        return mapper.map(guideRepository.getAllByGuideStatus("Available"), new TypeToken<List<GuideDTO>>() {
        }.getType());
    }
}
