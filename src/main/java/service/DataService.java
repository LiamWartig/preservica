package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import registrants.Student;
import utils.Utils;

public class DataService {

  public static void populateData() {
    
    
  }
  
  public static void saveData() throws Exception {
    try {
      File dataFile = new File("UniversityRegistrationData.txt");
      if (dataFile.createNewFile()) {
        System.out.println("File created: " + dataFile.getName());
      } else {
        System.out.println("Data File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred creating new datafile.");
    }
    
    try {
      FileWriter writer = new FileWriter("UniversityRegistrationData.txt");
      String data = formatData();
      writer.write(data);
      writer.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred writing data to datafile.");
    }
  }
  
  private static String formatData() throws Exception{
    String data = "";
    for (int i=1; i==Utils.studentIdCounter; i++) {
      Student student = Utils.getStudent(i);
      data = data + (student.getName() + "," + student.getAge() + "," + student.getAssignedCourseIds() + "\n");
    
    }
    return data;
  }
  
}
