package java12.service;

import java12.entities.Lesson;
import java12.repo.GenericRepository;
import java12.repo.impl.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public class LessonService implements GenericService<Lesson,Long>{
    @Qualifier("lessonRepo")
    private final GenericRepository<Lesson,Long> genericRepository;

    public LessonService(GenericRepository<Lesson, Long> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    public Lesson save(Lesson entity) {
        return genericRepository.save(entity);
    }

    @Override
    public Lesson findById(Long aLong) {
        return genericRepository.findById(aLong);
    }

    @Override
    public List<Lesson> getAll() {
        return genericRepository.getAll();
    }

    @Override
    public Lesson updateById(Long aLong, Lesson newEntity) {
        return genericRepository.updateById(aLong,newEntity);
    }

    @Override
    public void deleteByID(Long aLong) {
        genericRepository.deleteByID(aLong);
    }
}
