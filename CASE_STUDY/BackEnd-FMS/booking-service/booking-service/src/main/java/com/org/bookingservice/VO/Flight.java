package com.org.bookingservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flight {

    private Long flightId;
    private String flightNo;
    private String carrier;
    private Long seatingCapacity;
    private Long srcAirportId;
    private Long destAirportId;
}
