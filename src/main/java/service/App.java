package service;

import java.util.Scanner;

import registrants.NewStudentVO;
import courses.Course;
import courses.CourseAssignment;
import courses.NewCourseAssignmentVO;
import courses.NewCourseVO;
import courses.RegisteredCourses;
import registrants.RegisteredStudents;
import registrants.Student;
import courses.CourseAssignments;
public class App {
  
  static RegisteredStudents studentRegistration = new RegisteredStudents();
  static RegisteredCourses courseRegistration = new RegisteredCourses();
  public final static Scanner numScanner = new Scanner(System.in);
  public final static Scanner strScanner = new Scanner(System.in);


  public static void main(String[] args) {
    
    // display introductory message
    intro();
    
    // show main menu
    mainMenu();

    }    
  private static void mainMenu() {
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     Please select from the following options:                  *");
    System.out.println("*                                                                *");
    System.out.println("*         1. Students                                            *");
    System.out.println("*         2. Teaches                                             *");
    System.out.println("*         3. Courses                                             *");
    System.out.println("*         4. Exit                                                *");
    System.out.println("*                                                                *");
    System.out.println("******************************************************************");
    int mainMenuSelection =  numScanner.nextInt();
    switch(mainMenuSelection) {
      case 1: {
        studentsMenu();
      break;
      }
      case 3: {
        coursesMenu();
        break;
      }
      case 4: {
        System.out.println("******************************************************************");
        System.out.println("*                                                                *");
        System.out.println("*     Exiting Program.                                           *");
        System.out.println("*                                                                *");
        System.out.println("******************************************************************");
        return;
      }
      }
  }
  private static void studentsMenu() {

    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     You have selected \"Students\".                            *");
    System.out.println("*     Now please select from the following options:              *");
    System.out.println("*                                                                *");
    System.out.println("*         1. New Student                                         *");
    System.out.println("*         2. List Students                                       *");
    System.out.println("*         3. Assign Course                                       *");
    System.out.println("*         4. Remove Course                                       *");
    System.out.println("*         5. Return to Main Menu                                 *");
    System.out.println("*                                                                *");
    System.out.println("******************************************************************");
    int studentMenuSelection = numScanner.nextInt();
    
    switch(studentMenuSelection) {
      case 1: {
        newStudent();
        break;
      }
      case 2: {
        listStudents();
        break;
      }
      case 3: {
        assignCourse();
        break;
      }//      case 4: removeCourse();
      case 5: mainMenu();
      }  
  }
  
  private static void coursesMenu() {

      System.out.println("******************************************************************");
      System.out.println("*                                                                *");
      System.out.println("*     You have selected \"Courses\".                             *");
      System.out.println("*     Now please select from the following options:              *");
      System.out.println("*                                                                *");
      System.out.println("*         1. New Course                                          *");
      System.out.println("*         2. List Course                                         *");
      System.out.println("*         5. Return to Main Menu                                 *");
      System.out.println("*                                                                *");
      System.out.println("******************************************************************");
      int courseMenuSelection = numScanner.nextInt();
      
      switch(courseMenuSelection) {
        case 1: {
          newCourse();
          break;
        }
        case 2: {
          listCourses();
          break;
        }
        default : mainMenu();
  }
  }
  
  private static void assignCourse() {
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
      //display error message
      studentsMenu();
    }
    
    CourseAssignments.assignCourse(newCourseAssignmentVO);
    
    studentsMenu();
  }
  
  
  private static void newCourse() {
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     Registering New Course                                     *");
    System.out.println("*                                                                *");
    System.out.println("******************************************************************");  
    System.out.println("******************************************************************");    
    System.out.println("*                                                                *");
    System.out.println("*     Enter course name:                                         *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");    
    String newCourseName = strScanner.nextLine();
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     Enter maximum class size                                   *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    int newCourseMaxClassSize = numScanner.nextInt();

    NewCourseVO newCourseVO = new NewCourseVO(newCourseName,newCourseMaxClassSize);
    System.out.println("******************************************************************");
    System.out.println("*                                                                *"); 
    System.out.println("*     You are adding a new course.                               *");
    System.out.println("*                                                                *"); 
    System.out.println("             Course Name: "+ newCourseVO.getName()); 
    System.out.println("      Maximum Class Size: "+ newCourseVO.getMaxClassSize()); 
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    System.out.println("*                                                                *"); 
    System.out.println("*     Are these details correct? (y/n)                           *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    String confirmation = strScanner.nextLine();

    if(confirmation.toUpperCase().equals("Y")) {
      
    
    final Course course = new Course(newCourseVO.getName(), newCourseVO.getMaxClassSize());
    courseRegistration.registerCourse(course);
    System.out.println("******************************************************************");
    System.out.println("*                                                                *"); 
    System.out.println("*     Course Registered                                          *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    }
    coursesMenu();
  }
  
  
  private static void intro() {
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     Welcome to University Course                               *");
    System.out.println("*     Registration Service                                       *");
    System.out.println("*                                                                *");
    System.out.println("******************************************************************");
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*     input your answer in your keyboard                         *");
    System.out.println("*     then press enter                                           *");
    System.out.println("*                                                                *");
    System.out.println("******************************************************************");    
  }
  
  protected static void newStudent() {
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
        System.out.println("*      Age cannot be negative.                                   *");
        System.out.println("*      Returning to menu.                                        *");
        System.out.println("******************************************************************");
        studentsMenu();
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
    System.out.println("*                                                                *"); 
    System.out.println("*     Are these details correct? (y/n)                           *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    String confirmation = strScanner.nextLine();
    
    if(confirmation.toUpperCase().equals("Y")) {
    final Student student = new Student(newStudentVO.getName(), newStudentVO.getAge());
    studentRegistration.registerStudent(student);
    System.out.println("******************************************************************");
    System.out.println("*                                                                *"); 
    System.out.println("*     Student Registered                                         *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    }
    studentsMenu();

  }
  
protected static void listStudents() {
  System.out.println("******************************************************************");
  System.out.println("*                                                                *"); 
  System.out.println("*     Listing all students                                       *");
  System.out.println("*                                                                *"); 
  RegisteredStudents.getRegisteredStudents().stream().forEach(student -> Utils.displayStudentInfo(student.getStudentId()));
  System.out.println("*                                                                *");  
  System.out.println("******************************************************************");
  studentsMenu();
};
protected static void listCourses() {
System.out.println("******************************************************************");
System.out.println("*                                                                *"); 
System.out.println("*     Listing all courses                                        *");
System.out.println("*                                                                *"); 
  RegisteredCourses.getRegisteredCourses().stream().forEach(course -> Utils.displayCourseInfo(course.getCourseId()));
  System.out.println("*                                                                *"); 
  System.out.println("******************************************************************");
  coursesMenu();
};  



}
