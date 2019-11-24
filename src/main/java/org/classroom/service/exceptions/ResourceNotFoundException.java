package org.classroom.service.exceptions;

/**
 * Not found exception, used to validate resources existing in the application.
 * @author alexc
 *
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String exception) {
        super(exception);
    }

    public static ResourceNotFoundException getNotFoundExceptionFromID(String resource, long id) {
        return new ResourceNotFoundException(resource + " with id : " + id + " not found.");
    }

}
