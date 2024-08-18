package etiya.SportsClub.service;

import etiya.SportsClub.dto.UserCourseBundleRecordDTO;

import java.util.List;

public interface UserCourseBundleRecordService {

    UserCourseBundleRecordDTO createUserCourseBundleRecord(UserCourseBundleRecordDTO userCourseBundleRecordDTO);
    List<UserCourseBundleRecordDTO> getAllUserCourseBundleRecords();
    UserCourseBundleRecordDTO getUserCourseBundleRecordById(Long id);
    UserCourseBundleRecordDTO updateUserCourseBundleRecord(Long id, UserCourseBundleRecordDTO userCourseBundleRecordDTO);
    Boolean deleteUserCourseBundleRecord(Long id);

}
