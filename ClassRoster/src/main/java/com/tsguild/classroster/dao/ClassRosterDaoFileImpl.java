package com.tsguild.classroster.dao;

import com.tsguild.classroster.dto.Student;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souldj673
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {

    @Override
    public Student addStudent(String studentId, Student student) {
        Student newStudent = students.put(studentId, student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getStudent(String studentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student removeStudent(String studentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Map for storing/sorting student data
    private Map<String, Student> students = new HashMap<>();
}
