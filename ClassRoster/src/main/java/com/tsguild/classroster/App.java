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
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao);
        ClassRosterController controller = new ClassRosterController(myService, myView);

        //Wake Up Controller
        controller.run();
    }
}
