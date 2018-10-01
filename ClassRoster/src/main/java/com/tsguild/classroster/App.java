package com.tsguild.classroster;

import com.tsguild.classroster.controller.*;
import com.tsguild.classroster.dao.*;
import com.tsguild.classroster.service.*;
import com.tsguild.classroster.ui.*;

/**
 *
 * @author souldj673
 */
public class App {

    public static void main(String[] args) {
        //Loose Coupling
        UserIO myIo = new UserIOConsoleImpl(); //UserIO instantiation
        ClassRosterView myView = new ClassRosterView(myIo); //UI instantiation
        ClassRosterDao myDao = new ClassRosterDaoFileImpl(); //Dao instantiation
        CRAuditDao myAuditDao = new CRAuditDaoFileImpl(); //AuditDao instantiation
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao); //Service Layer instantiation
        ClassRosterController controller = new ClassRosterController(myService, myView); //Controller instantiation

        //Wake Up Controller
        controller.run();
    }
}
