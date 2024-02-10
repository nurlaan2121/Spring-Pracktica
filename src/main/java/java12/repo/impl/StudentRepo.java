package java12.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java12.entities.Course;
import java12.entities.Lesson;
import java12.entities.Student;
import java12.repo.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class StudentRepo implements GenericRepository<Student, Long> {
    @Autowired

    private EntityManager entityManager;

    @Override
    @Transactional

    public Student save(Student entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    @Transactional

    public Student findById(Long aLong) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, aLong);
        entityManager.getTransaction().commit();
        return student;
    }

    @Override
    @Transactional

    public List<Student> getAll() {
        entityManager.getTransaction().begin();
        List<Student> selectCFromCourseC = entityManager.createQuery("select c from Student c", Student.class).getResultList();
        entityManager.getTransaction().commit();

        return selectCFromCourseC;
    }

    @Override
    @Transactional

    public Student updateById(Long aLong, Student newEntity) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, aLong);
        student.setName(newEntity.getName());
        student.setCourse(newEntity.getCourse());
        student.setEmail(newEntity.getEmail());
        student.setYearOfBirth(newEntity.getYearOfBirth());
        entityManager.merge(student);

        entityManager.getTransaction().commit();
        return student;
    }

    @Override
    public void deleteByID(Long aLong) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, aLong);
        entityManager.remove(student);
        entityManager.getTransaction().commit();

        System.out.println("Success");
    }
}
