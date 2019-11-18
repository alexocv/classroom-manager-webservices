package org.classroom.service;

import javax.transaction.Transactional;

import org.classroom.domain.Classes;
import org.classroom.repository.StudentRepository;
import org.classroom.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassService {

    private ClassRepository postRepository;
    private StudentRepository authorRepository;

    @Autowired
    public ClassroomServiceImpl(ClassRepository postRepository, StudentRepository authorRepository){
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Classes> list() {
        return postRepository.findAll();
    }

    @Override
    public Classes read(long id) {
        return postRepository.findOne(id);
    }

    @Override
    @Transactional
    public Classes create(Classes classes) {

        return postRepository.save(classes);
    }

    @Override
    public void delete(long id) {
        postRepository.delete(id);
    }

    @Override
    public Classes update(long id, Classes update) {
        Classes classes = postRepository.findOne(id);
        if( update.getTitle() != null ) {
            classes.setTitle(update.getTitle());
        }
        return postRepository.save(classes);
    }

}
