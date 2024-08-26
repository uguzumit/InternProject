package etiya.SportsClub.service.impl;

import etiya.SportsClub.dto.CourseBundleRecordDTO;
import etiya.SportsClub.entity.CourseBundleRecord;
import etiya.SportsClub.repository.CourseBundleRecordRepository;
import etiya.SportsClub.service.CourseBundleRecordService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseBundleRecordServiceImpl implements CourseBundleRecordService {

    private final CourseBundleRecordRepository courseBundleRecordRepository;

    private final ModelMapper modelMapper;

    @Override
    public CourseBundleRecordDTO createCourseBundleRecord(CourseBundleRecordDTO courseBundleRecordDTO) {
        CourseBundleRecord courseBundleRecord = modelMapper.map(courseBundleRecordDTO, CourseBundleRecord.class);
        return modelMapper.map(courseBundleRecordRepository.save(courseBundleRecord), CourseBundleRecordDTO.class);
    }

    @Override
    public List<CourseBundleRecordDTO> getAllCourseBundleRecords() {
        return courseBundleRecordRepository.findAll().stream()
                .map(courseBundleRecord -> modelMapper.map(courseBundleRecord, CourseBundleRecordDTO.class))
                .toList();
    }

    @Override
    public CourseBundleRecordDTO getCourseBundleRecordById(Long id) {
        return courseBundleRecordRepository.findById(id)
                .map(courseBundleRecord -> modelMapper.map(courseBundleRecord, CourseBundleRecordDTO.class))
                .orElse(null);
    }

    @Override
    public CourseBundleRecordDTO updateCourseBundleRecord(Long id, CourseBundleRecordDTO courseBundleRecord) {

        Optional<CourseBundleRecord> resultCourseBundleRecord = courseBundleRecordRepository.findById(id);

        if(resultCourseBundleRecord.isPresent()) {
            resultCourseBundleRecord.get().setRemainingLesson(courseBundleRecord.getRemainingLesson());
            resultCourseBundleRecord.get().setLessonDate(courseBundleRecord.getLessonDate());

            return modelMapper.map(courseBundleRecordRepository.save(resultCourseBundleRecord.get()), CourseBundleRecordDTO.class);
        }
        return null;

    }

    @Override
    public Boolean deleteCourseBundleRecord(Long id) {
        courseBundleRecordRepository.deleteById(id);
        return true;
    }

}
