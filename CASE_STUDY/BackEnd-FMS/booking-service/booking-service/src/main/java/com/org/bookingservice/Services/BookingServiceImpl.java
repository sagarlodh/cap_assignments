package com.org.bookingservice.Services;

import com.org.bookingservice.Config.SequenceGeneratorService;
import com.org.bookingservice.Exceptions.RecordAlreadyPresentException;
import com.org.bookingservice.Exceptions.RecordNotFoundException;
import com.org.bookingservice.Models.Booking;
import com.org.bookingservice.Repos.BookingRepo;
import com.org.bookingservice.VO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    /**
     * BUSINESS METHOD IMPLEMENTATIONS
     */

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    /**
     * @param newBooking
     * @return CREATES A BOOKING
     */
    @Override
    public String createBooking(Booking newBooking) {
        /** ONE USER CAN HAVE MULTIPLE BOOKINGS, SO FETCH BY UNIQUE CODE */
        Optional<Booking> existingBooking = Optional.ofNullable(bookingRepo.findBookingByUniqueCode(newBooking.getUniqueCode()));
        if(existingBooking.isEmpty()){
            newBooking.setBookingId(sequenceGeneratorService.generateSequence(Booking.SEQUENCE_NAME));
            bookingRepo.save(newBooking);
            Booking returnBooking = bookingRepo.findBookingByUniqueCode(newBooking.getUniqueCode());
            return "You have successfully Booked the Flight! \nYour Booking-ID: " + returnBooking.getBookingId();
        } else {
            throw new RecordAlreadyPresentException("Please enter Unique Booking Code!"
                    + "\nBooking already exists with Booking-Code: " + newBooking.getUniqueCode());
        }
    }



    /**
     * @param bookingId
     * @return UPDATES A SPECIFIC BOOKING WITH GIVEN BOOKING-ID
     */
    @Override
    public String updateBooking(Long bookingId) {
        return null;
    }



    /**
     * @param bookingId
     * @return DELETES BOOKING WITH A SPECIFIC BOOKING-ID
     */
    @Override
    public String cancelBooking(Long bookingId) {
        Booking existingBooking = bookingRepo.findById(bookingId).orElseThrow(()-> new RecordNotFoundException(
                "Booking does not exist with Id: [" + bookingId + "] ,Please Enter Valid ID!"));
        bookingRepo.delete(existingBooking);
        return "Booking canceled with ID:" + bookingId;
    }



    /**
     *
     * @return A LIST OF ALL BOOKINGS
     */
    @Override
    public Iterable<Booking> displayAllBookings() {
        return bookingRepo.findAll();
    }



    /**
     * @param bookingId
     * @return BOOKING WITH SPECIFIC-ID
     */
    @Override
    public Booking findBookingById(Long bookingId) {
        return bookingRepo.findById(bookingId).orElseThrow(() -> new RecordNotFoundException
                ("Booking does not exist with Id: [" + bookingId + "] ,Please Enter Valid ID!"));
    }



    /****************************** CUSTOM CRITERIA FROM REPO IMPLEMENTED *****************************/

    /**
     * @param userId
     * @return ALL BOOKINGS MADE WITH A SPECIFIC USER-ID
     */
    @Override
    public Iterable<Booking> getBookingsByUserId(Long userId) {
        return bookingRepo.findBookingByUserId(userId);
    }



    /****************************** RETURNABLE ENTITY SERVICE IMPLEMENTED *****************************/

    /**
     * @param bookingId
     * @return THE WHOLE BOOKING DESCRIPTION:
     * [1] THE ORIGINAL BOOKING
     * [2] THE USER WHO BOOKED IT
     * [3] THE FLIGHT WHICH IS BOOKED ALONG WITH THE AIRPORT DETAILS
     */
    @Override
    public BookingDesc getBookingDescription(Long bookingId) {

        // TODO: check if the booking exists
        Booking existingBooking = bookingRepo.findById(bookingId).orElseThrow(()-> new RecordNotFoundException
                ("Booking not found with ID: [" + bookingId + "] ,Please Enter Valid ID!"));

        // TODO: get the user-details by ID
        User bookedUserDetails = restTemplate.getForObject(
                "http://USER-SERVICE/users/search-user/" + existingBooking.getUserId(),User.class);

        // TODO: get the flight by ID
        Flight bookedFlight  = restTemplate.getForObject(
                "http://FLIGHT-SERVICE/flights/search-flight/" + existingBooking.getFlightId(),Flight.class);

        // TODO: fetch the airports info for later injecting in Flight Route
        Airport bookedFlightSourceAirportDetails = restTemplate.getForObject(
                "http://AIRPORT-SERVICE/airports/search-airport/" + bookedFlight.getSrcAirportId(),Airport.class);
        Airport bookedFlightDestinationAirportDetails = restTemplate.getForObject(
                "http://AIRPORT-SERVICE/airports/search-airport/" + bookedFlight.getDestAirportId(),Airport.class);

        // TODO: get the final returnable flight-route-details and use it in flight-route
        FlightRoute bookedFlightRouteDetails = restTemplate.getForObject(
                "http://FLIGHT-SERVICE/flights/flight-route/" + bookedFlight.getFlightId(), FlightRoute.class);

        // TODO: set the desired properties to be displayed and return....
        BookingDesc bookingDesc = new BookingDesc();
        bookingDesc.setBooking(existingBooking);
        bookingDesc.setBooking_User_Details(bookedUserDetails);
        bookingDesc.setBooking_Flight_Details(bookedFlightRouteDetails);
        return bookingDesc;


    }
}
