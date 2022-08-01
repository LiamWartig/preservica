package courses;

public class CourseAssignment {
  protected int studentId;
  protected int courseId;
  protected int courseAssignmentId;
  
  public CourseAssignment(NewCourseAssignmentVO vo) {
    this.courseId=vo.courseId;
    this.studentId=vo.studentId;
  }

  public void setId(int id) {
     this.courseAssignmentId=id;
  }
  
  public int getId() {
    return this.courseAssignmentId;
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
