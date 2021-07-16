/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Orion Kinsler
 */

package ucf.assignments;

import java.io.*;
import java.util.Scanner;


public class FileManager {

    public String readFile(String fileName) throws FileNotFoundException {
        //Locate file using fileName
        File fileInput = new File(fileName);
        //Return nothing if file does not exist
        if (!fileInput.exists()){
            return "";
        }
        //Create File Scanner
        Scanner fileReader = new Scanner(fileInput);
        String output  = new String();
        //Read text in file to String
        while (fileReader.hasNextLine()) {
            output += fileReader.nextLine();
        }
        //Close file
        fileReader.close();
        //Return String
        return output;
    }

    public void exportFile(String fileName, String fileText) throws IOException {
        //Locate file using fileName
        File fileInput = new File(fileName);
        //Create File Scanner
        FileWriter fileWriter = new FileWriter(fileInput);
        //Delete and create new file
        if (fileInput.exists()){
            fileInput.delete();
        }
        fileInput.createNewFile();
        //Write fileText to file
        fileWriter.write(fileText);
        //Close file
        fileWriter.close();
    }
}