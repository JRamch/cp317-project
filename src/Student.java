/**
 * CP317 Project
 * Authors: Josh Gelbaum, Drake Martin, Paul Matsialko, Jaden Ramcharan
 */

public abstract class Student {
    private String studentID;
    private String studentName;

    public Student(String studentID, String studentName){
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public void setStudentID(String studentID){
        this.studentID = studentID;
    }

    public String getStudentID(){
        return this.studentID;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public String getStudentName(){
        return this.studentName;
    }

}
