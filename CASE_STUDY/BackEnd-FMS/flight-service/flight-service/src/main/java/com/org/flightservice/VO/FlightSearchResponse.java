package com.org.flightservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightSearchResponse {

    private Long flightId;
    private String flightNo;
    private String carrier;
    private Long seatingCapacity;
    private String srcAirportName;
    private String destAirportName;
}
