import { HttpErrorResponse } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../Models/booking.component';
import { FlightSearch } from '../Models/flightSearch.component';
import { user } from '../Models/user.component';
import { AirportService } from '../Services/airport.service';
import { BookingService } from '../Services/booking.service';
import { FlightService } from '../Services/flight.service';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-create-booking',
  templateUrl: './create-booking.component.html',
  styleUrls: ['./create-booking.component.css']
})
export class CreateBookingComponent implements OnInit {

  /* DATA */
  userId: any
  user!: user 
  message: any
  finalSubmit: any
  sourceAirport!: string
  destinationAirport!: string
  flightSearch!: FlightSearch
  flightResponse: any
  submitBookNow: any
  booking: Booking = new Booking()

  /* CONSTRUCTOR */
  constructor(private http: HttpClient,private route: ActivatedRoute,private router: Router, private userService: UserService,
    private airportService: AirportService, private flightService: FlightService, private bookingService: BookingService) { }
  
  /* URL TO BE USED FOR THE SEARCHING OF FLIGHTS */
  private baseUrl='http://localhost:8083/flights';

  ngOnInit(): void {
    this.user = new user()

    /* EXTRACTING THE USER ID */
    this.userId = this.route.snapshot.params['id']
    this.reloadData();
    this.finalSubmit = false

    /* INIT THE BOOKING FORM */
    this.submitBookNow = false

  }
  /* ************* GETTING THE USER DETAILS ***************** */
  reloadData(){
    this.userService.getUser(this.userId)
        .subscribe(data => {
          console.log(data),
          this.user = data
        }, (error: HttpErrorResponse) => console.log(error.error.message));
  }

  /* ****************** USER SEARCH RESPONSE **************************/
  public customerSearchFlight(){
    this.flightSearch = new FlightSearch(this.sourceAirport, this.destinationAirport) 
    this.http.post(`${this.baseUrl}/flight-search`,this.flightSearch)
    .toPromise().then(data => {this.flightResponse = data},error => alert
      ("We maybe facing some issue fetching flights, please try again later!"))
  }

  /* *********************BOOKING FORM ACTIONS ******************/
  bookNow(){
    this.submitBookNow = true
  }
  
  onSubmit(){
    alert("details submitted successfully")
    /* CREATE BOOKING SERVICE */
    this.bookingService.createBooking(this.booking)
        .subscribe(response => {this.message = response}, 
          (error: HttpErrorResponse) => {alert(error.error.message)})
    this.submitBookNow = false

  }

  /* BACK */
  goToUserPanel(){
    this.router.navigate(['/userPanel',this.userId])
  }

  cancelButton(){
    this.submitBookNow = false
  }
}
