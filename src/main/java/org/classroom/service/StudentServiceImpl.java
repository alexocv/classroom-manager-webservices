package org.classroom.service;

import javax.transaction.Transactional;

import org.classroom.domain.Classes;
import org.classroom.domain.Student;
import org.classroom.repository.StudentRepository;
import org.classroom.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<Student> list() {
        return studentRepository.findAll();
    }

    @Override
    public Student read(long id) {
        return studentRepository.findOne(id);
    }

    @Override
    @Transactional
    public Student create(Student post) {
        return studentRepository.save(post);
    }

    @Override
    public void delete(long id) {
        studentRepository.delete(id);
    }

    @Override
    public Student update(long id,  Student update) {
        Student student = studentRepository.findOne(id);
        if( update.getFirstName() != null ) {
            student.setFirstName(update.getFirstName());
        }
        if( update.getLastName() != null ) {
            student.setLastName(update.getLastName());
        }
        return studentRepository.save(update);
    }

}
