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

    private UserIO io = new UserIOConsoleImpl();

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
                    io.print("VIEW STUDENT");
                    break;
                case 4:
                    io.print("REMOVE STUDENT");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
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

}
