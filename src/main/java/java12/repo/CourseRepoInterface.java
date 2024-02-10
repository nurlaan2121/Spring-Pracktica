package java12.repo;

public interface CourseRepoInterface {
    String assignStudentToCourse(Long studentId,Long courseId);

    void assignLessonToCourse(Long lessonId, Long courseId);
}
