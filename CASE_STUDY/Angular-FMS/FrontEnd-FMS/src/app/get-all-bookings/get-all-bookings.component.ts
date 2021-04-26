import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from '../Services/booking.service';

@Component({
  selector: 'app-get-all-bookings',
  templateUrl: './get-all-bookings.component.html',
  styleUrls: ['./get-all-bookings.component.css']
})
export class GetAllBookingsComponent implements OnInit {

  /* DATA */
  id: any
  bookings: any
  message: ""=""

  /* CONSTRUCTOR */
  constructor(private bookingService: BookingService, private route: ActivatedRoute, private router: Router) { }
  
  ngOnInit(): void {
    /* EXTRACTING THE USER ID */
    this.id = this.route.snapshot.params['id']
    this.reloadData();
  }

  reloadData(){
    /* GET ALL BOOKINGS SERVICE API */
    let response = this.bookingService.getAllBookings()
    response.subscribe(data => {this.bookings = data},error => alert(
      "It seems BOOKING-SERVICE is down, please try again later!"
    ))
  }

  /* SEARCH BOOKINGS BY CRITERIAS */
  searchBookingByParams(){
    this.router.navigate(['/search-bookings-by-params',this.id])
  }
  
  /* CANCEL BOOKING SERVICE */
  deleteBooking(bookingId: number){
    this.bookingService.deleteBooking(bookingId)
    .subscribe(
      response => {this.message = response;this.reloadData();},
      (error : HttpErrorResponse) => {alert(error)});
  }

  /* NAVIGATE TO UPDATE BOOKING, PASSING IN THE BOOKING ID */
  updateBooking(bookingId: number){
    this.router.navigate(['/update-booking',this.id,bookingId])
    .then(() => {
      window.location.reload();
    })
  }

  /* VIEW BOOKING DETAILS */
  searchBooking(bookingId: number){
    this.router.navigate(['/search-booking',this.id,bookingId]);
  }

  /* VIEW FULL BOOKING DESCRIPTION */
  getBookingDesc(bookingId: number){
    this.router.navigate(['/get-booking-desc',this.id,bookingId]);
  }

  /* OTHER BUTTONS FUNCTIONS */
  goBackToAdminPanel(){
    this.router.navigate(['/adminPanel',this.id])
  }
  goToUserList(){
    this.router.navigate(['/list-users',this.id])
  }
  goToFlightList(){
    this.router.navigate(['/list-flights',this.id])
  }
  goToAirportList(){
    this.router.navigate(['/list-airports',this.id])
  }

}
