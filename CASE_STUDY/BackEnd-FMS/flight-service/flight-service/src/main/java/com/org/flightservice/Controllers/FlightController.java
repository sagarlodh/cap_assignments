package com.org.flightservice.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.flightservice.Exceptions.RecordNotFoundException;
import com.org.flightservice.Models.Flight;
import com.org.flightservice.Models.FlightSearch;
import com.org.flightservice.Repos.FlightRepo;
import com.org.flightservice.Services.FlightService;
import com.org.flightservice.Services.FlightServiceImpl;
import com.org.flightservice.VO.FlightRoute;
import com.org.flightservice.VO.FlightSearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@ComponentScan(basePackages = "com.org.flightservice")
@RestController
@RequestMapping("/flights")
@Slf4j
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    FlightRepo flightRepo;

    /**
     * CREATE FLIGHT ENDPOINT
     */
    @HystrixCommand
    @PostMapping("/create-flight")
    public String createFlight(@RequestBody Flight newFlight){
        log.info("Flight created with payload: " + newFlight);
        return flightService.createFlight(newFlight); }

    /**
     * UPDATE FLIGHT ENDPOINT
     */
    @HystrixCommand
    @PutMapping("/update-flight/{id}")
    public String updateFlight(@RequestBody Flight updatedFlight, @PathVariable("id") Long flightId){
        log.info("Update Flight called with ID: " + flightId);
        Flight existingFlight = flightRepo.findById(flightId)
                                          .orElseThrow(() -> new RecordNotFoundException(
                                                  "Flight does not exist with Id: [" + flightId + "] ,Please Enter Valid ID!"));
        existingFlight.setFlightNo(updatedFlight.getFlightNo());
        existingFlight.setCarrier(updatedFlight.getCarrier());
        existingFlight.setSeatingCapacity(updatedFlight.getSeatingCapacity());
        existingFlight.setSrcAirportId(updatedFlight.getSrcAirportId());
        existingFlight.setDestAirportId(updatedFlight.getDestAirportId());
        flightRepo.save(existingFlight);
        return "Flight Updated with Flight-Id: [" + flightId + "]";
    }

    /**
     * DELETE FLIGHT ENDPOINT
     */
    @HystrixCommand
    @DeleteMapping("/delete-flight/{id}")
    public String deleteFlightById(@PathVariable("id") Long flightId){
        log.info("Delete Flight called with ID: " + flightId);
        return flightService.deleteFlight(flightId);
    }

    /**
     * GET ALL FLIGHTS ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/get-all-flights")
    public Iterable<Flight> getAllFlights(){
        log.info("Get All flights called...");
        return flightService.displayAllFlights();
    }

    /**
     * SEARCH FLIGHT ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/search-flight/{id}")
    public Flight getFlightById(@PathVariable("id") Long flightId) {
        log.info("Search Flight called with ID: " + flightId);
        return flightService.findFlightById(flightId);
    }

    /**
     * SEARCH FLIGHT-BY-CARRIER ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/search-flight-by-carrier/{carrier_name}")
    public Iterable<Flight> getFlightByCarrier(@PathVariable("carrier_name") String carrier){
        log.info("Search Flight-By-Carrier called with Carrier: " + carrier);
        return flightService.getFlightsByCarrier(carrier);
    }

    /**
     * GET FLIGHT-ROUTE ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/flight-route/{id}")
    public FlightRoute getFlightRouteDetails(@PathVariable("id") Long flightId){
        log.info("Get Flight-Route called with ID: " + flightId);
        return flightService.getFlightRoute(flightId);
    }

    /**
     * CUSTOMERS SEARCH FLIGHT ENDPOINT ACCESSING THE AIRPORT SERVICE TOO
     */
    @HystrixCommand
    @PostMapping("/flight-search")
    public Optional<FlightSearchResponse> flightSearch(@RequestBody FlightSearch flightSearch){
        log.info("Customers searched flights with \n Source Airport: " + flightSearch.getSourceAirport()
         + "\n Destination Airport: " + flightSearch.getDestinationAirport());
        log.info(String.valueOf(flightService.flightSearch(flightSearch)));
        return flightService.flightSearch(flightSearch);
    }

}
