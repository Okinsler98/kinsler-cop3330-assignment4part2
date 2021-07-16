/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Orion Kinsler
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GuiManager {
    ListManager lManager = new ListManager();

    @FXML private TextField itemBox;
    @FXML private TextField descBox;
    @FXML private TextField dateViewer;
    @FXML private DatePicker dateSelector;
    @FXML private ListView<String> itemView;
    @FXML private ListView<String> dateView;
    @FXML private TextField directBox;
    @FXML private CheckBox completeCheck;

    private int itemSelected = 0;

    @FXML
    public void createNewListItem(){
        //Create new item with default values
        lManager.createItem("New Task", "Default Task Description", "");

        //Clear and refill items list
        itemView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            itemView.getItems().add(lManager.items.get(i).name);
        }
        //Clear and refill dates list
        dateView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            dateView.getItems().add(lManager.items.get(i).dueDate);
        }
    }

    @FXML
    public void updateItem(){
        lManager.editItemName(itemSelected, itemBox.getText());
        lManager.editItemDescription(itemSelected, descBox.getText());
        if (dateSelector.getValue() != null){
            lManager.editItemDate(itemSelected, dateSelector.getValue().getYear() + "-" + dateSelector.getValue().getMonthValue() + "-" + dateSelector.getValue().getDayOfMonth());
        }

        //Clear and refill items list
        itemView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            itemView.getItems().add(lManager.items.get(i).name);
        }

        //Clear and refill dates list
        dateView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            dateView.getItems().add(lManager.items.get(i).dueDate);
        }
        lManager.changeItemStatus(itemSelected, completeCheck.selectedProperty().get());
    }

    @FXML
    public void getDirectory() {
        //get file from directory box
        lManager.fileDir = directBox.getText();
    }

    @FXML
    public void saveButton() throws IOException {
        //get file from directory box
        lManager.fileDir = directBox.getText();
        //export file
        lManager.exportList();
    }

    @FXML
    public void importButton() throws FileNotFoundException {
        //get file from directory box
        lManager.fileDir = directBox.getText();
        //import file
        lManager.importList();
    }

    @FXML
    public void deleteButton() {
        //delete selected item in array
        lManager.deleteItem(itemSelected);

        //Clear and refill items list
        itemView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            itemView.getItems().add(lManager.items.get(i).name);
        }

        //Clear and refill date list
        dateView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            dateView.getItems().add(lManager.items.get(i).dueDate);
        }
    }

    @FXML
    public void clearButton() {
        //Delete item list array
        for (int i = 0; i < lManager.items.size() ; i++){
            lManager.deleteItem(i);
        }
        //clear list view
        itemView.getItems().clear();
        dateView.getItems().clear();

    }

    @FXML
    public void itemSelection() {
        //Get selected listview selected item
        itemSelected = itemView.getSelectionModel().getSelectedIndex();

        //update info for selected item
        itemBox.setText(lManager.items.get(itemSelected).name);
        descBox.setText(lManager.items.get(itemSelected).description);
        dateViewer.setText(lManager.items.get(itemSelected).dueDate);
        completeCheck.setSelected(lManager.items.get(itemSelected).status);
    }

    @FXML
    public void sortCompete() {
        //Clear and refill complete items list
        itemView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            if (lManager.items.get(i).status){
                itemView.getItems().add(lManager.items.get(i).name);
            }
        }

        //Clear and refill date list
        dateView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            if (lManager.items.get(i).status){
                dateView.getItems().add(lManager.items.get(i).dueDate);
            }
        }
    }

    @FXML
    public void sortIncomplete() {
        //Clear and refill incomplete items list
        itemView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            if (!lManager.items.get(i).status){
                itemView.getItems().add(lManager.items.get(i).name);
            }
        }

        //Clear and refill date list
        dateView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            if (!lManager.items.get(i).status){
                dateView.getItems().add(lManager.items.get(i).dueDate);
            }
        }
    }

    @FXML
    public void refreshList() {
        //Clear and refill items list
        itemView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            itemView.getItems().add(lManager.items.get(i).name);
        }

        //Clear and refill date list
        dateView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            dateView.getItems().add(lManager.items.get(i).dueDate);
        }
    }
}