package courses;

import java.util.Collection;
import java.util.HashSet;

import service.Utils;

public class RegisteredCourses {

private static Collection<Course> registeredCourses = new HashSet<Course>();

Utils utils = new Utils();

public int registerCourse(final Course course) {

  final int courseId = utils.newCourseId();
  course.setCourseId(courseId);
  
registeredCourses.add(course);
return courseId;

}

public static Collection<Course> getRegisteredCourses() {
  return registeredCourses;
}

}