package utils;

import java.util.Scanner;
import courses.Course;
import exception.CourseNotFoundException;
import exception.StudentNotFoundException;
import registrants.Student;
import service.CourseRegistrationService;
import service.StudentRegistrationService;

public class Utils {

    private static int studentIdCounter = 0;
    private static int courseIdCounter = 0;
    private static int courseAssignmentIdCounter = 0;

    public static int newCourseAssignmentId() {
        courseAssignmentIdCounter++;
        return courseAssignmentIdCounter;
    }

    public static int newCourseId() {
        courseIdCounter++;
        return courseIdCounter;
    }

    public static int newStudentId() {
        studentIdCounter++;
        return studentIdCounter;
    }

    public static boolean confirmInput(Scanner scanner) {
        System.out.println("******************************************************************");
        System.out.println("*                                                                *"); 
        System.out.println("*     Are these details correct? (y/n)                           *");
        System.out.println("*                                                                *"); 
        System.out.println("******************************************************************");
        final String confirmation = scanner.nextLine();
        return(confirmation.toUpperCase().equals("Y"));
    }

    public static void displayCourseInfo(final int courseId) throws Exception {
        final Course course = CourseRegistrationService.getRegisteredCourses().stream().filter(c -> c.getCourseId() == (courseId)).findFirst().orElseThrow(() -> new Exception());
        System.out.println("*                                                                *");
        System.out.println("              Course ID: " + course.getCourseId());
        System.out.println("            Course Name: " + course.getName());
        System.out.println("     Maximum Class Size: " + course.getMaxClassSize());
        System.out.println("  Assigned Students IDs: " + ((course.getStudentIds().size() == 0) ? "none" : course.getStudentIds()));
        System.out.println("*                                                                *");
    }

    public static void displayStudentInfo(final int studentId) throws Exception{
        final Student student = StudentRegistrationService.getRegisteredStudents().stream().filter(s -> s.getStudentId() == (studentId)).findFirst().orElseThrow(() -> new Exception());
        System.out.println("*                                                                *");
        System.out.println("          Student ID: " + student.getStudentId());
        System.out.println("                Name: " + student.getName());
        System.out.println("                 Age: " + student.getAge());
        System.out.println("*                                                                *");
  }

    public static Student getStudent(final int studentId) throws Exception {
       try {
         return StudentRegistrationService.getRegisteredStudents().stream().filter(s -> s.getStudentId() == (studentId)).findFirst().orElseThrow(() -> new StudentNotFoundException(studentId));
       } catch (Exception e){
         throw e;
       }
    }

    public static Course getCourse(final int courseId) throws Exception{
        try { 
          return CourseRegistrationService.getRegisteredCourses().stream().filter(c -> c.getCourseId() == (courseId)).findFirst().orElseThrow(() -> new CourseNotFoundException(courseId));
        } catch (Exception e) {
          throw e;
        }
    }
    
}
