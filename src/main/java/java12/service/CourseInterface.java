package java12.service;

public interface CourseInterface {
    String assignStudentToCourse(Long studentId,Long courseId);

    void assignLessonToCourse(Long lessonId, Long courseId);
}
