package service;

import java.util.Scanner;

import courses.Course;
import courses.NewCourseAssignmentVO;
import courses.RemoveCourseAssignmentVO;
import registrants.NewStudentVO;
import registrants.Student;
import utils.Utils;
import validation.AssignmentValidation;
import validation.StudentValidation;

public class StudentMenuService {
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
    try {
        StudentValidation.validateAge(newStudentAge);
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
    
    final boolean confirmation = Utils.confirmInput(strScanner);
    
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
        // TODO: add student not found exception
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
    
    System.out.println("******************************************************************");    
    System.out.println("*                                                                *");
    System.out.println("      You are assigning Student with ID: " + newCourseAssignmentVO.getStudentId());
    System.out.println("                                                                "); 
    System.out.println("           to Course with ID: " + newCourseAssignmentVO.getCourseId());
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    
    Utils.confirmInput(strScanner);
     
    final boolean isAssignmentValid = AssignmentValidation.validateNewCourseAssignment(newCourseAssignmentVO);

    if(isAssignmentValid) {
      final int courseAssignmentId = courseAssignmentService.assignCourse(newCourseAssignmentVO);
      final Course course = Utils.getCourse(newCourseAssignmentVO.getCourseId());
      course.addStudentCourseAssignment(courseAssignmentId);
      System.out.println("******************************************************************");
      System.out.println("*                                                                *"); 
      System.out.println("     Course: " + newCourseAssignmentVO.getCourseId());
      System.out.println("           successfully assigned to");
      System.out.println("     Student: " + newCourseAssignmentVO.getStudentId());
      System.out.println("*                                                                *"); 
      System.out.println("******************************************************************");
    }

  }

  protected void removeCourse(Scanner numScanner, Scanner strScanner) throws Exception{
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     Removing Course Assignment from Student                    *");
    System.out.println("*                                                                *");
    System.out.println("******************************************************************");  
    System.out.println("******************************************************************");    
    System.out.println("*                                                                *");
    System.out.println("*     Enter Student ID:                                         *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");    
    int removeCourseAssignmentStudentId = numScanner.nextInt();
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     Enter Course ID:                                           *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    int removeCourseAssignmentCourseId = numScanner.nextInt();
    
    RemoveCourseAssignmentVO removeCourseAssignmentVO = new RemoveCourseAssignmentVO(removeCourseAssignmentStudentId,removeCourseAssignmentCourseId);
    
    System.out.println("******************************************************************");    
    System.out.println("*                                                                *");
    System.out.println("      You are removing Student with ID: " + removeCourseAssignmentVO.getStudentId());
    System.out.println("                                                                "); 
    System.out.println("    from their assignment to Course with ID: " + removeCourseAssignmentVO.getCourseId());
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    
    Utils.confirmInput(strScanner);
     
    final boolean isAssignmentValid = AssignmentValidation.validateRemoveCourseAssignment(removeCourseAssignmentVO);

    if(isAssignmentValid) {
      courseAssignmentService.removeCourse(removeCourseAssignmentVO);
      System.out.println("******************************************************************");
      System.out.println("*                                                                *"); 
      System.out.println("     Student: " + removeCourseAssignmentVO.getStudentId());
      System.out.println("           successfully un-assigned from");
      System.out.println("     Course: " + removeCourseAssignmentVO.getCourseId());
      System.out.println("*                                                                *"); 
      System.out.println("******************************************************************");
    }

  }
}
