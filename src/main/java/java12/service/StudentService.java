package java12.service;

import java12.entities.Student;
import java12.repo.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component

public class StudentService implements GenericService<Student,Long> {
    @Qualifier("studentRepo")
    private final GenericRepository<Student,Long> genericRepository;

    public StudentService(GenericRepository<Student, Long> genericRepository) {
        this.genericRepository = genericRepository;
    }


    @Override
    public Student save(Student entity) {
        return genericRepository.save(entity);
    }

    @Override
    public Student findById(Long aLong) {
        return genericRepository.findById(aLong);
    }

    @Override
    public List<Student> getAll() {
        return genericRepository.getAll();
    }

    @Override
    public Student updateById(Long aLong, Student newEntity) {
        return genericRepository.updateById(aLong,newEntity);
    }

    @Override
    public void deleteByID(Long aLong) {
        genericRepository.deleteByID(aLong);
    }
}
