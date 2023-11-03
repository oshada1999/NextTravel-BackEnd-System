package lk.ijse.travelPackage.GuideService.controller;


import lk.ijse.travelPackage.GuideService.dto.GuideDTO;
import lk.ijse.travelPackage.GuideService.service.GuideService;
import lk.ijse.travelPackage.GuideService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/guide")
@CrossOrigin
public class GuideController {

    @Autowired
    GuideService guideService;

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveGuide(@RequestPart("file") List<MultipartFile> file,
                                  @RequestPart("guide") GuideDTO guideDTO) throws IOException {
        return new ResponseUtil(200, "save", guideService.saveGuide(guideDTO, file));
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllGuide() {
        return new ResponseUtil(200, "AllGuidesGet", guideService.getAllGuides());
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateGuide(@RequestPart("file") List<MultipartFile> file,
                                      @RequestPart("guide") GuideDTO guideDTO) throws IOException {
        return new ResponseUtil(200, "update", guideService.updateGuide(guideDTO, file));
    }

    @DeleteMapping(params = {"guideId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteGuide(@RequestParam int guideId) {
        guideService.deleteGuide(guideId);
        return new ResponseUtil(200, "deleted", null);
    }

    @GetMapping("/search")
    public ResponseUtil searchGuide(@RequestParam(value = "guideId") Integer guideId) {

        return new ResponseUtil(200,"Ok",guideService.searchGuide(guideId));
    }
    @GetMapping("/available")
    public ResponseUtil getAvailableGuide() {
        return new ResponseUtil(200,"Ok",guideService.getAllAvailableGuide());
    }
}
