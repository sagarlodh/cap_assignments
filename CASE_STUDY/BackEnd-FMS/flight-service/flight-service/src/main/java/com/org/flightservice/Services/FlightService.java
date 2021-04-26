package com.org.flightservice.Services;

import com.org.flightservice.Models.Flight;
import com.org.flightservice.Models.FlightSearch;
import com.org.flightservice.VO.FlightRoute;
import com.org.flightservice.VO.FlightSearchResponse;

import java.util.Optional;

public interface FlightService {
    /**
     * BUSINESS METHODS
     */
    String createFlight(Flight newFlight);
    String updateFlight(Long flightId);
    String deleteFlight(Long flightId);
    Iterable<Flight> displayAllFlights();
    Flight findFlightById(Long flightId);
    Iterable<Flight> getFlightsByCarrier(String carrierName);
    FlightRoute getFlightRoute(Long flightId);

    Optional<FlightSearchResponse> flightSearch(FlightSearch flightSearch);
}
