package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import registrants.Student;
import utils.Utils;

public class DataService {

  public void populateData() {
    
    
  }
  
  public static void saveData() throws Exception {
    try {
      File dataFile = new File("UniversityRegistrationData.csv");
      if (dataFile.createNewFile()) {
        System.out.println("File created: " + dataFile.getName());
      } else {
        System.out.println("Data File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred creating new datafile.");
    }
    
    try {
      writeStudentData();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred writing data to datafile.");
    }
  }
  
   public String readData() throws IOException {
       FileInputStream dataStream = new FileInputStream("UniversityRegistrationData.csv");
       return IOUtils.toString(dataStream, "UTF-8");
   }     

  private static void writeStudentData() throws Exception{
    BufferedWriter writer = new BufferedWriter(new FileWriter("UniversityRegistrationData.csv"));
    writer.write("");
    writer.write("studentName,studentAge,assignedCourses");
    writer.newLine();
    for ( int i = 1 ; i == Utils.studentIdCounter ; i++ ) {
      Student student = Utils.getStudent(i);
      String studentName = student.getName();
      String studentAge = String.valueOf(student.getAge());
      String assignedCourses = student.assignedCourseIds.toString();
      String line = String.format("%s,%s,%s",
              studentName, studentAge, assignedCourses);       
      writer.write(line);
      writer.newLine();
    }
    writer.close();
  }
  
}
