package com.org.bookingservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Airport {

    private Long airportId;
    private String airportCode;
    private  String airportName;
    private String airportLocation;

}
