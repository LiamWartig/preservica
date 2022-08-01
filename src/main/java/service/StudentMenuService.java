package service;

import java.util.Scanner;

import courses.Course;
import courses.NewCourseAssignmentVO;
import registrants.NewStudentVO;
import registrants.Student;
import utils.Utils;

public class StudentMenuService {
  private final Utils utils = new Utils();
  private final StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
  private final CourseAssignmentService courseAssignmentService = new CourseAssignmentService();
  
  protected void newStudent(Scanner numScanner, Scanner strScanner) {
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     Registering New Student                                    *");
    System.out.println("*                                                                *");
    System.out.println("******************************************************************");  
    System.out.println("******************************************************************");    
    System.out.println("*                                                                *");
    System.out.println("*     Enter student Name:                                        *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");    
    String newStudentName = strScanner.nextLine();
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     Enter student age:                                         *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    int newStudentAge = numScanner.nextInt();
    // validate age of student
    try {
        Utils.validateAge(newStudentAge);
    } catch(Exception e) {
      // TODO: allow user to re-input age if invalid
        System.out.println("******************************************************************");
        System.out.println("      " + e.getMessage());
        System.out.println("      Returning to menu.                                        ");
        System.out.println("******************************************************************");
        return;
    }
    NewStudentVO newStudentVO = new NewStudentVO(newStudentName,newStudentAge);
    System.out.println("******************************************************************");
    System.out.println("*                                                                *"); 
    System.out.println("*     You are adding a new student.                              *");
    System.out.println("*                                                                *"); 
    System.out.println("      Name: "+ newStudentVO.getName()); 
    System.out.println("       Age: "+ newStudentVO.getAge()); 
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    
    final boolean confirmation = utils.confirmInput(strScanner);
    
    if(confirmation) {
        final Student student = new Student(newStudentVO.getName(), newStudentVO.getAge());
        studentRegistrationService.registerStudent(student);
        System.out.println("******************************************************************");
        System.out.println("*                                                                *"); 
        System.out.println("*     Student Registered                                         *");
        System.out.println("*                                                                *"); 
        System.out.println("******************************************************************");
    }
  }
  
  protected void listStudents() {
    System.out.println("******************************************************************");
    System.out.println("*                                                                *"); 
    System.out.println("*     Listing all students                                       *");
    System.out.println("*                                                                *"); 
    StudentRegistrationService.getRegisteredStudents().stream().forEach(student -> {
      try {
        Utils.displayStudentInfo(student.getStudentId());
      } catch (Exception e) {
        return;
      }
    });
    System.out.println("*                                                                *");  
    System.out.println("******************************************************************");
  }
  
  protected void assignCourse(Scanner numScanner, Scanner strScanner) throws Exception{
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     Assigning Course To Student                                *");
    System.out.println("*                                                                *");
    System.out.println("******************************************************************");  
    System.out.println("******************************************************************");    
    System.out.println("*                                                                *");
    System.out.println("*     Enter Student ID:                                         *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");    
    int newCourseAssignmentStudentId = numScanner.nextInt();
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     Enter Course ID:                                           *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    int newCourseAssignmentCourseId = numScanner.nextInt();
    NewCourseAssignmentVO newCourseAssignmentVO = new NewCourseAssignmentVO(newCourseAssignmentStudentId,newCourseAssignmentCourseId);

    try {
    Utils.validateCourseAssignment(newCourseAssignmentVO);
    } catch (Exception e){
      //TODO: sysout exception details
      return;
    }
    final int courseAssignmentId = courseAssignmentService.assignCourse(newCourseAssignmentVO);
      final Course course = Utils.getCourse(newCourseAssignmentVO.getCourseId());
      course.addStudentCourseAssignment(courseAssignmentId);
  }

}
