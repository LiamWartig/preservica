package validation;

import java.util.List;
import java.util.stream.Collectors;

import courses.Course;
import courses.NewCourseAssignmentVO;
import courses.RemoveCourseAssignmentVO;
import exception.CourseAssignmentNotFoundException;
import exception.CourseFullException;
import exception.CourseNotFoundException;
import exception.DuplicateCourseAssignmentException;
import exception.StudentNotFoundException;
import service.CourseAssignmentService;
import utils.Utils;

public class AssignmentValidation {
  public static boolean validateNewCourseAssignment(final NewCourseAssignmentVO newCourseAssignmentVO) throws Exception {
    try {
        checkStudentExists(newCourseAssignmentVO.getStudentId());
        checkCourseExists(newCourseAssignmentVO.getCourseId());
        checkCourseNotAlreadyAssignedToStudent(newCourseAssignmentVO);
        checkClassNotFull(newCourseAssignmentVO.getCourseId());
    } catch (Exception e) {
        Utils.displayErrorMessage(e);
        return false;
    }
    return true;
}   
  
  public static boolean validateRemoveCourseAssignment(final RemoveCourseAssignmentVO removeCourseAssignmentVO) throws Exception{
    try {
      checkStudentExists(removeCourseAssignmentVO.getStudentId());
      checkCourseExists(removeCourseAssignmentVO.getCourseId());
      checkCourseAssignmentExists(removeCourseAssignmentVO);
    } catch (Exception e) {
      Utils.displayErrorMessage(e);
      return false;
    }
    return true;
  }
    
  private static void checkCourseAssignmentExists(final RemoveCourseAssignmentVO removeCourseAssignmentVO) throws Exception {
    try {
        Utils.getCourseAssignment(removeCourseAssignmentVO.getCourseId(),removeCourseAssignmentVO.getStudentId());
      } catch (Exception e) {
      CourseAssignmentNotFoundException ex = new CourseAssignmentNotFoundException(removeCourseAssignmentVO.getStudentId(),removeCourseAssignmentVO.getCourseId());
      throw ex;
    }
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
