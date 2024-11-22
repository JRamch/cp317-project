/**
 * CP317 Project
 * Authors: Josh Gelbaum, Drake Martin, Paul Matsialko, Jaden Ramcharan
 */

 import java.util.*;
 import java.io.*;
 
 public class FileProcessor {
     private List<CourseStudent> students = new ArrayList<>(); //Encapsulate
 
     public void readFiles(String nameFilePath, String courseFilePath) throws IOException {
         Map<String, String> nameMap = new HashMap<>(); //Create hashmap with key and value
 
         //Read NameFile
         try (BufferedReader nameReader = new BufferedReader(new FileReader(nameFilePath))) {
             String line;
             while ((line = nameReader.readLine()) != null) {
                 String[] parts = line.split(",");
                 String studentID = parts[0].trim();
                 String studentName = parts[1].trim();
 
                 if (!Student.isValidStudentID(studentID)) {
                     throw new IllegalArgumentException("Invalid Student ID in NameFile: " + studentID); //Check to see if ID is in NameFile
                 }
                 if (!Student.isValidStudentName(studentName)) {
                     throw new IllegalArgumentException("Invalid Student Name in NameFile: " + studentName); //Check to see if name is in NameFile
                 }
 
                 nameMap.put(studentID, studentName); //ID -> Name
             }
             
         }
 
         //Read CourseFile
         try (BufferedReader courseReader = new BufferedReader(new FileReader(courseFilePath))) {
             String line;
             while ((line = courseReader.readLine()) != null) {
                 String[] parts = line.split(",");
                 String studentID = parts[0].trim();
                 String courseCode = parts[1].trim();
                 double test1 = Double.parseDouble(parts[2].trim());
                 double test2 = Double.parseDouble(parts[3].trim());
                 double test3 = Double.parseDouble(parts[4].trim());
                 double finalExam = Double.parseDouble(parts[5].trim());
 
                 if (!Student.isValidStudentID(studentID)) {
                     throw new IllegalArgumentException("Invalid Student ID in CourseFile: " + studentID); //Check to see if ID is in CourseFile
                 }
                 if (!nameMap.containsKey(studentID)) {
                     throw new IllegalArgumentException("Student ID not found in NameFile: " + studentID); //Check to see if ID is in NameFile
                 }
                 if (!CourseStudent.isValidTestScore(test1) || !CourseStudent.isValidTestScore(test2) ||
                         !CourseStudent.isValidTestScore(test3) || !CourseStudent.isValidTestScore(finalExam)) {
                     throw new IllegalArgumentException("Invalid test score(s) for Student ID: " + studentID); //Check to see validity of scores
                 }
 
                 CourseStudent student = new CourseStudent(
                         studentID, nameMap.get(studentID), courseCode, test1, test2, test3, finalExam
                 );
                 students.add(student);
             }
             if (students.size() < (nameMap.size()*2)){
                throw new IOException("Student's grade missing");
             }
         }
     }
 
     //Write to output file
     public void writeOutputFile(String outputFilePath) throws IOException {

        students.sort(Comparator.comparing(CourseStudent::getStudentID)); //Sort by student ID (ascending order)

         try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
             for (CourseStudent student : students) {
                 writer.write(String.format(
                         "%s,%s,%s,%.1f%n",
                         student.getStudentID(),
                         student.getStudentName(),
                         student.getCourseCode(),
                         student.calculateFinalGrade()
                 ));
             }
         }
     }
 }
