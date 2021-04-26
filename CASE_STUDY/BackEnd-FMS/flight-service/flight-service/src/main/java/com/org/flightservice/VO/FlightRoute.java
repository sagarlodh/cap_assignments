package com.org.flightservice.VO;

import com.org.flightservice.Models.Flight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightRoute {

    /**
     * data
     */
    private Flight flight;
    private Airport source_Airport;
    private Airport destination_Airport;

}
