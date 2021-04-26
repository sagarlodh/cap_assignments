package com.org.fmscloudgateway.FallBackController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FallBackController {

    /**
     * @return FALL BACK FOR USER-SERVICE
     */
    @HystrixCommand
    @RequestMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "It seems USER-SERVICE is down, please try again later...!";
    }

    /**
     * @return FALL BACK FOR AIRPORT-SERVICE
     */
    @HystrixCommand
    @RequestMapping("/airportServiceFallBack")
    public String airportServiceFallBackMethod(){
        return "It seems AIRPORT-SERVICE is down, please try again later...!";
    }

    /**
     * @return FALL BACK FOR FLIGHT-SERVICE
     */
    @HystrixCommand
    @RequestMapping("/flightServiceFallBack")
    public String flightServiceFallBackMethod(){
        return "It seems FLIGHT-SERVICE is down, please try again later...!";
    }

    /**
     * @return FALL BACK FOR BOOKING-SERVICE
     */
    @HystrixCommand
    @RequestMapping("/bookingServiceFallBack")
    public String bookingServiceFallBackMethod(){
        return "It seems BOOKING-SERVICE is down, please try again later...!";
    }

    /**
     * @return FALL BACK FOR LOGIN-SERVICE
     */
    @HystrixCommand
    @RequestMapping("/loginServiceFallBack")
    public String loginServiceFallBackMethod(){
        return "It seems the APPLICATION is down, please try again later...!";
    }
}
