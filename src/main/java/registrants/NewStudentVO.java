package registrants;

public class NewStudentVO {
  
protected String name;
protected int age;

public NewStudentVO(final String nameIn, final int ageIn) {
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

}
