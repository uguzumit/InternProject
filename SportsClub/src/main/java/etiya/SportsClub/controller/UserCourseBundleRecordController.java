package etiya.SportsClub.controller;

import etiya.SportsClub.dto.UserCourseBundleRecordDTO;
import etiya.SportsClub.service.UserCourseBundleRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class UserCourseBundleRecordController {

    private final UserCourseBundleRecordService userCourseBundleRecordService;

    public UserCourseBundleRecordController(UserCourseBundleRecordService userCourseBundleRecordService) {
        this.userCourseBundleRecordService = userCourseBundleRecordService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserCourseBundleRecordDTO> createUserCourseBundleRecord(@RequestBody UserCourseBundleRecordDTO userCourseBundleRecordDTO) {
        return ResponseEntity.ok(userCourseBundleRecordService.createUserCourseBundleRecord(userCourseBundleRecordDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserCourseBundleRecordDTO>> getAllUserCourseBundleRecords() {
        return ResponseEntity.ok(userCourseBundleRecordService.getAllUserCourseBundleRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCourseBundleRecordDTO> getUserCourseBundleRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(userCourseBundleRecordService.getUserCourseBundleRecordById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserCourseBundleRecordDTO> updateUserCourseBundleRecord(@PathVariable Long id, @RequestBody UserCourseBundleRecordDTO userCourseBundleRecordDTO) {
        return ResponseEntity.ok(userCourseBundleRecordService.updateUserCourseBundleRecord(id, userCourseBundleRecordDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUserCourseBundleRecord(@PathVariable Long id) {
        userCourseBundleRecordService.deleteUserCourseBundleRecord(id);
        return ResponseEntity.ok().build();
    }

}
