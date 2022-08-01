package exception;

public class CourseFullException extends RuntimeException {
  private static final long serialVersionUID = 1742704655917952218L;
  
  private int courseId;
  private int maxClassSize;
  private String message;
  
  public CourseFullException(final int courseIdIn, final int maxClassSizeIn) {
    this.courseId = courseIdIn;
    this.maxClassSize = maxClassSizeIn;
    this.message = "Course with id: " + this.courseId + " is full.";
  }
  
  public int getCourseId() {
    return courseId;
  }
  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }
  public int getMaxClassSize() {
    return maxClassSize;
  }
  public void setMaxClassSize(int maxClassSize) {
    this.maxClassSize = maxClassSize;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  

}
