package service;

import courses.CourseAssignment;
import courses.NewCourseAssignmentVO;

public class CourseAssignmentService {

  public int assignCourse(final NewCourseAssignmentVO newCourseAssignmentVO) {
    CourseAssignment courseAssignment = new CourseAssignment(newCourseAssignmentVO);
    return courseAssignment.getId();
   
  }
  
  
}
