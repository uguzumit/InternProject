package etiya.SportsClub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "arrival")
@Data
public class Arrival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference(value = "user-arrival")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "courseBundle-arrival")
    private CourseBundle courseBundle;

}
