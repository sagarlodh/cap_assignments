package com.org.bookingservice.Models;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document(collection = "Bookings")
public class Booking {

    /**
     * SEQUENCE GENERATOR NAME
     */
    @Transient
    public static final String SEQUENCE_NAME = "bookings_sequence";

    /**
     * DATA
     */
    @Id
    private Long bookingId;
    private String uniqueCode;
    private String bookingDate;
    private Long userId;
    private int noOfPassengers;
    private Long flightId;

    /**
     * PARAMETERIZED CONSTRUCTOR
     */
    public Booking(String uniqueCode,String bookingDate, Long userId, int noOfPassengers, Long flightId) {
        super();
        this.uniqueCode = uniqueCode;
        this.bookingDate = bookingDate;
        this.userId = userId;
        this.noOfPassengers = noOfPassengers;
        this.flightId = flightId;
    }

    /**
     * GETTERS & SETTERS
     */
    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public String getUniqueCode() { return uniqueCode; }
    public void setUniqueCode(String uniqueCode) { this.uniqueCode = uniqueCode; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public int getNoOfPassengers() { return noOfPassengers; }
    public void setNoOfPassengers(int noOfPassengers) { this.noOfPassengers = noOfPassengers; }

    public Long getFlightId() { return flightId; }
    public void setFlightId(Long flightId) { this.flightId = flightId; }
}
