/**
 * CP317 Project
 * Authors: Josh Gelbaum, Drake Martin, Paul Matsialko, Jaden Ramcharan
 */

 public class CourseStudent extends Student {
    private String courseCode;
    private double test1, test2, test3, finalExam;

    //Constructor with validation
    public CourseStudent(String studentID, String studentName, String courseCode, double test1, double test2, double test3, double finalExam) {
        super(studentID, studentName);  //Call to parent constructor
        this.courseCode = courseCode;

        if (!isValidTestScore(test1) || !isValidTestScore(test2) || !isValidTestScore(test3) || !isValidTestScore(finalExam)) {
            throw new IllegalArgumentException("Invalid test scores for Student ID: " + studentID); //Check if any test score is not valid
        }

        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
        this.finalExam = finalExam;
    }

    // Getters and setters
    public String getCourseCode() {
        return courseCode;
    }
    // Getter for test1
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    // Getter for test1
    public double getTest1() {
        return test1;
    }
     // setter for test1
    public void setTest1(double test1) {
        this.test1 = test1;
    }
    // getter for test2
    public double getTest2() {
        return test2;
    }
    // setter for test2
    public void setTest2(double test2) {
        this.test2 = test2;
    }
     // getter for test3
    public double getTest3() {
        return test3;
    }
     // setter for test3
    public void setTest3(double test3) {
        this.test3 = test3;
    }
    // getter for final exam score
    public double getFinalExam() {
        return finalExam;
    }
    // Setter for final exam score
    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    //Validation for test scores
    //A test score must be greater than 0, less than 100
    public static boolean isValidTestScore(double score) {
        return score > 0 && score <= 100;
    }

    //Validation for Course Codes
    public static boolean isValidCourseCode(String courseCode) {
        return courseCode.matches("^[A-Za-z]{2}\\d{3}$");
    }

    //Override abstract method to calculate the final grade
    @Override
    public double calculateFinalGrade() {
        return (test1 + test2 + test3) / 3 * 0.6 + finalExam * 0.4;
    }
}
