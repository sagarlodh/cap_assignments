package com.org.flightservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightSearch {

    private String sourceAirport;
    private String destinationAirport;


}