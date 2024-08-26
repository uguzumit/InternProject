package etiya.SportsClub.service;

import etiya.SportsClub.dto.CourseBundleDTO;

import java.util.List;

public interface CourseBundleService {

    CourseBundleDTO createCourseBundle(CourseBundleDTO courseBundle);
    List<CourseBundleDTO> getAllCourseBundles();
    CourseBundleDTO getCourseBundleById(Long id);
    CourseBundleDTO updateCourseBundle(Long id, CourseBundleDTO courseBundle);
    Boolean deleteCourseBundle(Long id);

}
