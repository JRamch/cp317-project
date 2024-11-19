/**
 * CP317 Project
 * Authors: Josh Gelbaum, Drake Martin, Paul Matsialko, Jaden Ramcharan
 */

import java.io.File;

public class FileOpener {
    File file;

    public FileOpener(String fileName){
        try{
            this.file = new File(fileName);
        }catch (Exception e){
            System.err.println("Error: File not found");
        }
        
    }

    public File getFile(){
        return this.file;
    }
}
