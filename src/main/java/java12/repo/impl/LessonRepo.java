package java12.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java12.entities.Course;
import java12.entities.Lesson;
import java12.repo.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LessonRepo implements GenericRepository<Lesson, Long> {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional

    public Lesson save(Lesson entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    @Transactional

    public Lesson findById(Long aLong) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, aLong);
        entityManager.getTransaction().commit();
        return lesson;
    }

    @Override
    @Transactional

    public List<Lesson> getAll() {
        entityManager.getTransaction().begin();
        List<Lesson> selectCFromCourseC = entityManager.createQuery("select c from Lesson c", Lesson.class).getResultList();

        entityManager.getTransaction().commit();
        return selectCFromCourseC;
    }

    @Override
    @Transactional

    public Lesson updateById(Long aLong, Lesson newEntity) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, aLong);
        lesson.setName(newEntity.getName());
        lesson.setVideoLink(newEntity.getVideoLink());
        lesson.setPublishedDate(newEntity.getPublishedDate());
        lesson.setPresentation(newEntity.isPresentation());
        lesson.setDescription(newEntity.getDescription());
        entityManager.merge(lesson);

        entityManager.getTransaction().commit();
        return lesson;
    }

    @Override
    public void deleteByID(Long aLong) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, aLong);
        entityManager.remove(lesson);
        entityManager.getTransaction().commit();
        System.out.println("Success");
    }
}
