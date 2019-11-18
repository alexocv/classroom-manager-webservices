package org.classroom.service;

import org.classroom.domain.Classes;

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
    Iterable<Classes> list();

    /**
     * Creates a new Class object
     *
     * @param classes the input class.
     *
     * @return the class created with the new ID
     */
    Classes create(Classes classes);

    /**
     * Search the class from the current ID
     *
     * @param id the class ID
     *
     * @return a the class corresponding the ID
     */
    Classes read(long id);

    /**
     * Updates a Class
     *
     * @param id the ID to update
     * @param classes the class being updated
     * @return
     */
    Classes update(long id, Classes classes);

    /**
     * Deletes a class object
     *
     * @param id the class ID
     */
    void delete(long id);
}
