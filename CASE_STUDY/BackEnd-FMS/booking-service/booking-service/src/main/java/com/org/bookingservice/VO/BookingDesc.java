package com.org.bookingservice.VO;

import com.org.bookingservice.Models.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDesc {

    private Booking booking;
    private User Booking_User_Details;
    private FlightRoute Booking_Flight_Details;

}
