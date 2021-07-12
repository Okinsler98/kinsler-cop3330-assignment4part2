/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Orion Kinsler
 */

package ucf.assignments;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ListManager {
    ArrayList<ListItem> items = new ArrayList();
    FileManager fManager = new FileManager();
    Gson gson = new Gson();
    String fileDir = new String();

    public void importList() throws FileNotFoundException {
        String inputJson = fManager.readFile(fileDir);
        ListItem item = new ListItem();
        JsonArray array = JsonParser.parseString(inputJson).getAsJsonArray();
        for (int i = 0; i < array.size(); i++){
            items.set(i, gson.fromJson(array.get(i), ListItem.class));
        }
    }

    public void exportList() throws IOException {
        String output = new String();

        //convert collection to string
        for (int i = 0; i < items.size(); i++){
            output = gson.toJson(items);
        }
        //use fileManager to export string to file
        fManager.exportFile(fileDir, output);
    }

    public void createItem(String name, String description, String dueDate){
        ListItem item = new ListItem();
        item.name = name;
        item.description = description;
        item.status = false;
        item.dueDate = dueDate;

        items.add(item);
    }

    public void deleteItem(int listItem){
        //Locate item in collection using listItem integer
        //Remove item from collection
        items.remove(listItem);
    }

    public void changeItemStatus(int listItem){
        //Locate item in collection using listItem integer
        //invert boolean state of status
        items.get(listItem).changeStatus();
    }

    public void editItemName(int listItem, String newName){
        //Locate item in collection using listItem integer
        //change item name
        items.get(listItem).updateName(newName);
    }

    public void editItemDate(int listItem, String newDate){
        //Locate item in collection using listItem integer
        //change item due date
        items.get(listItem).updateDueDate(newDate);
    }

    public void editItemDescription(int listItem, String newDesc){
        //Locate item in collection using listItem integer
        //change item description
        items.get(listItem).updateDescription(newDesc);
    }

    public void sortList(){
        //Sort collection by date
    }
}