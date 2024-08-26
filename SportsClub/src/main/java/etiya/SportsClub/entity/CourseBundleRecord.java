package etiya.SportsClub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "course_bundle_record")
public class CourseBundleRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int remainingLesson;
    private Date lessonDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference(value = "user-courseBundleRecord")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_bundle_id", referencedColumnName = "id")
    @JsonBackReference(value = "courseBundle-courseBundleRecord")
    private CourseBundle courseBundle;

}
