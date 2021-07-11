/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Orion Kinsler
 */

package ucf.assignments;

public class FileManager {
    //Create pointer to file

    public String readFile(String fileName){
        //Locate file using fileName
        //If file is not found create file
        //Read text in file to String
        //Close file
        //Return String
        return "String";
    }

    public void exportFile(String fileName, String fileText){
        //Locate file using fileName
        //If file is not found create file
        //Write fileText to file
        //Close file
    }

    public void renameFile(String fileName, String newName){
        //Locate file using fileName
        //Change name of file to newName
        //Close file
    }

    public void createFile(String fileName){
        //Locate file using fileName
        //If no file found create file using fileName
    }

    public void deleteFile(String fileName){
        //Locate file using fileName
        //If no file found return
        //Delete file with name equal to fileName
    }
}