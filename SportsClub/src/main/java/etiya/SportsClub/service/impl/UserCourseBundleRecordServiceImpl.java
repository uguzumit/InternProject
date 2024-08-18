package etiya.SportsClub.service.impl;

import etiya.SportsClub.dto.UserCourseBundleRecordDTO;
import etiya.SportsClub.entity.UserCourseBundleRecord;
import etiya.SportsClub.mapper.UserCourseBundleRecordMapper;
import etiya.SportsClub.repository.UserCourseBundleRecordRepository;
import etiya.SportsClub.service.UserCourseBundleRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCourseBundleRecordServiceImpl implements UserCourseBundleRecordService {

    private final UserCourseBundleRecordRepository userCourseBundleRecordRepository;

    public UserCourseBundleRecordServiceImpl(UserCourseBundleRecordRepository userCourseBundleRecordRepository) {
        this.userCourseBundleRecordRepository = userCourseBundleRecordRepository;
    }

    @Override
    public UserCourseBundleRecordDTO createUserCourseBundleRecord(UserCourseBundleRecordDTO userCourseBundleRecordDTO){
        UserCourseBundleRecord userCourseBundleRecord = UserCourseBundleRecordMapper.INSTANCE.toEntity(userCourseBundleRecordDTO);
        UserCourseBundleRecord createdUserCourseBundleRecord = userCourseBundleRecordRepository.save(userCourseBundleRecord);
        return UserCourseBundleRecordMapper.INSTANCE.toDTO(createdUserCourseBundleRecord);
    }

    @Override
    public List<UserCourseBundleRecordDTO> getAllUserCourseBundleRecords(){
        return userCourseBundleRecordRepository.findAll().stream()
                .map(UserCourseBundleRecordMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserCourseBundleRecordDTO getUserCourseBundleRecordById(Long id){
        UserCourseBundleRecord userCourseBundleRecord = userCourseBundleRecordRepository.findById(id).orElseThrow(() -> new RuntimeException("UserCourseBundleRecord not found"));
        return UserCourseBundleRecordMapper.INSTANCE.toDTO(userCourseBundleRecord);
    }

    @Override
    public UserCourseBundleRecordDTO updateUserCourseBundleRecord(Long id, UserCourseBundleRecordDTO userCourseBundleRecordDTO){
        UserCourseBundleRecord userCourseBundleRecord = UserCourseBundleRecordMapper.INSTANCE.toEntity(userCourseBundleRecordDTO);
        userCourseBundleRecord.setId(id);
        UserCourseBundleRecord updatedUserCourseBundleRecord = userCourseBundleRecordRepository.save(userCourseBundleRecord);
        return UserCourseBundleRecordMapper.INSTANCE.toDTO(updatedUserCourseBundleRecord);
    }

    @Override
    public Boolean deleteUserCourseBundleRecord(Long id){
        userCourseBundleRecordRepository.deleteById(id);
        return true;
    }

}
