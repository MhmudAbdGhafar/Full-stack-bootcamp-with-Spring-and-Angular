package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructors")
@NoArgsConstructor
@Getter
@Setter
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "instructor_name")
    private String instructorName;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList;

    public Instructor(String instructorName) {
        this.instructorName = instructorName;
    }
}