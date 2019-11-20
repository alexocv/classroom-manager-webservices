package org.classroom.service;

import org.classroom.service.dto.StudentDTO;

/**
 * Service interface to handle CRUD operations for the Student domain
 *
 * @author alex
 *
 */
public interface StudentService {

    /**
     *
     * @return A list of all the Student in the App
     */
    Iterable<StudentDTO> list();

    /**
     * Creates a new Student object
     *
     * @param student the input class.
     *
     * @return the Student created with the new ID
     */
    StudentDTO create(StudentDTO student);

    /**
     * Search the Student from the current ID
     *
     * @param id the Student ID
     *
     * @return a the Student corresponding the ID
     */
    StudentDTO read(long id);

    /**
     * Updates a Class
     *
     * @param id the ID to update
     * @param student the class being updated
     *
     * @return the updated Student
     */
    StudentDTO update(long id, StudentDTO student);

    /**
     * Deletes a Student object
     *
     * @param id the student ID
     */
    void delete(long id);
}
