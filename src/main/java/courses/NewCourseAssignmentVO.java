package courses;

public class NewCourseAssignmentVO {
  protected int studentId;
  protected int courseId;

  public NewCourseAssignmentVO(final int studentIdIn, final int courseIdIn) {
    this.studentId=studentIdIn;
    this.courseId=courseIdIn;
  }

  public void setCourseId(final int courseIdIn) {
    this.courseId=courseIdIn;
  }
  public int getCourseId() {
    return this.courseId;
  }
  public void setStudentId(final int studentIdIn) {
this.studentId = studentIdIn;
}
  public int getStudentId() {
    return this.studentId;
  }
}
