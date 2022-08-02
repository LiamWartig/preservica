package exception;

import courses.NewCourseAssignmentVO;

public class DuplicateCourseAssignmentException extends RuntimeException {
  private static final long serialVersionUID = 4502279250464275242L;
  private int studentId;
  private int courseId;
  private String message;
  
  public DuplicateCourseAssignmentException(final NewCourseAssignmentVO vo) {
    this.studentId = vo.getStudentId();
    this.setCourseId(vo.getCourseId());
    this.message = "Course with ID: " + vo.getCourseId() + " has already been assigned to student with ID: " + vo.getStudentId();
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }
}
