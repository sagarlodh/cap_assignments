package com.org.flightservice.Services;

import com.org.flightservice.Config.SequenceGeneratorService;
import com.org.flightservice.Exceptions.RecordAlreadyPresentException;
import com.org.flightservice.Exceptions.RecordNotFoundException;
import com.org.flightservice.Models.Flight;
import com.org.flightservice.Models.FlightSearch;
import com.org.flightservice.Repos.FlightRepo;
import com.org.flightservice.VO.Airport;
import com.org.flightservice.VO.FlightRoute;
import com.org.flightservice.VO.FlightSearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService{
    /**
     * BUSINESS METHOD IMPLEMENTATIONS
     */

    @Autowired
    private FlightRepo flightRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    /**
     * @param newFlight
     * @return CREATES A FLIGHT
     */
    @Override
    public String createFlight(Flight newFlight) {
        Optional<Flight> existingFlight = Optional.ofNullable(flightRepo.findFlightByFlightNo(newFlight.getFlightNo()));
        if(existingFlight.isEmpty()){
            newFlight.setFlightId(sequenceGeneratorService.generateSequence(Flight.SEQUENCE_NAME));
            flightRepo.save(newFlight);
            return "You have successfully created a Flight with Flight-No: " + newFlight.getFlightNo();
        } else {
            throw new RecordAlreadyPresentException("Please Enter Unique Flight No!" + " " +
                    "Flight already exists with Flight-No: " + newFlight.getFlightNo());
        }
    }



    /**
     * @param flightId
     * @return UPDATES SPECIFIC FLIGHT WITH GIVEN FLIGHT-ID
     */
    @Override
    public String updateFlight(Long flightId) {
        return null;
    }



    /**
     *
     * @param flightId
     * @return DELETES FLIGHT WITH SPECIFIC FLIGHT-ID
     */
    @Override
    public String deleteFlight(Long flightId) {
        Flight existingFlight = flightRepo.findById(flightId).orElseThrow(() ->
                new RecordNotFoundException("Flight does not exist with Id: [" + flightId + "] ,Please Enter Valid ID!"));
        flightRepo.delete(existingFlight);
        return "Flight deleted with Id: " + flightId;
    }



    /**
     * @return A LIST OF ALL FLIGHTS
     */
    @Override
    public Iterable<Flight> displayAllFlights() { return flightRepo.findAll(); }



    /**
     *
     * @param flightId
     * @return FLIGHT WITH SPECIFIC FLIGHT-ID
     */
    @Override
    public Flight findFlightById(Long flightId) {
        return flightRepo.findById(flightId).orElseThrow(() -> new RecordNotFoundException
                ("Airport does not exist with Id: [" + flightId + "] ,Please Enter Valid ID!"));
    }



    /****************************** CUSTOM CRITERIA FROM REPO IMPLEMENTED *****************************/

    /**
     * @param carrierName
     * @return A LIST OF ALL FLIGHTS BY A SPECIFIC-CARRIER
     */
    @Override
    public Iterable<Flight> getFlightsByCarrier(String carrierName) {
        return flightRepo.findFlightByCarrier(carrierName);
    }



    /****************************** RETURNABLE ENTITIES SERVICE IMPLEMENTED *****************************/

    /**
     * @param flightId
     * @return THE ROUTE OF THE FLIGHT WITH SPECIFIC FLIGHT-ID
     */
    @Override
    public FlightRoute getFlightRoute(Long flightId) {

        // TODO: check if flight exists whose route is fetched
        Flight existingFlight = flightRepo.findById(flightId).orElseThrow(() -> new RecordNotFoundException
                ("Flight does not exist with Id: [" + flightId + "] ,Please Enter Valid ID!"));

        // TODO: get the source airport for the flight
        Airport sourceAirport = restTemplate.getForObject(
                "http://AIRPORT-SERVICE/airports/search-airport/" + existingFlight.getSrcAirportId(),Airport.class);

        // TODO: get the destination airport for the flight
        Airport destinationAirport = restTemplate.getForObject(
                "http://AIRPORT-SERVICE/airports/search-airport/" + existingFlight.getDestAirportId(),Airport.class);

        // TODO: preparing the response
        FlightRoute flightRoute = new FlightRoute();
        flightRoute.setFlight(existingFlight);
        flightRoute.setSource_Airport(sourceAirport);
        flightRoute.setDestination_Airport(destinationAirport);

        // TODO: return the response
        return flightRoute;
    }

    /**
     * @param flightSearch
     * @return THE FLIGHT DETAILS AS PER SEARCHED BY CUSTOMER
     */
    @Override
    public Optional<FlightSearchResponse> flightSearch(FlightSearch flightSearch) {

        // TODO: checking if both source and destination are different or not
        if(!flightSearch.getSourceAirport().equals(flightSearch.getDestinationAirport())) {

            // TODO: GETTING SOURCE AIRPORT
            Airport sourceAirport = restTemplate.getForObject(
                    "http://AIRPORT-SERVICE/airports/airport-search-by-loc/" + flightSearch.getSourceAirport(), Airport.class);

            // TODO: GETTING DESTINATION AIRPORT
            Airport destinationAirport = restTemplate.getForObject(
                    "http://AIRPORT-SERVICE/airports/airport-search-by-loc/" + flightSearch.getDestinationAirport(), Airport.class);

            // TODO: finding flight by SOURCE AIRPORT ID
            Flight flightsSearchList = flightRepo.findFlightBySrcAirportId(sourceAirport.getAirportId());

            // TODO: preparing the RESPONSE
            FlightSearchResponse flightSearchResponse = new FlightSearchResponse();

            // TODO: CHECKING IF DESTINATION AIRPORT ID OF FLIGHT === FETCHED FLIGHT
            Long dstAirportId = flightsSearchList.getDestAirportId();
            Long dstAirportCheckAirportId = destinationAirport.getAirportId();

            // TODO: if destination is same and as required
            if (dstAirportId.equals(dstAirportCheckAirportId)) {

                // TODO: setting the response
                flightSearchResponse.setFlightId(flightsSearchList.getFlightId());
                flightSearchResponse.setFlightNo(flightsSearchList.getFlightNo());
                flightSearchResponse.setCarrier(flightsSearchList.getCarrier());
                flightSearchResponse.setSeatingCapacity(flightsSearchList.getSeatingCapacity());
                flightSearchResponse.setSrcAirportName(sourceAirport.getAirportName());
                flightSearchResponse.setDestAirportName(destinationAirport.getAirportName());
            }
            // TODO: return the SEARCH RESPONSE
            return Optional.of(flightSearchResponse);

        } else if(flightSearch.getSourceAirport().equals(flightSearch.getDestinationAirport())){
            // TODO: if same source and destination then return error with message
            throw new RecordNotFoundException("Destination should not be same! Please enter different Destination.");
        } else {
            // TODO: or throw no flights found if no flights
            throw new RecordNotFoundException("No Flights Found");
        }
    }
}
