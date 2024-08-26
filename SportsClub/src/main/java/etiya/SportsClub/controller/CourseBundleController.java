package etiya.SportsClub.controller;

import etiya.SportsClub.dto.CourseBundleDTO;
import etiya.SportsClub.service.CourseBundleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseBundleController {

    private final CourseBundleService courseBundleService;

    @PostMapping("/register")
    public ResponseEntity<CourseBundleDTO> createCourseBundle(@RequestBody CourseBundleDTO courseBundle) {
        return ResponseEntity.ok(courseBundleService.createCourseBundle(courseBundle));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseBundleDTO>> getAllCourseBundles() {
        return ResponseEntity.ok(courseBundleService.getAllCourseBundles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseBundleDTO> getCourseBundleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(courseBundleService.getCourseBundleById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseBundleDTO> updateCourseBundle(@PathVariable("id") Long id, @RequestBody CourseBundleDTO courseBundle) {
        return ResponseEntity.ok(courseBundleService.updateCourseBundle(id, courseBundle));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCourseBundle(@PathVariable("id") Long id) {
        return ResponseEntity.ok(courseBundleService.deleteCourseBundle(id));
    }

}
