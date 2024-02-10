package java12.service;

import java12.entities.Course;
import java12.repo.CourseRepoInterface;
import java12.repo.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CourseService implements GenericService<Course,Long>,CourseInterface{
    @Qualifier("courseRepo")
    private  final GenericRepository<Course,Long> courseRep;
    private final CourseRepoInterface courseRepoInterface;

    public CourseService(GenericRepository<Course,Long> courseRep, CourseRepoInterface courseRepoInterface) {
        this.courseRep = courseRep;
        this.courseRepoInterface = courseRepoInterface;
    }

    @Override
    public Course save(Course entity) {
        return courseRep.save(entity);
    }

    @Override
    public Course findById(Long aLong) {
        return courseRep.findById(aLong);
    }

    @Override
    public List<Course> getAll() {
        return courseRep.getAll();
    }

    @Override
    public Course updateById(Long aLong, Course newEntity) {
        return courseRep.updateById(aLong,newEntity);
    }

    @Override
    public void deleteByID(Long aLong) {
        courseRep.deleteByID(aLong);
    }

    @Override
    public String assignStudentToCourse(Long studentId, Long courseId) {
        return courseRepoInterface.assignStudentToCourse(studentId,courseId);
    }

    @Override
    public void assignLessonToCourse(Long lessonId, Long courseId) {
        courseRepoInterface.assignLessonToCourse(lessonId,courseId);
    }
}
