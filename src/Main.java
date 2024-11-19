/**
 * CP317 Project
 * Authors: Josh Gelbaum, Drake Martin, Paul Matsialko, Jaden Ramcharan
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileProcessor processor = new FileProcessor();

            //Paths
            String nameFilePath = "NameFile.txt";
            String courseFilePath = "CourseFile.txt";
            String outputFilePath = "OutputFile.txt";

            //Process files
            processor.readFiles(nameFilePath, courseFilePath);
            processor.writeOutputFile(outputFilePath);


            System.out.println("Done! Output written to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
