package com.tsguild.classroster;

import com.tsguild.classroster.controller.*;

/**
 *
 * @author souldj673
 */
public class App {

    public static void main(String[] args) {
        /*
        Use Spring for dependency injection, let's remove these
        
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        CRAuditDao myAuditDao
                = new CRAuditDaoFileImpl();
        ClassRosterServiceLayer myService
                = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        ClassRosterController controller
                = new ClassRosterController(myService, myView);
         */
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassRosterController controller
                = ctx.getBean("controller", ClassRosterController.class);
        controller.run();
    }
}
