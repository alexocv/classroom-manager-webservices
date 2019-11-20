package org.classroom.service;

import java.util.Set;

import org.classroom.service.dto.ClassesDTO;
import org.classroom.service.dto.StudentDTO;

/**
 * Service interface to handle CRUD operations for the Class domain
 *
 * @author alex
 *
 */
public interface ClassService {

    /**
     *
     * @return A list of all the classes in the app
     */
    Iterable<ClassesDTO> list();

    /**
     * Creates a new Class object
     *
     * @param classes the input class.
     *
     * @return the class created with the new ID
     */
    ClassesDTO create(ClassesDTO classes);

    /**
     * Search the class from the current ID
     *
     * @param id the class ID
     *
     * @return a the class corresponding the ID
     */
    ClassesDTO read(long id);

    /**
     * Updates a Class
     *
     * @param id the ID to update
     * @param classes the class being updated
     * @return
     */
    ClassesDTO update(long id, ClassesDTO classes);

    /**
     * Deletes a class object
     *
     * @param id the class ID
     */
    void delete(long id);

    Set<StudentDTO> addStudent(long id, StudentDTO student);
}
