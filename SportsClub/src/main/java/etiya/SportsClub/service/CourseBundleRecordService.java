package etiya.SportsClub.service;

import etiya.SportsClub.dto.CourseBundleRecordDTO;

import java.util.List;

public interface CourseBundleRecordService {

    CourseBundleRecordDTO createCourseBundleRecord(CourseBundleRecordDTO courseBundleRecord);
    List<CourseBundleRecordDTO> getAllCourseBundleRecords();
    CourseBundleRecordDTO getCourseBundleRecordById(Long id);
    CourseBundleRecordDTO updateCourseBundleRecord(Long id, CourseBundleRecordDTO courseBundleRecord);
    Boolean deleteCourseBundleRecord(Long id);

}
