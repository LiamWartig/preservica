package service;

import java.util.Scanner;

public class MenuService {
  private final Scanner numScanner = new Scanner(System.in);
  private final Scanner strScanner = new Scanner(System.in);
  private StudentMenuService studentMenuService = new StudentMenuService();
  private CourseMenuService courseMenuService = new CourseMenuService();

  public void intro() {
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
  };
  
  public void mainMenu() throws Exception{
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*         _______________                                        *");
    System.out.println("*        |   Main Menu   |                                       *");
    System.out.println("*        |_______________|                                       *");
    System.out.println("*                                                                *");
    System.out.println("*         1. Students                                            *");
    System.out.println("*         2. Teachers                                             *");
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
  
  private void studentsMenu() throws Exception{
    
    System.out.println("******************************************************************");
    System.out.println("*                                                                *");
    System.out.println("*         _______________                                        *");
    System.out.println("*        | Students Menu |                                       *");
    System.out.println("*        |_______________|                                       *");
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
        studentMenuService.newStudent(numScanner, strScanner);
        studentsMenu();
        break;
      }
      case 2: {
        studentMenuService.listStudents();
        studentsMenu();
        break;
      }
      case 3: {
        studentMenuService.assignCourse(numScanner, strScanner);
        studentsMenu(); 
        break;
      }
      //      case 4: removeCourse();
      default: mainMenu();
      }  
  }
  
  private void coursesMenu() throws Exception{

      System.out.println("******************************************************************");
      System.out.println("*                                                                *");
      System.out.println("*         _______________                                        *");
      System.out.println("*        | Courses Menu  |                                       *");
      System.out.println("*        |_______________|                                       *");
      System.out.println("*                                                                *");
      System.out.println("*         1. New Course                                          *");
      System.out.println("*         2. List Courses                                        *");
      System.out.println("*         3. Return to Main Menu                                 *");
      System.out.println("*                                                                *");
      System.out.println("******************************************************************");
      
      int courseMenuSelection = numScanner.nextInt();
      
      switch(courseMenuSelection) {
        case 1: {
          courseMenuService.newCourse(numScanner, strScanner);
          coursesMenu();
          break;
        }
        case 2: {
          courseMenuService.listCourses();
          coursesMenu();
          break;
        }
        default : mainMenu();
      }
  
  }
}
