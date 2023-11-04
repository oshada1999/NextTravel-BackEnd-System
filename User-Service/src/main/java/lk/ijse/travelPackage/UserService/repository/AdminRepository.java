package lk.ijse.travelPackage.UserService.repository;

import lk.ijse.travelPackage.UserService.entity.Admin;
import lk.ijse.travelPackage.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String> {
    boolean existsByLoginEmail(String email);
    Admin getByLoginEmail(String email);
}
