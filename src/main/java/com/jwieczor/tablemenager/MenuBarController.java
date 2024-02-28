package com.jwieczor.tablemenager;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ContextMenu;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

import java.io.IOException;

public class MenuBarController {

    public void addMenuBar(ActionEvent event) throws IOException {
        MenuItem menuItem = (MenuItem) event.getSource();
        ContextMenu contextMenu = menuItem.getParentPopup();
        Stage stage = (Stage) contextMenu.getOwnerWindow();

        Parent root = FXMLLoader.load(getClass().getResource("addReservation.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.show();
    }

    public void HomeMenuBar(ActionEvent event) throws IOException {
        MenuItem menuItem = (MenuItem) event.getSource();
        ContextMenu contextMenu = menuItem.getParentPopup();
        Stage stage = (Stage) contextMenu.getOwnerWindow();

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.show();
    }

    public void findMenuBar(ActionEvent event) throws IOException {
        MenuItem menuItem = (MenuItem) event.getSource();
        ContextMenu contextMenu = menuItem.getParentPopup();
        Stage stage = (Stage) contextMenu.getOwnerWindow();

        Parent root = FXMLLoader.load(getClass().getResource("findReservation.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.show();
    }

    public void helpMenuBar(ActionEvent event) throws IOException {
        MenuItem menuItem = (MenuItem) event.getSource();
        ContextMenu contextMenu = menuItem.getParentPopup();
        Stage stage = (Stage) contextMenu.getOwnerWindow();

        Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.show();
    }

    public void printMenuBar(ActionEvent event) throws IOException {
        MenuItem menuItem = (MenuItem) event.getSource();
        ContextMenu contextMenu = menuItem.getParentPopup();
        Stage stage = (Stage) contextMenu.getOwnerWindow();

        Parent root = FXMLLoader.load(getClass().getResource("printReservation.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.show();
    }

    public void tableMenuBar(ActionEvent event) throws IOException {
        MenuItem menuItem = (MenuItem) event.getSource();
        ContextMenu contextMenu = menuItem.getParentPopup();
        Stage stage = (Stage) contextMenu.getOwnerWindow();

        Parent root = FXMLLoader.load(getClass().getResource("table.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.show();
    }
}
