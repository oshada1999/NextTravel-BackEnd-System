package lk.ijse.travelPackage.GuideService.service;

import lk.ijse.travelPackage.GuideService.dto.GuideDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface GuideService {
    GuideDTO saveGuide(GuideDTO guideDTO, List<MultipartFile> file) throws IOException;

    List<GuideDTO> getAllGuides();

    GuideDTO updateGuide(GuideDTO guideDTO, List<MultipartFile> file) throws IOException;

    void deleteGuide(int guideId);

    GuideDTO searchGuide(Integer guideId);

    List<GuideDTO> getAllAvailableGuide();
}
