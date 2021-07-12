/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Orion Kinsler
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.event.Event;
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
    @FXML private ListView listView;
    @FXML private TextField directBox;
    @FXML private CheckBox completeCheck;
    private int itemSelected = 0;

    @FXML
    public void createNewListItem(ActionEvent event){
        lManager.createItem("New Task", "Default Description", "2021-11-07");
        listView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            listView.getItems().add(lManager.items.get(i).name);
        }
    }

    @FXML
    public void submitButton(Event e){
        lManager.editItemName(itemSelected, itemBox.getText());
        lManager.editItemDescription(itemSelected, descBox.getText());
        lManager.editItemDate(itemSelected, dateSelector.getValue().getYear() + "-" + dateSelector.getValue().getMonthValue() + "-" + dateSelector.getValue().getDayOfMonth());
        listView.getItems().clear();
        for (int i = 0; i < lManager.items.size(); i++){
            listView.getItems().add(lManager.items.get(i).name);
        }
    }

    @FXML
    public void getDirectory(Event e) {
        lManager.fileDir = directBox.getText();
    }

    @FXML
    public void saveButton(Event e) throws IOException {
        lManager.fileDir = directBox.getText();
        lManager.exportList();
    }

    @FXML
    public void importButton(Event e) throws FileNotFoundException {
        lManager.fileDir = directBox.getText();
        lManager.importList();
    }

    @FXML
    public void clearButton(Event e) throws FileNotFoundException {
        for (int i = 0; i < lManager.items.size() ; i++){
            lManager.deleteItem(i);
        }
        listView.getItems().clear();
    }

    @FXML
    public void nextItem(Event e) throws FileNotFoundException {
        itemSelected++;
        if (itemSelected > lManager.items.size()){
            itemSelected = lManager.items.size();
        }
        itemBox.setText(lManager.items.get(itemSelected).name);
        descBox.setText(lManager.items.get(itemSelected).description);
        dateViewer.setText(lManager.items.get(itemSelected).dueDate);
        completeCheck.setSelected(lManager.items.get(itemSelected).status);
    }

    @FXML
    public void prevItem(Event e) throws FileNotFoundException {
        itemSelected--;
        if (itemSelected < 0){
            itemSelected = 0;
        }
        itemBox.setText(lManager.items.get(itemSelected).name);
        descBox.setText(lManager.items.get(itemSelected).description);
        dateViewer.setText(lManager.items.get(itemSelected).dueDate);
        completeCheck.setSelected(lManager.items.get(itemSelected).status);
    }

    @FXML
    public void changeStatus(Event e) throws FileNotFoundException {
        lManager.changeItemStatus(itemSelected);
    }


}