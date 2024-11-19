/**
 * CP317 Project
 * Authors: Josh Gelbaum, Drake Martin, Paul Matsialko, Jaden Ramcharan
 */

 public abstract class Student {
    private String studentID;
    private String studentName;

    //Constructor with validation
    public Student(String studentID, String studentName) {
        if (!isValidStudentID(studentID)) {
            throw new IllegalArgumentException("Invalid Student ID: " + studentID);
        }
        if (!isValidStudentName(studentName)) {
            throw new IllegalArgumentException("Invalid Student Name: " + studentName);
        }

        this.studentID = studentID;
        this.studentName = studentName;
    }

    //Getters
    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    //Abstract method to calculate final grade
    public abstract double calculateFinalGrade();

    //Validation for Student ID
    //Student ID must contain 9 integers
    public static boolean isValidStudentID(String studentID) {
        return studentID.matches("\\d{9}");
    }

    //Validation for Student Name
    //Student name must contain letters
    public static boolean isValidStudentName(String name) {
        return name.matches("[a-zA-Z ]+");
    }
}
