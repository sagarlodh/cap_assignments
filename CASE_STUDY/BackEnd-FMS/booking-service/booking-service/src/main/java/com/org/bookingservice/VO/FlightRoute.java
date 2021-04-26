package com.org.bookingservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightRoute {

    private Flight flight;
    private Airport source_Airport;
    private Airport destination_Airport;
}
