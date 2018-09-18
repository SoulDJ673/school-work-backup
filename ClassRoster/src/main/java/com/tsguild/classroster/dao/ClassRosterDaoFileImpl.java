package com.tsguild.classroster.dao;

import com.tsguild.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {

    //File Persistence
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    @Override
    public Student addStudent(String studentId, Student student) {
        Student newStudent = students.put(studentId, student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId) {
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) {
        Student removedStudent = students.remove(studentId);
        return removedStudent;
    }

    //Map for storing/sorting student data
    private Map<String, Student> students = new HashMap<>();

    //Load from file
    private void loadRoster() throws ClassRosterDaoException {
        Scanner scanner;

        try {
            //Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterDaoException("-_- Could not load roster data into memory. :(", e);
        }
        //Read most recent line from file and hold it in currentLine
        String currentLine;
        //currentTokens holds each of the parts of the currentLine after it has
        //been split on our DELIMITER
        //NOTE FOR APPRENTICES: In our case we use :: as our delimiter.  If
        //currentLine looks like this:
        //1234::Joe::Smith::Java-September2013
        //then currentTokens will be a string array that looks like this:
        //
        // ___________________________________
        // |    |   |     |                  |
        // |1234|Joe|Smith|Java-September2013|
        // |    |   |     |                  |
        // -----------------------------------
        //  [0]  [1]  [2]         [3]
        String[] currentTokens;
        //Go through ROSTER_FILE line by line, decoding each line into a 
        //Student object.
        //Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            //get the next line
            currentLine = scanner.nextLine();
            //break up line
            currentTokens = currentLine.split(DELIMITER);
            //Create a new Student object and put it into the map of students
            //NOTE FOR APPRENTICES: We are going to use the student id
            //which is currentTokens[0] as the map key for our student object.
            //We also have to pass the student id into the Student constructor
            Student currentStudent = new Student(currentTokens[0]);
            //Set remaining values manually
            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);
            
            //Put currentStudent into map
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        //Close scanner
        scanner.close();
    }
}
