/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Orion Kinsler
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class MainApp{// extends Application{
    /*@Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainApp.fxml")));

        Scene appScene = new Scene(root);

        primaryStage.setTitle("TODO List");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(appScene);
        primaryStage.show();
    }*/

    public static void main(String[] args) throws IOException {
        ListManager lManager = new ListManager();
        lManager.exportList();
        //MainApp.launch(args);
    }
}