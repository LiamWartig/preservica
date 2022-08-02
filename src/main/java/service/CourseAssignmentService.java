package service;

import java.util.Collection;
import java.util.HashSet;

import courses.Course;
import courses.CourseAssignment;
import courses.NewCourseAssignmentVO;
import courses.RemoveCourseAssignmentVO;
import utils.Utils;

public class CourseAssignmentService {
  private static Collection<CourseAssignment> courseAssignments = new HashSet<CourseAssignment>();

  public int assignCourse(final NewCourseAssignmentVO newCourseAssignmentVO) throws Exception {
    CourseAssignment courseAssignment = new CourseAssignment(newCourseAssignmentVO);
    courseAssignments.add(courseAssignment);
    Course course = Utils.getCourse(newCourseAssignmentVO.getCourseId());
    course.addStudentCourseAssignment(courseAssignment.getId());
    return courseAssignment.getId();
  }
  
  public void removeCourse(final RemoveCourseAssignmentVO removeCourseAssignmentVO) throws Exception {
    final Course course = Utils.getCourse(removeCourseAssignmentVO.getCourseId());
    final CourseAssignment courseAssignment = Utils.getCourseAssignment(removeCourseAssignmentVO.getCourseId(),removeCourseAssignmentVO.getStudentId());
    course.removeStudentCourseAssignment(courseAssignment.getId());
    courseAssignments.remove(courseAssignment);
  }

  public static Collection<CourseAssignment> getCourseAssignments() {
    return courseAssignments;
  }
  
}
