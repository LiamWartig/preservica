package registrants;

import java.util.Collection;
import java.util.HashSet;

import courses.Course;
import courses.CourseAssignment;
import service.Utils;

public class RegisteredStudents {
private static Collection<Student> registeredStudents = new HashSet<Student>();


Utils utils = new Utils();

public void assignCourseId(CourseAssignment courseAssignment) {
  int courseAssignmentId = Utils.newCourseAssignmentId();
  courseAssignment.setId(courseAssignmentId);
 Course course = Utils.getCourse(courseAssignmentId);
 course.addStudentCourseAssignment(courseAssignmentId);
 Student student = Utils.getStudent(courseAssignment.getStudentId());
 student.assignCourse(course.getCourseId());
}

public int registerStudent(final Student student) {

  final int studentId = utils.newStudentId();
  student.setStudentId(studentId);
  
registeredStudents.add(student);
return studentId;

}

public static Collection<Student> getRegisteredStudents(){
  return RegisteredStudents.registeredStudents;
}

}
