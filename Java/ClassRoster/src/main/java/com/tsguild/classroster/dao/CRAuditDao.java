package com.tsguild.classroster.dao;

/**
 *
 * @author souldj673
 */
public interface CRAuditDao {

    public void writeAuditEntry(String entry) throws
            ClassRosterPersistenceException;
}
