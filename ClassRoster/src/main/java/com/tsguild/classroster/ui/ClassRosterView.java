package com.tsguild.classroster.ui;

import com.tsguild.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class ClassRosterView {

    //Removed Hardcoded Dependency 
    private UserIO io;

    //Loose Coupling
    public ClassRosterView(UserIO io) {
        this.io = io;
    }

    //Menu
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    //Creating new student
    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter Cohort");
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent;
    }

    //Creation Banner
    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }

    //Creation Success
    public void displayCreateSuccessBanner() {
        io.readString(
                "Student successfully created.  Please hit enter to continue");
    }

    //Displays Student List
    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            io.print(currentStudent.getStudentId() + ": " + currentStudent.getFirstName() + " " + currentStudent.getLastName());
        }
        io.readString("Please hit enter to continue.");
    }

    //All Students Banner
    public void displayAllBanner() {
        io.print("=== Display All Students ===");
    }

    //Display Student Banner
    public void displayDisplayStudentBanner() {
        io.print("=== Display Student ===");
    }

    //Input Student ID Prompt
    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    //Display Student
    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    //Removal Banner
    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }

    //Removal Success Banner
    public void displayRemoveSuccessBanner() {
        io.readString("Student successfully removed. Please hit enter to continue.");
    }

    //Exit Banner
    public void displayExitBanner() {
        io.print("Good Bye!");
    }

    //Unknown Command Banner
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command.");
    }
}
