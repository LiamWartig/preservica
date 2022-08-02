package validation;

import exception.InvalidAgeException;

public class StudentValidation {
  public static void validateAge(final int age) throws Exception{
    if(age<0) {
       throw new InvalidAgeException(age);
    } 
}

}
