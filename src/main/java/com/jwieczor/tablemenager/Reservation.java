package com.jwieczor.tablemenager;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private IntegerProperty reservationId = new SimpleIntegerProperty();
    private IntegerProperty tableId = new SimpleIntegerProperty();
    private StringProperty guestFirstName = new SimpleStringProperty();
    private StringProperty guestLastName = new SimpleStringProperty();
    private StringProperty guestPhoneNumber = new SimpleStringProperty();
    private IntegerProperty numberOfGuests = new SimpleIntegerProperty();
    private ObjectProperty<LocalDate> reservationDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalTime> startTime = new SimpleObjectProperty<>();
    private ObjectProperty<LocalTime> endTime = new SimpleObjectProperty<>();
    private StringProperty notes = new SimpleStringProperty();

    public Reservation(LocalTime startTime, int tableId) {
        this.startTime.set(startTime);
        this.tableId.set(tableId);
    }

    public int getReservationId() {
        return reservationId.get();
    }

    public IntegerProperty reservationIdProperty() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId.set(reservationId);
    }

    public int getTableId() {
        return tableId.get();
    }

    public IntegerProperty tableIdProperty() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId.set(tableId);
    }

    public String getGuestFirstName() {
        return guestFirstName.get();
    }

    public StringProperty guestFirstNameProperty() {
        return guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName.set(guestFirstName);
    }

    public String getGuestLastName() {
        return guestLastName.get();
    }

    public StringProperty guestLastNameProperty() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName.set(guestLastName);
    }

    public String getGuestPhoneNumber() {
        return guestPhoneNumber.get();
    }

    public StringProperty guestPhoneNumberProperty() {
        return guestPhoneNumber;
    }

    public void setGuestPhoneNumber(String guestPhoneNumber) {
        this.guestPhoneNumber.set(guestPhoneNumber);
    }

    public int getNumberOfGuests() {
        return numberOfGuests.get();
    }

    public IntegerProperty numberOfGuestsProperty() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests.set(numberOfGuests);
    }

    public LocalDate getReservationDate() {
        return reservationDate.get();
    }

    public ObjectProperty<LocalDate> reservationDateProperty() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate.set(reservationDate);
    }

    public LocalTime getStartTime() {
        return startTime.get();
    }

    public ObjectProperty<LocalTime> startTimeProperty() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime.set(startTime);
    }

    public LocalTime getEndTime() {
        return endTime.get();
    }

    public ObjectProperty<LocalTime> endTimeProperty() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime.set(endTime);
    }

    public String getNotes() {
        return notes.get();
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }


}
