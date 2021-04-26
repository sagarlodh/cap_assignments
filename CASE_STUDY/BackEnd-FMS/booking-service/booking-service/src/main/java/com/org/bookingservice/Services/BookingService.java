package com.org.bookingservice.Services;

import com.org.bookingservice.Models.Booking;
import com.org.bookingservice.VO.BookingDesc;

public interface BookingService {
    /**
     * BUSINESS METHODS
     */
    String createBooking(Booking newBooking);
    String updateBooking(Long bookingId);
    String cancelBooking(Long bookingId);
    Iterable<Booking> displayAllBookings();
    Booking findBookingById(Long bookingId);
    Iterable<Booking> getBookingsByUserId(Long userId);

    /** user can see the booking and if he clicks on a booking then
     *  user will be able to see the BOOKING DESCRIPTION
     **/
    BookingDesc getBookingDescription(Long bookingId);

}
