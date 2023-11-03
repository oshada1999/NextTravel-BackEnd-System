package lk.ijse.travelPackage.PackageService.repository;


import lk.ijse.travelPackage.PackageService.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPackageRepository extends JpaRepository<TravelPackage,Integer> {
}
