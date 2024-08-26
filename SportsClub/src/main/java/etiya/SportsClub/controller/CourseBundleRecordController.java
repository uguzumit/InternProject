package etiya.SportsClub.controller;

import etiya.SportsClub.dto.CourseBundleRecordDTO;
import etiya.SportsClub.service.CourseBundleRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/records")
@RequiredArgsConstructor
public class CourseBundleRecordController {

    private final CourseBundleRecordService courseBundleRecordService;

    @PostMapping("/register")
    public ResponseEntity<CourseBundleRecordDTO> createCourseBundleRecord(@RequestBody CourseBundleRecordDTO courseBundleRecord) {
        return ResponseEntity.ok(courseBundleRecordService.createCourseBundleRecord(courseBundleRecord));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseBundleRecordDTO>> getAllCourseBundleRecords() {
        return ResponseEntity.ok(courseBundleRecordService.getAllCourseBundleRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseBundleRecordDTO> getCourseBundleRecordById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(courseBundleRecordService.getCourseBundleRecordById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseBundleRecordDTO> updateCourseBundleRecord(@PathVariable("id") Long id, @RequestBody CourseBundleRecordDTO courseBundleRecord) {
        return ResponseEntity.ok(courseBundleRecordService.updateCourseBundleRecord(id, courseBundleRecord));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCourseBundleRecord(@PathVariable("id") Long id) {
        return ResponseEntity.ok(courseBundleRecordService.deleteCourseBundleRecord(id));
    }

}
