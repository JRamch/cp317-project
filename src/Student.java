/**
 * CP317 Project
 * Authors: Josh Gelbaum, Drake Martin, Paul Matsialko, Jaden Ramcharan
 */

 public abstract class Student {
    private String studentID;   
    private String studentName;  

    //Constructor
    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    //Getters and Setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    //Abstract method to calculate the final grade
    public abstract double calculateFinalGrade();
}
