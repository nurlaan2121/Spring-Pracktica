package java12.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_gen")
    @SequenceGenerator(name = "id_gen",allocationSize = 1,sequenceName = "course_id")
    private Long id;
    private String name;
    private int price;
    @Column(name = "date_of_start")
    private LocalDate dateOfStart;

    @OneToMany(mappedBy = "course",cascade = {CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.PERSIST})
    private List<Student> student;
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Lesson> lessons;

    public Course(String name, int price, LocalDate dateOfStart, List<Student> student, List<Lesson> lessons) {
        this.name = name;
        this.price = price;
        this.dateOfStart = dateOfStart;
        this.student = student;
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateOfStart=" + dateOfStart +
                ", students=" + student.size() +
                ", lessons=" + lessons.size() +
                '}';
    }
}
