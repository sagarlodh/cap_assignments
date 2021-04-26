package com.org.flightservice.Models;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document(collection = "Flights")
public class Flight {

    /**
     * SEQUENCE GENERATOR NAME
     */
    @Transient
    public   static final String SEQUENCE_NAME = "flights_sequence";

    /**
     * DATA
     */
    @Id
    private Long flightId;
    @Indexed(unique = true)
    private String flightNo;
    private String carrier;
    private Long seatingCapacity;
    private Long srcAirportId;
    private Long destAirportId;

    /**
     * PARAMETERIZED CONSTRUCTOR
     */
    public Flight(String flightNo,String carrier, Long seatingCapacity, Long srcAirportId, Long destAirportId) {
        super();
        this.flightNo = flightNo;
        this.carrier = carrier;
        this.seatingCapacity = seatingCapacity;
        this.srcAirportId = srcAirportId;
        this.destAirportId = destAirportId;
    }

    /**
     * GETTERS & SETTERS
     */
    public Long getFlightId() { return flightId; }
    public void setFlightId(Long flightId) { this.flightId = flightId; }

    public String getFlightNo() { return flightNo; }
    public void setFlightNo(String flightNo) { this.flightNo = flightNo; }

    public String getCarrier() { return carrier; }
    public void setCarrier(String carrier) { this.carrier = carrier; }

    public Long getSeatingCapacity() { return seatingCapacity; }
    public void setSeatingCapacity(Long seatingCapacity) { this.seatingCapacity = seatingCapacity; }

    public Long getSrcAirportId() { return srcAirportId; }
    public void setSrcAirportId(Long srcAirportId) { this.srcAirportId = srcAirportId; }

    public Long getDestAirportId() { return destAirportId; }
    public void setDestAirportId(Long destAirportId) { this.destAirportId = destAirportId; }
}
