import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from '../Services/booking.service';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-search-booking-by-params',
  templateUrl: './search-booking-by-params.component.html',
  styleUrls: ['./search-booking-by-params.component.css']
})
export class SearchBookingByParamsComponent implements OnInit {

  /* DATA */
  userId!: number
  bookings: any
  message: "" = ""
  firstName!: string
  users: any
  id: any

  /* CONSTRUCTOR */
  constructor(private router: Router, private bookingService: BookingService, private route:ActivatedRoute
    ,private userService: UserService) { }

  ngOnInit(): void {
    /* EXTRACTING THE ID AND UID */
    this.id = this.route.snapshot.params['id']
  }

  /* ************************ SEARCH BOOKINGS BY USER ID *********************** */
  public findBookingsByUserId(){
    let response = this.bookingService.getBookingByUserId(this.userId)
    response.subscribe(data => this.bookings = data)
  }

  /* CANCEL BOOKING SERVICE */
  deleteBooking(bookingId: number){
    this.bookingService.deleteBooking(bookingId)
    .subscribe(
      response => {this.message = response;},
      (error : HttpErrorResponse) => {alert(error)});
  }

  /* NAVIGATE TO UPDATE BOOKING BY BOOKING-ID */
  updateBooking(bookingId: number){
    this.router.navigate(['/update-booking',this.id,bookingId])
    .then(() => {
      window.location.reload();
    });
  }

  /*NAVIGATE TO BOOKING DETAILS BY ID */
  searchBooking(bookingId: number){
    this.router.navigate(['/search-booking',this.id,bookingId])
  }

  /* NAVIGATE TO BOOKING DESCRIPTION SERVICE, CALLING IN FROM FLIGHTS & AIRPORTS TOO */
  getBookingDesc(bookingId: number){
    this.router.navigate(['/get-booking-desc',this.id,bookingId]);
  }

  /* GETTING THE USER INFO */
  public findUserByFirstName(){
    let response = this.userService.getUserByName(this.firstName)
    response.subscribe(data => this.users = data)
  }
  
  /* USER SERVICE REMOVE ACTION */
  deleteUser(userId:number){
    this.userService.deleteUser(userId)
    .subscribe(
      response => {this.message = response;},
      (error : HttpErrorResponse) => {alert(error)});
  }

  /* OTHER BUTTON FUNCTIONS */
  goToBookingList(){
    this.router.navigate(['/list-bookings',this.id])
  }
  goToUserList(){
    this.router.navigate(['/list-users',this.id])
  }

}
