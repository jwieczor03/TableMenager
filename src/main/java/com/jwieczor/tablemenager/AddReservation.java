package com.jwieczor.tablemenager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddReservation extends MenuBarController{


    @FXML
    private TextField guestsTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView<Reservation> reservationTableView;

    @FXML
    private TableColumn<Reservation, LocalTime> timeColumn;

    @FXML
    private TableColumn<Reservation, Integer> tableColumn;

    @FXML
    private Button checkAvailabilityButton;

    public void initialize() {
        // Inicjalizacja TableView
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());
        tableColumn.setCellValueFactory(cellData -> cellData.getValue().tableIdProperty().asObject());
    }

    @FXML
    private void handleCheckAvailability(ActionEvent event) {
        // Pobierz liczbę gości i datę
        int guests = Integer.parseInt(guestsTextField.getText());
        LocalDate date = datePicker.getValue();

        // Wykonaj zapytanie do bazy danych
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT startTime, tableId FROM reservations WHERE reservationDate = ? AND numberOfGuests <= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, date);
            preparedStatement.setInt(2, guests);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Wczytaj wyniki zapytania do TableView
            reservationTableView.getItems().clear();
            while (resultSet.next()) {
                LocalTime startTime = resultSet.getTime("startTime").toLocalTime();
                int tableId = resultSet.getInt("tableId");
                reservationTableView.getItems().add(new Reservation(startTime, tableId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addMenuBar(ActionEvent event) throws IOException {
        super.addMenuBar(event);
    }

    @Override
    public void findMenuBar(ActionEvent event) throws IOException {
        super.findMenuBar(event);
    }

    @Override
    public void helpMenuBar(ActionEvent event) throws IOException {
        super.helpMenuBar(event);
    }

    @Override
    public void HomeMenuBar(ActionEvent event) throws IOException {
        super.HomeMenuBar(event);
    }

    @Override
    public void printMenuBar(ActionEvent event) throws IOException {
        super.printMenuBar(event);
    }

    @Override
    public void tableMenuBar(ActionEvent event) throws IOException {
        super.tableMenuBar(event);
    }



}
