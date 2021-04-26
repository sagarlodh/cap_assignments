package com.org.airportservice.Repos;

import com.org.airportservice.Models.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepo extends MongoRepository<Airport, Long> {
    /**
     * CUSTOM SEARCH CRITERIAS TO BE USED
     */
    Airport findAirportByAirportCode(String airport_Code);
    Iterable<Airport> findAirportByAirportLocation(String airport_Loc);
    Airport findAirportByAirportName(String airport_Name);

    /* only for search */
    Airport getAirportByAirportLocation(String airport_Loc);
}
