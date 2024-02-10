package java12.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java12.entities.Course;
import java12.entities.Lesson;
import java12.entities.Student;
import java12.repo.CourseRepoInterface;
import java12.repo.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepo implements GenericRepository<Course, Long>, CourseRepoInterface {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Course save(Course entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    @Transactional

    public Course findById(Long aLong) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, aLong);
        entityManager.getTransaction().commit();

        return course;
    }

    @Override
    @Transactional

    public List<Course> getAll() {
        entityManager.getTransaction().begin();
        List<Course> selectCFromCourseC = entityManager.createQuery("select c from Course c", Course.class).getResultList();
        entityManager.getTransaction().commit();

        return selectCFromCourseC;
    }

    @Override
    public Course updateById(Long aLong, Course newEntity) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, aLong);
        course.setName(newEntity.getName());
        course.setPrice(newEntity.getPrice());
        course.setDateOfStart(newEntity.getDateOfStart());
        entityManager.merge(course);

        entityManager.getTransaction().commit();
        return course;
    }

    @Override
    public void deleteByID(Long aLong) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, aLong);
        entityManager.remove(course);

        entityManager.getTransaction().commit();
        System.out.println("Success");
    }

    @Override
    public String assignStudentToCourse(Long studentId, Long courseId) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, studentId);
        Course course = entityManager.find(Course.class, courseId);
        student.setCourse(course);
        course.getStudent().add(student);
        entityManager.merge(course);
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        return "Success";
    }

    @Override
    public void assignLessonToCourse(Long lessonId, Long courseId) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        Course course = entityManager.find(Course.class, courseId);
        course.getLessons().add(lesson);
        entityManager.merge(course);
        entityManager.getTransaction().commit();
        System.out.println("Success");
    }
}
