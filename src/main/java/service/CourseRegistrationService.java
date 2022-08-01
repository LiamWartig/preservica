package service;

import java.util.Collection;
import java.util.HashSet;

import courses.Course;
import utils.Utils;

public class CourseRegistrationService {
 
  private static Collection<Course> registeredCourses = new HashSet<Course>();

  public int registerCourse(final Course course) {
    final int courseId = Utils.newCourseId();
    course.setCourseId(courseId);
    registeredCourses.add(course);
    return courseId;
  }
    
  public static Collection<Course> getRegisteredCourses() {
    return registeredCourses;
  }

}
