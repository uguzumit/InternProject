package etiya.SportsClub.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "course_bundle")
public class CourseBundle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseBundleName;
    private int totalLesson;

    @OneToMany(mappedBy = "courseBundle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "courseBundle-courseBundleRecord")
    private List<CourseBundleRecord> courseBundleRecords;

}
