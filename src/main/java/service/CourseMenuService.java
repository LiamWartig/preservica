package service;

import java.util.Scanner;

import courses.Course;
import courses.NewCourseVO;
import utils.Utils;

public class CourseMenuService {
  private final CourseRegistrationService courseRegistrationService = new CourseRegistrationService();

  protected void newCourse(Scanner numScanner, Scanner strScanner) {
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

    final boolean confirmation = Utils.confirmInput(strScanner);
      
    if(confirmation) {
    final Course course = new Course(newCourseVO.getName(), newCourseVO.getMaxClassSize());
    courseRegistrationService.registerCourse(course);
    System.out.println("******************************************************************");
    System.out.println("*                                                                *"); 
    System.out.println("*     Course Registered                                          *");
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    }
  }
    
  protected void listCourses() throws Exception{
    System.out.println("******************************************************************");
    System.out.println("*                                                                *"); 
    System.out.println("*     Listing all courses                                        *");
    System.out.println("*                                                                *"); 
    CourseRegistrationService.getRegisteredCourses().stream().forEach(course -> {
      try {
        Utils.displayCourseInfo(course.getCourseId());
      } catch (Exception e) {
        System.out.println("*************** error retrieving course information **************"); 
        return;
      }
    });
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");
    };  

}
