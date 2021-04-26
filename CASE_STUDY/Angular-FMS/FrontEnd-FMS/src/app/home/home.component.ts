import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../Models/booking.component';
import { FlightSearch } from '../Models/flightSearch.component';
import { BookingService } from '../Services/booking.service';
import { FlightService } from '../Services/flight.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  /* DATA */
  id!: number
  booking!: Booking
  submitted: any
  sourceAirport!: string
  destinationAirport!: string
  flightSearch!: FlightSearch
  flightResponse: any
  errorMsg!: string
  errorDirection!: string

  /* THE CLOUD API GATEWAY */
  private baseUrl='http://localhost:8083/flights';

  /* CONSTRUCTOR */
  constructor(private http: HttpClient,private route: ActivatedRoute, private router: Router, 
    private flightService: FlightService,private bookingService: BookingService) { }

  ngOnInit(): void {}
  
  public customerSearchFlight(){
    /* PREPARING AND FETCHING THE REQUIRED FLIGHTS WITH PROVIDED
    SOURCE & DESTINATION DETAILS */
    this.flightSearch = new FlightSearch(this.sourceAirport, this.destinationAirport)   
    this.http.post(`${this.baseUrl}/flight-search`,this.flightSearch)
    .toPromise().then(data => {this.flightResponse = data},
      error => {this.errorMsg = "It seems the services are down! We are sorry for the inconvenience!",
    this.errorDirection = "Please try again in a few minutes!"})
  }

  /* NAVIGATE TO LOGIN */
  guideToLogin(){
    this.router.navigate(['/login'])
  }
}
