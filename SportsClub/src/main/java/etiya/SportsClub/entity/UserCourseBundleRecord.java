package etiya.SportsClub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserCourseBundleRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int remainingCourses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference(value = "user-UserCourseBundleRecord")
    private User user;  // MANY TO ONE

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_bundle_id", referencedColumnName = "id")
    @JsonBackReference(value = "courseBundle-UserCourseBundleRecord")
    private CourseBundle courseBundle; // MANY TO ONE

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_id", referencedColumnName = "id")
    @JsonBackReference(value = "arrival-UserCourseBundleRecord")
    private Arrival arrival; // MANY TO ONE

}

// Service de fonksiyon belirtilcek
// serviceImpl de fonksiyonun içi doldurulacak