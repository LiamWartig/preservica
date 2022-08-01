package exception;

public class CourseNotFoundException extends RuntimeException {
  
  private static final long serialVersionUID = -3127054865647660324L;

  private int courseId;
  private String message;
  
  public CourseNotFoundException(final int courseIdIn) {
    this.courseId = courseIdIn;
    this.message = "No course found with ID: " + courseIdIn;
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
