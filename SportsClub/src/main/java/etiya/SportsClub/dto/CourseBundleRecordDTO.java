package etiya.SportsClub.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CourseBundleRecordDTO {

    private Long id;
    private int remainingLesson;
    private Date lessonDate;

}
