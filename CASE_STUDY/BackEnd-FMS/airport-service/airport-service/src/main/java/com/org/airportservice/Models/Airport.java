package com.org.airportservice.Models;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document(collection = "Airports")
public class Airport {

    /**
     * SEQUENCE GENERATOR NAME
     */
    @Transient
    public static final String SEQUENCE_NAME = "airports_sequence";

    /**
     * DATA
     */
    @Id
    private Long airportId;
    @Indexed(unique = true)
    private String airportCode;
    private  String airportName;
    private String airportLocation;

    /**
     * PARAMETERIZED CONSTRUCTOR
     */
    public Airport(String airportCode,String airportName, String airportLocation) {
        super();
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.airportLocation = airportLocation;
    }

    /**
     * GETTERS & SETTERS
     */
    public Long getAirportId() { return airportId; }
    public void setAirportId(Long airportId) { this.airportId = airportId; }

    public String getAirportCode() { return airportCode; }
    public void setAirportCode(String airportCode) { this.airportCode = airportCode; }

    public String getAirportName() { return airportName; }
    public void setAirportName(String airport_Name) { this.airportName = airport_Name; }

    public String getAirportLocation() { return airportLocation; }
    public void setAirportLocation(String airport_Location) { this.airportLocation = airport_Location; }
}


