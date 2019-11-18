package org.classroom.service;

import org.classroom.domain.Student;

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
    Iterable<Student> list();

    /**
     * Creates a new Student object
     *
     * @param student the input class.
     *
     * @return the Student created with the new ID
     */
    Student create(Student student);

    /**
     * Search the Student from the current ID
     *
     * @param id the Student ID
     *
     * @return a the Student corresponding the ID
     */
    Student read(long id);

    /**
     * Updates a Class
     *
     * @param id the ID to update
     * @param student the class being updated
     *
     * @return the updated Student
     */
    Student update(long id, Student student);

    /**
     * Deletes a Student object
     *
     * @param id the student ID
     */
    void delete(long id);
}
