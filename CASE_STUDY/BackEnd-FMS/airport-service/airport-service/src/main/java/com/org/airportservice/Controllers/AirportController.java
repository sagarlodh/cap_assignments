package com.org.airportservice.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.airportservice.Exceptions.RecordNotFoundException;
import com.org.airportservice.Models.Airport;
import com.org.airportservice.Repos.AirportRepo;
import com.org.airportservice.Services.AirportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@ComponentScan(basePackages = "com.org.airportservice")
@RestController
@RequestMapping("/airports")
@Slf4j
public class AirportController {


    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportRepo airportRepo;

    /**
     * CREATE AIRPORT ENDPOINT
     */
    @HystrixCommand
    @PostMapping("/create-airport")
    public String createAirport(@RequestBody Airport newAirport){
        log.info("Airport created with payload: " + newAirport);
        return airportService.createAirport(newAirport);
    }

    /**
     * UPDATE AIRPORT ENDPOINT
     */
    @HystrixCommand
    @PutMapping("/update-airport/{id}")
    public String updateAirport(@RequestBody Airport updatedAirport, @PathVariable("id") Long airportId){
        log.info("Update Airport called with ID: " + airportId);
        Airport existingAirport = airportRepo.findById(airportId)
                                             .orElseThrow(() -> new RecordNotFoundException(
                                                     "Airport does not exist with Id: [" + airportId + "] ,Please Enter Valid ID!"));
        existingAirport.setAirportCode(updatedAirport.getAirportCode());
        existingAirport.setAirportName(updatedAirport.getAirportName());
        existingAirport.setAirportLocation(updatedAirport.getAirportLocation());
        airportRepo.save(existingAirport);
        return "Updated Airport with Airport-Id: [" + airportId + "]";
    }

    /**
     * DELETE AIRPORT ENDPOINT
     */
    @HystrixCommand
    @DeleteMapping("/delete-airport/{id}")
    public String deleteAirportById(@PathVariable("id") Long airportId){
        log.info("Delete Airport called with ID: " + airportId);
        return airportService.deleteAirport(airportId);
    }

    /**
     * GET ALL AIRPORTS ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/get-all-airports")
    public Iterable<Airport> getAllAirports(){
        log.info("Get All Airports called...");
        return airportService.displayAllAirports();
    }

    /**
     * SEARCH AIRPORT ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/search-airport/{id}")
    public Airport getAirportById(@PathVariable("id") Long airportId) {
        log.info("Search Airport called with ID: " + airportId);
        return airportService.findAirportById(airportId);
    }

    /**
     * SEARCH AIRPORT BY AIRPORT NAME ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/search-airport-by-name/{airport_Name}")
    public Optional<Airport> getAirportByName(@PathVariable("airport_Name") String airportName){
        log.info("Search Airport called with Name: " + airportName);
        return airportService.getAirportByName(airportName);
    }

    /**
     * SEARCH AIRPORT-BY-LOCATION ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/search-airport-by-loc/{airport_Location}")
    public Iterable<Airport> getAirportsByLocation(@PathVariable("airport_Location") String airportLocation){
        log.info("Search Airport-By-Location called with Location: " + airportLocation);
        return airportService.getAirportsByLocation(airportLocation);
    }

    /**
     * FOR THE FLIGHT SERVICE TO ACCESS THIS PARTICULAR ENDPOINT
     * AS TO PROVIDE THE INFORMATION ON FLIGHTS AS PER SOURCE AND DEST
     */
    @HystrixCommand
    @GetMapping("airport-search-by-loc/{airport_Loc}")
    public Airport forSearchFunctionality(@PathVariable("airport_Loc") String airportLoc){
        log.info("Flights accessed Airports, for providing information on customer search");
        return airportService.getAirportByAirportLocation(airportLoc);
    }
}
