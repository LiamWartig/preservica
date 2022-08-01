package courses;

import java.util.Collection;
import java.util.HashSet;

import registrants.Student;
import service.Utils;

public class CourseAssignments {
  
  private static Collection<CourseAssignment> courseAssignments = new HashSet<CourseAssignment>();

  Utils utils = new Utils();

  public static void assignCourse(final NewCourseAssignmentVO newCourseAssignmentVO) {
    
    CourseAssignment courseAssignment = new CourseAssignment(newCourseAssignmentVO);
    
    courseAssignments.add(courseAssignment);
    Course course = Utils.getCourse(newCourseAssignmentVO.getCourseId());
    Student student = Utils.getStudent(newCourseAssignmentVO.getStudentId());

        
    System.out.println("******************************************************************");    
    System.out.println("*                                                                *");
    System.out.println("*     Course: " + course.getName());
    System.out.println("*                                                                *");
    System.out.println("*      has been successfully been assigned to ");
    System.out.println("*                                                                *");
    System.out.println("*    Student: " + student.getName());
    System.out.println("*                                                                *"); 
    System.out.println("******************************************************************");    

  }
  
  public Collection<CourseAssignment> getCourseAssignments(){
    return CourseAssignments.courseAssignments;
  }
}
