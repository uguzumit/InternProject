package etiya.SportsClub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "course_bundle")
@Data
public class CourseBundle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseBundleName;

    @Column(columnDefinition = "int default 10")
    private int totalCourses;

//    private int remainingCourses;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @JsonBackReference(value = "user-courseBundle")
//    private User user;

//    @OneToMany(mappedBy = "courseBundle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonManagedReference(value = "courseBundle-arrival")
//    private List<Arrival> arrivals;

    @OneToMany(mappedBy = "courseBundle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "courseBundle-UserCourseBundleRecord")
    private List<UserCourseBundleRecord> userCourseBundleRecords;

}
