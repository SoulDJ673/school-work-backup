package com.tsguild.classroster.dao;

/**
 *
 * @author souldj673
 */
public class ClassRosterPersistenceException extends Exception {

    public ClassRosterPersistenceException(String message) {
        super(message);
    }
    
    public ClassRosterPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
