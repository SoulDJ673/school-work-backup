package com.tsguild.classroster.controller;

import com.tsguild.classroster.dao.*;
import com.tsguild.classroster.dto.*;
import com.tsguild.classroster.ui.*;

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
                    io.print("LIST STUDENTS");
                    break;
                case 2:
                    io.print("CREATE STUDENT");
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

    //Tell 
    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

}
