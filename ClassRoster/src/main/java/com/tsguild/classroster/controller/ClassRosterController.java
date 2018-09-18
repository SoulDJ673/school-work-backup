package com.tsguild.classroster.controller;

import com.tsguild.classroster.dao.*;
import com.tsguild.classroster.dto.*;
import com.tsguild.classroster.ui.*;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class ClassRosterController {

    //Removed Hard Coded Dependencies in Step 5
    ClassRosterView view;
    ClassRosterDao dao;

    //Loose Coupling
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                
                menuSelection = getMenuSelection();
                
                switch (menuSelection) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
                
            }
            exitMessage();
        } catch (ClassRosterDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    //Tell ClassRosterDaoImpl to do heavy lifting
    private void createStudent() throws ClassRosterDaoException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    //Tell Dao to get Student List, View to display it
    private void listStudents() throws ClassRosterDaoException {
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    //Tell View to display Banner, Ask DAO for ID, View Displays Info
    private void viewStudent() throws ClassRosterDaoException {
        view.displayDisplayStudentBanner();
        String studentID = view.getStudentIdChoice();
        Student student = dao.getStudent(studentID);
        view.displayStudent(student);
    }

    //Tell View to display Banner, ask DAO to remove Student, view Displays Success Banner
    private void removeStudent() throws ClassRosterDaoException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        dao.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }

    //Tell View to display Unknown Banner
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    //Tell View to display Exit Banner
    private void exitMessage() {
        view.displayExitBanner();
    }
}
