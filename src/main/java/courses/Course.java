package courses;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;
import service.StudentRegistrationService;

public class Course {
  protected String name;
  protected int maxClassSize;
  protected int courseId;
  protected int[] courseAssignmentIds = new int[100];
  int nextIndex = 0;
  public void push(int e) {
      courseAssignmentIds[nextIndex] = e;
      ++nextIndex;
  }
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
    push(courseAssignmentId);
  }
  
  public List<Integer> getStudentIds(){
    List<Integer> studentIds = new ArrayList<>();
    if(null != courseAssignmentIds) {
    for (int i = 0; i < courseAssignmentIds.length; i++) {
        int id  = courseAssignmentIds[i];
        studentIds.addAll(StudentRegistrationService.getRegisteredStudents().stream().filter(s -> ArrayUtils.contains(s.getAssignedCourseIds(),id)).map(s -> s.getStudentId()).collect(Collectors.toList()));
      }
    }
     return studentIds;
  }
  
  
}