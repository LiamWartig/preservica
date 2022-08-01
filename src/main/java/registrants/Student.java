package registrants;

public class Student{
  
protected String name;
protected int age;
protected int studentId;
public int[] assignedCourseIds;
int nextIndex = 0;

public void push(int e) {
  assignedCourseIds[nextIndex] = e;
    ++nextIndex;
}
public Student(final String nameIn, final int ageIn) {
  this.name=nameIn;
  this.age=ageIn;
}
public final String getName() {
  return this.name;
}
public final void setName(final String nameIn) {
  this.name=nameIn;
}
public final int getAge() {
  return this.age;
}
public final void setAge(final int ageIn) {
  this.age=ageIn;
}

public int[] getAssignedCourseIds(){
  return this.assignedCourseIds;
}

public final void setStudentId(final int studentIdIn) {
  this.studentId = studentIdIn;
}
public final int getStudentId() {
  return this.studentId;
}

public void assignCourse(final int courseId) {
  push(courseId);
}

}
