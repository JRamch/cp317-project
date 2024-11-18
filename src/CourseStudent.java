/**
 * CP317 Project
 * Authors: Josh Gelbaum, Drake Martin, Paul Matsialko, Jaden Ramcharan
 */

public class CourseStudent extends Student{
    private String courseCode;
    private double test1, test2, test3, finalExam;

    public CourseStudent(String studentID, String studentName, String courseCode, double test1, double test2, double test3, double finalExam) {
        super(studentID, studentName); //Calls the parent constructor for the student's name and id
        this.courseCode = courseCode; 
        this.test1 = test1; 
        this.test2 = test2; 
        this.test3 = test3; 
        this.finalExam = finalExam;
     }
    
}
