package java12.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
    @SequenceGenerator(name = "id_gen", allocationSize = 1, sequenceName = "student_id")
    private Long id;
    private String name;
    private String email;
    @Column(name = "year_of_birth")
    private int yearOfBirth;
    @ManyToOne
    private Course course;


    public Student(String name, String email, int yearOfBirth) {
        this.name = name;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
    }
}
