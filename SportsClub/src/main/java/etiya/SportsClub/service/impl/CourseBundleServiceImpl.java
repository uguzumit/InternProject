package etiya.SportsClub.service.impl;

import etiya.SportsClub.entity.CourseBundle;
import etiya.SportsClub.repository.CourseBundleRepository;
import etiya.SportsClub.service.CourseBundleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseBundleServiceImpl implements CourseBundleService {

    private final CourseBundleRepository courseBundleRepository;

    public CourseBundleServiceImpl(CourseBundleRepository courseBundleRepository) {
        this.courseBundleRepository = courseBundleRepository;
    }

    @Override
    public CourseBundle createCourseBundle(CourseBundle courseBundle) {
        return courseBundleRepository.save(courseBundle);
    }

    @Override
    public List<CourseBundle> getAllCourseBundles() {
        return courseBundleRepository.findAll();
    }

    @Override
    public CourseBundle getCourseBundleById(Long id) {
        return courseBundleRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteCourseBundle(Long id) {
        CourseBundle existingCourseBundle = courseBundleRepository.findById(id).orElse(null);
        if (existingCourseBundle == null) {
            return false;
        }
        courseBundleRepository.delete(existingCourseBundle);
        return true;
    }

}
