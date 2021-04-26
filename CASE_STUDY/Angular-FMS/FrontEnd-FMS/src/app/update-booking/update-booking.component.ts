import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../Models/booking.component';
import { FlightSearch } from '../Models/flightSearch.component';
import { BookingService } from '../Services/booking.service';
import { FlightService } from '../Services/flight.service';

@Component({
  selector: 'app-update-booking',
  templateUrl: './update-booking.component.html',
  styleUrls: ['./update-booking.component.css']
})
export class UpdateBookingComponent implements OnInit {

  /* DATA */
  id!: number
  uid: any
  booking!: Booking
  submitted: any
  sourceAirport!: string
  destinationAirport!: string
  flightSearch!: FlightSearch
  flightResponse: any

  /* FLIGHT SERVICE URL */
  private baseUrl='http://localhost:8083/flights';
  
  /* CONSTRUCTOR */
  constructor(private http: HttpClient,private route: ActivatedRoute, private router: Router, 
    private flightService: FlightService,private bookingService: BookingService) { }

  ngOnInit(): void {
    this.submitted = false
    this.booking = new Booking()

    /* EXTRACTING THE USER-ID & BOOKING-UID */
    this.id = this.route.snapshot.params['id']
    this.uid = this.route.snapshot.params['uid']
    
    /* VIEW BOOKING DETAILS */
    this.bookingService.getBooking(this.uid)
        .subscribe(data => {
          console.log(data)
          this.booking = data
        }, error => console.log(error));
  }

  /* INIT ON SUBMIT */
  onSubmit(){
    this.submitted = true
    this.updateBooking()
  }

  /* UPDATE BOOKING SERVICE */
  updateBooking(){
    this.bookingService.updateBooking(this.uid, this.booking)
        .subscribe(data => console.log(data), (httpError:HttpErrorResponse) => alert(httpError.error.text));
        this.booking = new Booking()
        this.goToList();
  }

  /* BACK */
  goToList(){
    this.router.navigate(['/list-bookings',this.id])
  }

  /* FOR PROVIDING INFO AS PER SEARCHING NEW FLIGHTS WITH REQUIRED 
  SOURCE & DESTINATION -

  SEARCH FLIGHT WITH SOURCE & DESTINATION SERVICE */
  public customerSearchFlight(){
    this.flightSearch = new FlightSearch(this.sourceAirport, this.destinationAirport)
    this.http.post(`${this.baseUrl}/flight-search`,this.flightSearch)
    .toPromise().then(data => this.flightResponse = data)
  }
}
