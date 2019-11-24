package org.classroom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.transaction.Transactional;

import org.classroom.repository.StudentRepository;
import org.classroom.service.dto.ClassesDTO;
import org.classroom.service.dto.StudentDTO;
import org.classroom.service.exceptions.ResourceNotFoundException;
import org.classroom.domain.Classes;
import org.classroom.domain.Student;
import org.classroom.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class ClassroomServiceImpl implements ClassService {

    private ClassRepository classRepository;
    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ClassroomServiceImpl(ClassRepository classRepository, StudentRepository studentRepository,
            ModelMapper modelMapper) {
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Iterable<ClassesDTO> list() {
        Iterable<Classes> classes = classRepository.findAll();
        List<ClassesDTO> classesDto = new ArrayList<ClassesDTO>();

        for (Classes cls : classes) {
            classesDto.add(convertToDto(cls));
        }

        return classesDto;
    }

    @Override
    public ClassesDTO read(long id) {
        Classes classes = classRepository.findOne(id);
        checkIfClassIsPresent(classes, id);

        return convertToDto(classes);
    }

    @Override
    @Transactional
    public ClassesDTO create(ClassesDTO classesDTO) {
        Classes classes = convertToEntity(classesDTO);
        return convertToDto(classRepository.save(classes));
    }

    @Override
    public void delete(long id) {
        Classes classes = classRepository.findOne(id);
        checkIfClassIsPresent(classes, id);

        classRepository.delete(id);
    }

    @Override
    public ClassesDTO update(long id, ClassesDTO updateDTO) {
        Classes classes = convertToEntity(updateDTO);

        return convertToDto(classRepository.save(classes));
    }

    @Override
    public Set<StudentDTO> addStudent(long id, StudentDTO studentDTO) {
        Student student = studentRepository.findOne(studentDTO.getId());
        Classes classes = classRepository.findOne(id);

        checkIfClassIsPresent(classes, id);
        classes.getStudents().add(student);
        ClassesDTO classesDTO = convertToDto(classRepository.save(classes));
        return classesDTO.getStudents();
    }

    private ClassesDTO convertToDto(Classes classes) {
        ClassesDTO classesDTO = modelMapper.map(classes, ClassesDTO.class);
        return classesDTO;
    }

    private Classes convertToEntity(ClassesDTO classesDTO) {
        Classes classes = modelMapper.map(classesDTO, Classes.class);

        if (classesDTO.getId() != null) {
            Classes oldClasses = classRepository.findOne(classesDTO.getId());

            checkIfClassIsPresent(oldClasses, classesDTO.getId());

            if (classesDTO.getTitle() != null) {
                oldClasses.setTitle(classesDTO.getTitle());
            }

            if (classesDTO.getDescription() != null) {
                oldClasses.setDescription(classesDTO.getDescription());
            }
            return oldClasses;
        }
        return classes;
    }

    private void checkIfClassIsPresent(Classes classes, Long id) {
        if (Objects.isNull(classes)) {
            throw ResourceNotFoundException.getNotFoundExceptionFromID("Classes", id);

        }
    }
}
