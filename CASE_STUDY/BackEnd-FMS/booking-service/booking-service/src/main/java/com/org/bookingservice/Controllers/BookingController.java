package com.org.bookingservice.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.bookingservice.Exceptions.RecordNotFoundException;
import com.org.bookingservice.Models.Booking;
import com.org.bookingservice.Repos.BookingRepo;
import com.org.bookingservice.Services.BookingService;
import com.org.bookingservice.VO.BookingDesc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@ComponentScan(basePackages = "com.org.bookingservice")
@RestController
@RequestMapping("/bookings")
@Slf4j
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    BookingRepo bookingRepo;

    /**
     * CREATE BOOKING ENDPOINT
     */
    @HystrixCommand
    @PostMapping("/create-booking")
    public String createBooking(@RequestBody Booking newBooking){
        log.info("Booking Created with payload: " + newBooking);
        return bookingService.createBooking(newBooking);
    }

    /**
     * UPDATE BOOKING ENDPOINT
     */
    @HystrixCommand
    @PutMapping("/update-booking/{id}")
    public String updateBooking(@RequestBody Booking updatedBooking,@PathVariable("id") Long bookingId){
        log.info("Update Booking called with ID: " + bookingId);
        Booking existingBooking =bookingRepo.findById(bookingId)
                                            .orElseThrow(() -> new RecordNotFoundException(
                                                    "Booking does not exist with ID: [" + bookingId + "] ,Please Enter Valid ID!"));
        existingBooking.setUniqueCode(updatedBooking.getUniqueCode());
        existingBooking.setBookingDate(updatedBooking.getBookingDate());
        existingBooking.setUserId(updatedBooking.getUserId());
        existingBooking.setNoOfPassengers(updatedBooking.getNoOfPassengers());
        existingBooking.setFlightId(updatedBooking.getFlightId());
        bookingRepo.save(existingBooking);
        return "Booking Updated with Booking-Id: [" + bookingId + "]";
    }

    /**
     * DELETE BOOKING ENDPOINT
     */
    @HystrixCommand
    @DeleteMapping("/delete-booking/{id}")
    public String deleteBookingById(@PathVariable("id") Long bookingId){
        log.info("Delete Booking called with ID: " + bookingId);
        return bookingService.cancelBooking(bookingId);
    }

    /**
     * GET ALL BOOKINGS ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/get-all-bookings")
    public Iterable<Booking> getAllBookings(){
        log.info("Get All Bookings called...");
        return bookingService.displayAllBookings();
    }

    /**
     * SEARCH BOOKING ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/search-booking/{id}")
    public Booking getBookingById(@PathVariable("id") Long bookingId){
        log.info("Search Booking called with ID: " + bookingId);
        return bookingService.findBookingById(bookingId);
    }

    /**
     * SEARCH BOOKING-BY-USER_ID ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/get-bookings-by-userId/{user_id}")
    public Iterable<Booking> getBookingsByUserId(@PathVariable("user_id") Long userId){
        log.info("Search Booking-By-UserId called with ID: " + userId);
        return bookingService.getBookingsByUserId(userId);
    }

    /**
     * GET BOOKING-DESCRIPTION ENDPOINT
     */
    @HystrixCommand
    @GetMapping("/get-booking-desc/{id}")
    public BookingDesc getBookingDescription(@PathVariable("id") Long bookingId){
        log.info("Get Booking-Description called with ID: " + bookingId);
        return bookingService.getBookingDescription(bookingId);
    }

}
