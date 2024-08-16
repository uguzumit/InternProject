package etiya.SportsClub.service;

import etiya.SportsClub.entity.CourseBundle;

import java.util.List;

public interface CourseBundleService {

    CourseBundle createCourseBundle(CourseBundle courseBundle);
    List<CourseBundle> getAllCourseBundles();
    CourseBundle getCourseBundleById(Long id);
    Boolean deleteCourseBundle(Long id);

}
