package com.org.flightservice.Repos;

import com.org.flightservice.Models.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends MongoRepository<Flight, Long> {
    /**
     * CUSTOM SEARCH CRITERIAS TO BE USED
     */
    Flight findFlightByFlightNo(String flightNo);
    Iterable<Flight> findFlightByCarrier(String carrier_Name);

    /**
     * USED FOR SEARCH OPTION
     */
    Flight findFlightBySrcAirportId(Long srcAirportId);
}
