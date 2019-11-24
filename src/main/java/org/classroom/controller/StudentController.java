package org.classroom.controller;


import java.util.Set;

import org.classroom.domain.Classes;
import org.classroom.repository.StudentRepository;
import org.classroom.service.ClassService;
import org.classroom.service.StudentService;
import org.classroom.service.dto.ClassesDTO;
import org.classroom.service.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * Student controller class
 * @author alexc
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Gets all students from DB
     * @return all the students
     */
    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Iterable<StudentDTO> list() {
        return studentService.list();
    }

    /**
     * creates a new student
     * @param student student body
     * @return the new student
     */
    @RequestMapping( value = "/", method = RequestMethod.POST )
    public StudentDTO create(@RequestBody StudentDTO studentDTO) {

        return studentService.create(studentDTO);
    }

    /**
     * Get the specific student id
     * @param id the student id
     * @return the student found in DB
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public StudentDTO read(@PathVariable(value="id") long id) {
        return studentService.read(id);
    }

    /**
     * Deletes the student by id
     * @param id
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable(value="id") int id){
        studentService.delete(id);
    }


}
