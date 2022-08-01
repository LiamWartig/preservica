package courses;

import java.util.Collection;
import java.util.HashSet;

import registrants.Student;
import utils.Utils;

public class CourseAssignments {
  
  private static Collection<CourseAssignment> courseAssignments = new HashSet<CourseAssignment>();

  Utils utils = new Utils();

  public static void assignCourse(final NewCourseAssignmentVO newCourseAssignmentVO) throws Exception{
    
    CourseAssignment courseAssignment = new CourseAssignment(newCourseAssignmentVO);
    
    courseAssignments.add(courseAssignment);
    
    Course course = Utils.getCourse(newCourseAssignmentVO.getCourseId());
    course.addStudentCourseAssignment(courseAssignment.getId());
    Student student = Utils.getStudent(newCourseAssignmentVO.getStudentId());
student.assignCourse(newCourseAssignmentVO.getCourseId());
        
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
