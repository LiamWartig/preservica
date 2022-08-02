package courses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import service.CourseAssignmentService;

public class Course {
  protected String name;
  protected int maxClassSize;
  protected int courseId;
  protected List<Integer> courseAssignmentIds = new ArrayList<>();

  public Course(final String nameIn, final int maxClassSizeIn) {
    this.name=nameIn;
    this.maxClassSize=maxClassSizeIn;
  }

  public void setCourseName(final String courseNameIn) {
    this.name=courseNameIn;
  }

  public void setMaxClassSize(final int maxClassSizeIn) {
    this.maxClassSize=maxClassSizeIn;
  }
  public int getMaxClassSize() {
    return this.maxClassSize;
}

  public void setCourseId(final int courseIdIn) {
this.courseId = courseIdIn;    
  }

  public int getCourseId() {
    return this.courseId;
  }

  public String getName() {
    return this.name;
  }
  
  public void addStudentCourseAssignment(final int courseAssignmentId) {
    courseAssignmentIds.add(courseAssignmentId);
  }
  
  public void removeStudentCourseAssignment(final int courseAssignmentId) {
    courseAssignmentIds.remove(courseAssignmentIds.indexOf(courseAssignmentId));
  }
  
  public List<Integer> getStudentIds(){
    List<Integer> studentIds = new ArrayList<>();
    if(null != courseAssignmentIds && !courseAssignmentIds.isEmpty()) {
      List<CourseAssignment> courseAssignments = CourseAssignmentService.getCourseAssignments().stream().filter(ca -> ca.getCourseId() == this.courseId).collect(Collectors.toList());
        studentIds.addAll(courseAssignments.stream().map(ca -> ca.getStudentId()).collect(Collectors.toList()));
    }
     return studentIds;
  }
  
  
}