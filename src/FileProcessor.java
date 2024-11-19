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

        
        try (BufferedReader nameReader = new BufferedReader(new FileReader(nameFilePath))) {
            String line;
            while ((line = nameReader.readLine()) != null) {
                String[] parts = line.split(",");
                nameMap.put(parts[0].trim(), parts[1].trim()); //ID -> Name
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

                //Use hashmap to find key
                if (nameMap.containsKey(studentID)) {
                    CourseStudent student = new CourseStudent(
                        studentID, nameMap.get(studentID), courseCode, test1, test2, test3, finalExam
                    );
                    students.add(student);
                }
            }
        }
    }

    //Write to output file
    public void writeOutputFile(String outputFilePath) throws IOException {
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
