package com.org.airportservice.Services;

import com.org.airportservice.Config.SequenceGeneratorService;
import com.org.airportservice.Exceptions.RecordAlreadyPresentException;
import com.org.airportservice.Exceptions.RecordNotFoundException;
import com.org.airportservice.Models.Airport;
import com.org.airportservice.Repos.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {
    /**
     * BUSINESS METHOD IMPLEMENTATIONS
     */

    @Autowired
    private AirportRepo airportRepo;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    /**
     *
     * @param newAirport
     * @return CREATES AN AIRPORT
     */
    @Override
    public String createAirport(Airport newAirport) {
        Optional<Airport> existingAirport = Optional.ofNullable(airportRepo.findAirportByAirportCode(
                                                                    newAirport.getAirportCode()));
        if(existingAirport.isEmpty()){
            newAirport.setAirportId(sequenceGeneratorService.generateSequence(Airport.SEQUENCE_NAME));
            airportRepo.save(newAirport);
            return "You have successfully created an Airport with Airport-Code: " + newAirport.getAirportCode();
        } else {
            throw new RecordAlreadyPresentException("Please enter Unique Airport Code!" + " " +
                    "Airport already exists with Code: " + newAirport.getAirportCode());
        }
    }



    /**
     *
     * @param airportId
     * @return UPDATES SPECIFIC AIRPORT WITH GIVEN AIRPORT-ID
     */
    @Override
    public String updateAirport(Long airportId) {
        return null;
    }



    /**
     *
     * @param airportId
     * @return DELETES AIRPORT WITH SPECIFIC AIRPORT-ID
     */
    @Override
    public String deleteAirport(Long airportId) {
        Airport existingAirport = airportRepo.findById(airportId).orElseThrow(() ->
                new RecordNotFoundException("Airport does not exist with Id: [" + airportId + "] ,Please Enter Valid ID!"));
        airportRepo.delete(existingAirport);
        return "Airport deleted with Id: " + airportId;
    }



    /**
     * @return A LIST OF ALL AIRPORTS
     */
    @Override
    public Iterable<Airport> displayAllAirports() {
        return airportRepo.findAll();
    }



    /**
     *
     * @param airportId
     * @return AIRPORT WITH SPECIFIC AIRPORT-ID
     */
    @Override
    public Airport findAirportById(Long airportId) {
        return airportRepo.findById(airportId).orElseThrow(() -> new RecordNotFoundException
                ("Airport does not exist with Id: [" + airportId + "] ,Please Enter Valid ID!"));
    }



    /****************************** CUSTOM CRITERIA FROM REPO IMPLEMENTED *****************************/

    /**
     *
     * @param airportName
     * @return AIRPORT BY SPECIFIC AIRPORT-NAME
     */
    @Override
    public Optional<Airport> getAirportByName(String airportName) {
        Optional<Airport> existingAirport = Optional.ofNullable(airportRepo.findAirportByAirportName(airportName));
        if(existingAirport.isPresent()){
            return existingAirport;
        } else {
            throw new RecordNotFoundException("Airport does not exist with Name: [" + airportName + "] ,Please Enter Valid Name!");
        }
    }

    

    /**
     * @param airportLocation
     * @return A LIST OF ALL AIRPORTS IN A GIVEN-LOCATION
     */
    @Override
    public Iterable<Airport> getAirportsByLocation(String airportLocation) {
        return airportRepo.findAirportByAirportLocation(airportLocation);
    }


    /**
     * @param airportLocation
     * @return AIRPORT TO THE FLIGHT SERVICE (MAINLY)
     */
    @Override
    public Airport getAirportByAirportLocation(String airportLocation) {
        return airportRepo.getAirportByAirportLocation(airportLocation);
    }
}


