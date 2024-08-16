package etiya.SportsClub.controller;

import etiya.SportsClub.entity.CourseBundle;
import etiya.SportsClub.service.CourseBundleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseBundles")
public class CourseBundleController {

    private final CourseBundleService courseBundleService;

    public CourseBundleController(CourseBundleService courseBundleService) {
        this.courseBundleService = courseBundleService;
    }

    @PostMapping("/create")
    public ResponseEntity<CourseBundle> createCourseBundle(@RequestBody CourseBundle courseBundle) {
        return ResponseEntity.ok(courseBundleService.createCourseBundle(courseBundle));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CourseBundle>> getAllCourseBundles() {
        return ResponseEntity.ok(courseBundleService.getAllCourseBundles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseBundle> getCourseBundleById(@PathVariable Long id) {
        return ResponseEntity.ok(courseBundleService.getCourseBundleById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCourseBundle(@PathVariable Long id) {
        courseBundleService.deleteCourseBundle(id);
        return ResponseEntity.ok().build();
    }

}
