package exception;

public class StudentNotFoundException extends RuntimeException {
  
  private static final long serialVersionUID = -3127054865647660324L;

  private int studentId;
  private String message;
  
  public StudentNotFoundException(final int studentIdIn) {
    this.studentId = studentIdIn;
    this.message = "No student found with ID: " + studentIdIn;
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
  
}
