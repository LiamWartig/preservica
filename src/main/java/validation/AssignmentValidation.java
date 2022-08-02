package validation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import courses.Course;
import courses.CourseAssignment;
import courses.NewCourseAssignmentVO;
import exception.CourseFullException;
import exception.CourseNotFoundException;
import exception.DuplicateCourseAssignmentException;
import exception.StudentNotFoundException;
import service.CourseAssignmentService;
import utils.Utils;

public class AssignmentValidation {
  public static boolean validateCourseAssignment(final NewCourseAssignmentVO newCourseAssignmentVO) throws Exception {
    try {
        checkStudentExists(newCourseAssignmentVO.getStudentId());
        checkCourseExists(newCourseAssignmentVO.getCourseId());
        checkCourseNotAlreadyAssignedToStudent(newCourseAssignmentVO);
        checkClassNotFull(newCourseAssignmentVO.getCourseId());
    } catch (Exception e) {
        System.out.println("******************************************************************");
        System.out.println("      " + e.getMessage());
        System.out.println("      Returning to menu.                                        ");
        System.out.println("******************************************************************");
        return false;
    }
    return true;
}   
  
  private static void checkCourseExists(final int courseId) throws Exception {
    try {
      Utils.getCourse(courseId);
    } catch (Exception e) {
      CourseNotFoundException ex = new CourseNotFoundException(courseId);
      throw ex;
    }
  }
  
  private static void checkCourseNotAlreadyAssignedToStudent(final NewCourseAssignmentVO vo) throws Exception {
      List<Integer> coursesAssignedToStudent = CourseAssignmentService.getCourseAssignments().stream().filter(ca -> ca.getStudentId() == vo.getStudentId()).map(ca -> ca.getCourseId()).collect(Collectors.toList());
//      List<Integer> courseIds = coursesAssignedToStudent.stream().map(ca -> ca.getCourseId()).collect(Collectors.toList());
      if (coursesAssignedToStudent.contains(vo.getCourseId())) {
      DuplicateCourseAssignmentException ex = new DuplicateCourseAssignmentException(vo);
      throw ex;
      }
  }
  
  private static void checkStudentExists(final int studentId) throws Exception {
    try{
      Utils.getStudent(studentId);
    } catch (Exception e) {
      StudentNotFoundException ex = new StudentNotFoundException(studentId);
      throw ex;
    }
  }
  
  private static void checkClassNotFull(final int courseId) throws Exception {
    final Course course = Utils.getCourse(courseId);
    if (course.getMaxClassSize() - course.getStudentIds().size() == 0) {
      throw new CourseFullException(courseId, course.getMaxClassSize());
    }
  }
  
}
