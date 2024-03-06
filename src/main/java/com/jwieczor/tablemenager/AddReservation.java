package com.jwieczor.tablemenager;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddReservation extends MenuBarController {

    public TextField tableId;
    public TextField guestFirstName;
    public TextField guestLastName;
    public TextField guestPhoneNumber;
    public TextField numberOfGuests;
    public DatePicker reservationDate;
    public TextField startTime;
    public TextArea notesAdd;
    public Label infoLabel;

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

    public void addReservation(ActionEvent event) {
        String tableIdValue = tableId.getText();
        String firstName = guestFirstName.getText();
        String lastName = guestLastName.getText();
        String phoneNumber = guestPhoneNumber.getText();
        String guestsCount = numberOfGuests.getText();
        String date = reservationDate.getValue().toString();
        String startTimeValue = startTime.getText();
        String notes = notesAdd.getText();

        // Calculate end time
        // Convert start time to seconds
        String[] startTimeParts = startTimeValue.split(":");
        int hours = Integer.parseInt(startTimeParts[0]);
        int minutes = Integer.parseInt(startTimeParts[1]);
        int seconds = Integer.parseInt(startTimeParts[2]);
        int totalSeconds = hours * 3600 + minutes * 60 + seconds;
        // Add 2 hours (7200 seconds)
        totalSeconds += 7200;
        // Convert back to hours:minutes:seconds format
        int endHours = totalSeconds / 3600;
        totalSeconds %= 3600;
        int endMinutes = totalSeconds / 60;
        int endSeconds = totalSeconds % 60;
        String endTimeValue = String.format("%02d:%02d:%02d", endHours, endMinutes, endSeconds);

        try {
            Connection connection = DatabaseConnector.getConnection();
            String query = "INSERT INTO Reservations (table_id, guest_first_name, guest_last_name, guest_phone_number, number_of_guests, reservation_date, start_time, end_time, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, tableIdValue);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, guestsCount);
            preparedStatement.setString(6, date);
            preparedStatement.setString(7, startTimeValue);
            preparedStatement.setString(8, endTimeValue);
            preparedStatement.setString(9, notes);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int reservationId = generatedKeys.getInt(1);
                    infoLabel.setTextFill(javafx.scene.paint.Color.GREEN);
                    infoLabel.setText("Dodano! Id rezerwacji: " + reservationId);
                }
            } else {
                infoLabel.setTextFill(javafx.scene.paint.Color.RED);
                infoLabel.setText("Błąd podczas dodawania rezerwacji.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            infoLabel.setTextFill(javafx.scene.paint.Color.RED);
            infoLabel.setText("Błąd podczas dodawania rezerwacji.");
        }
    }
}
