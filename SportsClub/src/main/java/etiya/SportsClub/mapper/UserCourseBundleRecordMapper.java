package etiya.SportsClub.mapper;

import etiya.SportsClub.dto.UserCourseBundleRecordDTO;
import etiya.SportsClub.entity.UserCourseBundleRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserCourseBundleRecordMapper {
    UserCourseBundleRecordMapper INSTANCE = Mappers.getMapper(UserCourseBundleRecordMapper.class);

    UserCourseBundleRecordDTO toDTO(UserCourseBundleRecord userCourseBundleRecord);
    UserCourseBundleRecord toEntity(UserCourseBundleRecordDTO userCourseBundleRecordDTO);
}
