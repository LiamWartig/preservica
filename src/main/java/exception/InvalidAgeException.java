package exception;

public class InvalidAgeException extends RuntimeException {
  private static final long serialVersionUID = 1742794655917952218L;
  
  private int invalidAge;
  private String message;
  
  public InvalidAgeException(final int invalidAgeIn) {
    this.invalidAge = invalidAgeIn;
    this.setMessage(this.invalidAge + " is an invalid age");
  }

  public int getInvalidAge() {
    return invalidAge;
  }

  public void setInvalidAge(int invalidAge) {
    this.invalidAge = invalidAge;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
  
}