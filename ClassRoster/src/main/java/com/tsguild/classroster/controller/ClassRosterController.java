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

    ClassRosterView view = new ClassRosterView();
    ClassRosterDao dao = new ClassRosterDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
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
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    //Tell ClassRosterDaoImpl to do heavy lifting
    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    //Tell Dao to get Student List, View to display it
    private void listStudents() {
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    //Tell View to display Banner, Ask DAO for ID, View Displays Info
    private void viewStudent() {
        view.displayDisplayStudentBanner();
        String studentID = view.getStudentIdChoice();
        Student student = dao.getStudent(studentID);
        view.displayStudent(student);
    }

    //Tell View to display Banner, ask DAO to remove Student, view Displays Success Banner
    private void removeStudent() {
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
