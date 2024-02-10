package java12.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "lessons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_gen")
    @SequenceGenerator(name = "id_gen",allocationSize = 1,sequenceName = "lesson_id")
    private Long id;
    private String name;

    private String description;
    @Column(name = "video_link")

    private String videoLink;
    @Column(name = "published_date")

    private LocalDate publishedDate;
    @Column(name = "is_presentation")

    private boolean isPresentation;

    public Lesson(String name, String description, String videoLink, LocalDate publishedDate, boolean isPresentation) {
        this.name = name;
        this.description = description;
        this.videoLink = videoLink;
        this.publishedDate = publishedDate;
        this.isPresentation = isPresentation;
    }
}
