package com.org.bookingservice.Repos;

import com.org.bookingservice.Models.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends MongoRepository<Booking, Long> {
    /**
     * CUSTOM SEARCH CRITERIAS TO BE USED
     */
    Booking findBookingByUniqueCode(String uniqueCode);
    Iterable<Booking> findBookingByUserId(Long userId);


}
