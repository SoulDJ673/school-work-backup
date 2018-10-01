package com.tsguild.classroster.controller;

import com.tsguild.classroster.dao.ClassRosterPersistenceException;
import com.tsguild.classroster.service.*;
import com.tsguild.classroster.dto.*;
import com.tsguild.classroster.ui.*;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class ClassRosterController {

    //Removed Hard Coded Dependencies in Step 5
    private ClassRosterView view;
//  private ClassRosterDao service;  Replaced with Service Layer
    private ClassRosterServiceLayer service;

    //Loose Coupling
    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        this.service = service;
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
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    /*
     * Original createStudent based on Dao
    
    //Tell ClassRosterDaoImpl to do heavy lifting
    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        service.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }
     */
    //Tell service layer to create student, view to obtain info
    private void createStudent() throws ClassRosterPersistenceException {
        boolean hasErrors = false;

        view.displayCreateStudentBanner();

        do {
            Student newStudent = view.getNewStudentInfo();
            try {
                service.createStudent(newStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateIdException
                    | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    //Tell Dao to get Student List, View to display it
    private void listStudents() throws ClassRosterPersistenceException {
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }

    //Tell View to display Banner, Ask Service Layer for ID, View Displays Info
    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentID = view.getStudentIdChoice();
        Student student = service.getStudent(studentID);
        view.displayStudent(student);
    }

    //Tell View to display Banner, ask Service Layer to remove Student, view Displays Success Banner
    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        service.removeStudent(studentId);
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
