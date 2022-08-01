package courses;

public class NewCourseVO {
  
protected String courseName;
protected int maxClassSize;

public NewCourseVO(final String courseNameIn, final int maxClassSizeIn) {
  this.courseName=courseNameIn;
  this.maxClassSize=maxClassSizeIn;
}

public void setCourseName(final String courseNameIn) {
  this.courseName=courseNameIn;
}
public String getName() {
  return this.courseName;
}
public void setMaxClassSize(final int maxClassSizeIn) {
  this.maxClassSize=maxClassSizeIn;
}
public int getMaxClassSize() {
  return this.maxClassSize;
}
}
