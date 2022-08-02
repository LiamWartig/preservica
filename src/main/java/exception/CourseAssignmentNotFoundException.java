package exception;

public class CourseAssignmentNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 7308480897480797089L;
  private int studentId;
  private int courseId;
  private String message;
  
  
  public CourseAssignmentNotFoundException(final int studentIdIn, final int courseIdIn) {
    this.studentId = studentIdIn;
    this.courseId = courseIdIn;
    this.message = "Course assignment not found for course with ID: " + courseIdIn + " and student with ID: " + studentIdIn;
  }
  
  public int getStudentId() {
    return studentId;
  }
  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }
  public int getCourseId() {
    return courseId;
  }
  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  
  
}
