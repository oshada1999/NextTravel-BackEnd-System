package lk.ijse.travelPackage.UserService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lk.ijse.travelPackage.UserService.service.AdminService;
import lk.ijse.travelPackage.UserService.service.UserService;
import lk.ijse.travelPackage.UserService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(path = "{email}/{password}")
    public ResponseUtil loginAdminFind(@PathVariable("email")String email, @PathVariable("password")String password) throws JsonProcessingException {

        adminService.loginAdminFind(email,password);

        return new ResponseUtil(200,"isPresent",null);
    }
}
