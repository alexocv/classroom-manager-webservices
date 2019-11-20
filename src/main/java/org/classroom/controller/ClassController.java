package org.classroom.controller;

import java.util.Set;

import org.classroom.service.ClassService;
import org.classroom.service.StudentService;
import org.classroom.service.dto.ClassesDTO;
import org.classroom.service.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class resource controller
 *
 * @author alexc
 *
 */
@RestController
@RequestMapping("/class")
public class ClassController {

    /**
     * Class service
     */
    private ClassService classService;
    /**
     * Student service
     */
    private StudentService studentService;


    @Autowired
    public ClassController(ClassService classService, StudentService studentService){
        this.classService = classService;
        this.studentService = studentService;
    }

    /**
     * Get all the classes
     * @return a list of all the classes in DB
     */
    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Iterable<ClassesDTO> list(){
        return classService.list();
    }

    /**
     * Creates a new class from JSON request body
     *
     * @param classes the request body
     *
     * @return the created Class
     */
    @RequestMapping( value = "/", method = RequestMethod.POST )
    public ClassesDTO create(@RequestBody ClassesDTO classes){
        return classService.create(classes);
    }

    /**
     * Gets and specific class by id
     * @param id the id class
     *
     * @return the class found.
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public ClassesDTO read(@PathVariable(value="id") long id){
        return classService.read(id);
    }

    /**
     * Get all the students from the class id
     * @param id the class id
     * @return Students in the class
     */
    @RequestMapping( value = "/{id}/student", method = RequestMethod.GET )
    public Set<StudentDTO> readStudents(@PathVariable(value="id") long id){
        return  classService.read(id).getStudents();
    }

    /**
     * Adds a new student to the class
     * @param id the class id
     * @param student the student request body
     * @return the students in the class
     */
    @RequestMapping( value = "/{id}/student", method = RequestMethod.POST )
    public Set<StudentDTO> addStudents
        (@PathVariable(value="id") long id, @RequestBody StudentDTO student) {

        return classService.addStudent(id, student);

    }

    /**
     * Updates the class
     *
     * @param id class id
     * @param classes the updated fields
     * @return the updated class
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
    public ClassesDTO update(@PathVariable(value="id") long id, @RequestBody ClassesDTO classes){
        return classService.update(id, classes);
    }

    /**
     * Deletes a class id
     * @param id the id to delete
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable(value="id") int id){
        classService.delete(id);
    }

}
