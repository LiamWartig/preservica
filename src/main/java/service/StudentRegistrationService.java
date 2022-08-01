package service;

import java.util.Collection;
import java.util.HashSet;

import registrants.Student;
import utils.Utils;

public class StudentRegistrationService {

  private static Collection<Student> registeredStudents = new HashSet<Student>();

  public int registerStudent(final Student student) {
    final int studentId = Utils.newStudentId();
    student.setStudentId(studentId);  
    registeredStudents.add(student);
    return studentId;
    }
  
  public static Collection<Student> getRegisteredStudents(){
    return registeredStudents;
  }
  }

