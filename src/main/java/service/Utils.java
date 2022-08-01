package service;

import org.apache.commons.lang3.ArrayUtils;
import courses.Course;
import courses.NewCourseAssignmentVO;
import courses.RegisteredCourses;
import registrants.RegisteredStudents;
import registrants.Student;

public class Utils {
  private int studentIdCounter = 0;
  private int courseIdCounter = 0;
private static int courseAssignmentIdCounter = 0;

public static int newCourseAssignmentId() {
  courseAssignmentIdCounter++;
  return courseAssignmentIdCounter;
}
  public int newCourseId() {
    courseIdCounter++;
    return courseIdCounter;
  }
public int newStudentId() {
  studentIdCounter++;
  return studentIdCounter;
}



public static void displayCourseInfo(final int courseId) {
  Course course = RegisteredCourses.getRegisteredCourses().stream().filter(c -> c.getCourseId() == (courseId)).findFirst().get();
  System.out.println("*                                                                *");
  System.out.println("              Course ID: " + course.getCourseId());
  System.out.println("            Course Name: " + course.getName());
  System.out.println("     Maximum Class Size: " + course.getMaxClassSize());
  
  System.out.println("  Assigned Students IDs: " + (!course.getStudentIds().isEmpty() ? "none" : course.getStudentIds()));
  System.out.println("*                                                                *");
  }

public static void displayStudentInfo(final int studentId) {
  Student student = RegisteredStudents.getRegisteredStudents().stream().filter(s -> s.getStudentId() == (studentId)).findFirst().get();
  System.out.println("*                                                                *");
  System.out.println("          Student ID: " + student.getStudentId());
  System.out.println("                Name: " + student.getName());
  System.out.println("                 Age: " + student.getAge());
  System.out.println("*                                                                *");
  }

public static void validateCourseAssignment(final NewCourseAssignmentVO newCourseAssignmentVO) throws Exception{
  
}


public static Student getStudent(final int studentId) {
  return RegisteredStudents.getRegisteredStudents().stream().filter(s -> s.getStudentId() == (studentId)).findFirst().get();
}


public static boolean contains(int[] array, int key) {
  return ArrayUtils.contains(array, key);
}
public static Course getCourse(final int courseId) {
  return RegisteredCourses.getRegisteredCourses().stream().filter(c -> c.getCourseId() == (courseId)).findFirst().get();
}

public static void validateAge(final int age) throws Exception{
  if(age<0) {
    throw new Exception();
  }
}

}
