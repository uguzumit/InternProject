package etiya.SportsClub.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    /*
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
    */

}
