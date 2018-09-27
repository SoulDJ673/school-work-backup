package com.tsguild.classroster.service;

import com.tsguild.classroster.dao.*;
import com.tsguild.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    private ClassRosterDao dao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao) {
        this.dao = dao;
    }

    @Override
    public void createStudent(Student student) throws
            ClassRosterDuplicateIdException, ClassRosterDataValidationException,
            ClassRosterPersistenceException {
        /**
         * Check if there's already a student with the given ID Throw a
         * ClassRosterDuplicateIdException if true
         */

        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException("ERROR: Could not create "
                    + "student. Student ID " + student.getStudentId()
                    + " already exists");
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getStudent(String studentId) throws
            ClassRosterPersistenceException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student removeStudent(String studentId) throws
            ClassRosterPersistenceException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {

        if (student.getFirstName() == null //Check if value is null
                || student.getFirstName().trim().length() == 0 //Check if value is empty or whitespace
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {

            throw new ClassRosterDataValidationException("ERROR: All fields "
                    + "[FirstName, LastName, Cohort] are required.");
        }
    }
}
