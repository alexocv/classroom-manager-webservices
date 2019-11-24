package org.classroom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.classroom.domain.Classes;
import org.classroom.domain.Student;
import org.classroom.repository.StudentRepository;
import org.classroom.service.dto.StudentDTO;
import org.classroom.service.exceptions.ResourceNotFoundException;
import org.classroom.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Iterable<StudentDTO> list() {

        Iterable<Student> students = studentRepository.findAll();
        List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
        for (Student student : students) {
            studentsDTO.add(convertToDto(student));
        }
        return studentsDTO;
    }

    @Override
    public StudentDTO read(long id) {
        Student student = studentRepository.findOne(id);
        checkIfStudentIsPresent(student, id);
        return convertToDto(student);
    }

    @Override
    @Transactional
    public StudentDTO create(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        return convertToDto(studentRepository.save(student));
    }

    @Override
    public void delete(long id) {
        Student student = studentRepository.findOne(id);
        checkIfStudentIsPresent(student, id);
        studentRepository.delete(id);
    }

    @Override
    public StudentDTO update(long id, StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        return convertToDto(studentRepository.save(student));
    }

    private StudentDTO convertToDto(Student student) {
        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        return studentDTO;
    }

    private Student convertToEntity(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);

        if (studentDTO.getId() != null) {
            Student oldStudent = studentRepository.findOne(studentDTO.getId());

            checkIfStudentIsPresent(oldStudent, studentDTO.getId());

            if (studentDTO.getFirstName() != null) {
                oldStudent.setFirstName(studentDTO.getFirstName());
            }
            if (studentDTO.getFirstName() != null) {
                oldStudent.setLastName(studentDTO.getLastName());
            }
            return oldStudent;
        }
        return student;
    }

    private void checkIfStudentIsPresent(Student student, Long id) {
        if (Objects.isNull(student)) {
            throw ResourceNotFoundException.getNotFoundExceptionFromID("Student", id);

        }
    }
}
