package etiya.SportsClub.service.impl;

import etiya.SportsClub.dto.CourseBundleDTO;
import etiya.SportsClub.entity.CourseBundle;
import etiya.SportsClub.repository.CourseBundleRepository;
import etiya.SportsClub.service.CourseBundleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseBundleServiceImpl implements CourseBundleService {

    private final CourseBundleRepository courseBundleRepository;

    private final ModelMapper modelMapper;

    @Override
    public CourseBundleDTO createCourseBundle(CourseBundleDTO courseBundleDTO) {
        CourseBundle courseBundle = modelMapper.map(courseBundleDTO, CourseBundle.class);
        return modelMapper.map(courseBundleRepository.save(courseBundle), CourseBundleDTO.class);
    }

    @Override
    public List<CourseBundleDTO> getAllCourseBundles() {
        return courseBundleRepository.findAll().stream()
                .map(courseBundle -> modelMapper.map(courseBundle, CourseBundleDTO.class))
                .toList();
    }

    @Override
    public CourseBundleDTO getCourseBundleById(Long id) {
        return courseBundleRepository.findById(id)
                .map(courseBundle -> modelMapper.map(courseBundle, CourseBundleDTO.class))
                .orElse(null);
    }

    @Override
    public CourseBundleDTO updateCourseBundle(Long id, CourseBundleDTO courseBundle) {

        Optional<CourseBundle> resultCourseBundle = courseBundleRepository.findById(id);

        if(resultCourseBundle.isPresent()) {
            resultCourseBundle.get().setCourseBundleName(courseBundle.getCourseBundleName());
            resultCourseBundle.get().setTotalLesson(courseBundle.getTotalLesson());

            return modelMapper.map(courseBundleRepository.save(resultCourseBundle.get()), CourseBundleDTO.class);
        }
        return null;

    }

    @Override
    public Boolean deleteCourseBundle(Long id) {
        courseBundleRepository.deleteById(id);
        return true;
    }

}
