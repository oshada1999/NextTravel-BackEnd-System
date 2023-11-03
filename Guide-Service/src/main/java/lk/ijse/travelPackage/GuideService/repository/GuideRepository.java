package lk.ijse.travelPackage.GuideService.repository;


import lk.ijse.travelPackage.GuideService.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide,Integer> {
    boolean existsByGuideEmail(String email);

    Guide getByGuideEmail(String email);
    Guide getByGuideId(Integer guideId);
    List<Guide> getAllByGuideStatus(String status);
}
