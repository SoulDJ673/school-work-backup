package com.tsguild.classroster.dao;

/**
 *
 * @author souldj673
 */
public interface ClassRosterAuditDao {

    public void writeAuditEntry(String entry) throws
            ClassRosterPersistenceException;
}
