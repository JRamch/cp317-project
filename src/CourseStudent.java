/**
 * CP317 Project
 * Authors: Josh Gelbaum, Drake Martin, Paul Matsialko, Jaden Ramcharan
 */

 public class CourseStudent extends Student {
    private String courseCode;   
    private double test1, test2, test3, finalExam;

    //Constructor
    public CourseStudent(String studentID, String studentName, String courseCode, 
                         double test1, double test2, double test3, double finalExam) {
        super(studentID, studentName);  //Call to parent constructor
        this.courseCode = courseCode;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
        this.finalExam = finalExam;
    }

    //Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public double getTest1() {
        return test1;
    }

    public void setTest1(double test1) {
        this.test1 = test1;
    }

    public double getTest2() {
        return test2;
    }

    public void setTest2(double test2) {
        this.test2 = test2;
    }

    public double getTest3() {
        return test3;
    }

    public void setTest3(double test3) {
        this.test3 = test3;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    // Override abstract method to calculate the final grade
    @Override
    public double calculateFinalGrade() {
        return (test1 + test2 + test3) / 3 * 0.6 + finalExam * 0.4;
    }
}
