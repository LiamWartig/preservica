package service;

import java.util.Collection;
import java.util.HashSet;

import courses.CourseAssignment;
import courses.NewCourseAssignmentVO;

public class CourseAssignmentService {
  private static Collection<CourseAssignment> courseAssignments = new HashSet<CourseAssignment>();

  public int assignCourse(final NewCourseAssignmentVO newCourseAssignmentVO) {
    CourseAssignment courseAssignment = new CourseAssignment(newCourseAssignmentVO);
    courseAssignments.add(courseAssignment);
    return courseAssignment.getId();
   
  }

  public static Collection<CourseAssignment> getCourseAssignments() {
    return courseAssignments;
  }
  
}
