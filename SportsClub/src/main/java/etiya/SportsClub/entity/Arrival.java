package etiya.SportsClub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "arrival")
@Data
public class Arrival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    // UserCourseBundleRecord MANY TO MANY

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @JsonBackReference(value = "user-arrival")
//    private User user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference(value = "courseBundle-arrival")
//    private CourseBundle courseBundle;

    @OneToMany(mappedBy = "arrival", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "arrival-UserCourseBundleRecord")
    private List<UserCourseBundleRecord> userCourseBundleRecords;

}
