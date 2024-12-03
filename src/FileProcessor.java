/**
 * CP317 Project
 * Authors: Josh Gelbaum, Drake Martin, Paul Matsialko, Jaden Ramcharan
 */

 import java.util.*;
 import java.io.*;
 
 public class FileProcessor {
     private List<CourseStudent> students = new ArrayList<>(); // Encapsulate
 
     public void readFiles(String nameFilePath, String courseFilePath) throws IOException {
         Map<String, String> nameMap = new HashMap<>(); // Create hashmap with key and value
 
         // Validate NameFile length
         int nameFileLines = countLines(nameFilePath);
         if (nameFileLines != 25) {
             throw new IOException("NameFile must contain exactly 25 lines. Found: " + nameFileLines);
         }
 
         // Validate CourseFile length
         int courseFileLines = countLines(courseFilePath);
         if (courseFileLines != 50) {
             throw new IOException("CourseFile must contain exactly 50 lines. Found: " + courseFileLines);
         }
 
         int lineNumber = 0; // Track line number
 
         // Read NameFile
         try (BufferedReader nameReader = new BufferedReader(new FileReader(nameFilePath))) {
             String line;
             while ((line = nameReader.readLine()) != null) {
                 lineNumber++;
                 String[] parts = line.split(",");
 
                 if (parts.length != 2) {
                     throw new IllegalArgumentException("Invalid format in NameFile on line " + lineNumber + ": " + line);
                 }
 
                 String studentID = parts[0].trim();
                 String studentName = parts[1].trim();
 
                 if (!Student.isValidStudentID(studentID)) {
                     throw new IllegalArgumentException("Invalid Student ID in NameFile on line " + lineNumber + ": " + studentID);
                 }
                 if (!Student.isValidStudentName(studentName)) {
                     throw new IllegalArgumentException("Invalid Student Name in NameFile on line " + lineNumber + ": " + studentName);
                 }
 
                 nameMap.put(studentID, studentName);
             }
         }
 
         lineNumber = 0; // Reset line number for the next file
 
         // Read CourseFile
         try (BufferedReader courseReader = new BufferedReader(new FileReader(courseFilePath))) {
             String line;
             while ((line = courseReader.readLine()) != null) {
                 lineNumber++;
                 String[] parts = line.split(",");
 
                 if (parts.length != 6) {
                     throw new IllegalArgumentException("Invalid format in CourseFile on line " + lineNumber + ": " + line);
                 }
 
                 String studentID = parts[0].trim();
                 String courseCode = parts[1].trim();
                 double test1 = Double.parseDouble(parts[2].trim());
                 double test2 = Double.parseDouble(parts[3].trim());
                 double test3 = Double.parseDouble(parts[4].trim());
                 double finalExam = Double.parseDouble(parts[5].trim());
 
                 if (!Student.isValidStudentID(studentID)) {
                     throw new IllegalArgumentException("Invalid Student ID in CourseFile on line " + lineNumber + ": " + studentID);
                 }
                 if (!CourseStudent.isValidCourseCode(courseCode)) {
                     throw new IllegalArgumentException("Invalid course code in CourseFile on line " + lineNumber + ": " + courseCode);
                 }
                 if (!nameMap.containsKey(studentID)) {
                     throw new IllegalArgumentException("Student ID not found in NameFile on line " + lineNumber + ": " + studentID);
                 }
                 if (!CourseStudent.isValidTestScore(test1) || !CourseStudent.isValidTestScore(test2) ||
                         !CourseStudent.isValidTestScore(test3) || !CourseStudent.isValidTestScore(finalExam)) {
                     throw new IllegalArgumentException("Invalid test score(s) for Student ID on line " + lineNumber + ": " + studentID);
                 }
 
                 CourseStudent student = new CourseStudent(
                         studentID, nameMap.get(studentID), courseCode, test1, test2, test3, finalExam
                 );
                 students.add(student);
             }
 
             if (students.size() < (nameMap.size() * 2)) {
                 throw new IOException("Student's grade missing");
             }
         }
     }
 
     // Write to output file
     public void writeOutputFile(String outputFilePath) throws IOException {
         students.sort(Comparator.comparing(CourseStudent::getStudentID)); // Sort by student ID (ascending order)
 
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
 
     // Utility method to count lines in a file
     private int countLines(String filePath) throws IOException {
         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
             int lines = 0;
             while (reader.readLine() != null) {
                 lines++;
             }
             return lines;
         }
     }
 }
