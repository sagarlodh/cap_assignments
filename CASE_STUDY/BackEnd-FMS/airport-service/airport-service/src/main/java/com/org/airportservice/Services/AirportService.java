package com.org.airportservice.Services;

import com.org.airportservice.Models.Airport;

import java.util.Optional;

public interface AirportService {
    /**
     * BUSINESS METHODS
     */
    String createAirport(Airport newAirport);
    String updateAirport(Long airportId);
    String deleteAirport(Long airportId);
    Iterable<Airport> displayAllAirports();
    Airport findAirportById(Long airportId);
    Iterable<Airport> getAirportsByLocation(String airportLocation);
    Optional<Airport> getAirportByName(String airportName);

    Airport getAirportByAirportLocation(String airportLocation);
}

