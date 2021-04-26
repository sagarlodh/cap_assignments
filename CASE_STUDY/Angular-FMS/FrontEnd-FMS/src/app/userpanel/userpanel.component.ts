import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { user } from '../Models/user.component';
import { BookingService } from '../Services/booking.service';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-userpanel',
  templateUrl: './userpanel.component.html',
  styleUrls: ['./userpanel.component.css']
})
export class UserpanelComponent implements OnInit {

  /* DATA */
  userId: any
  user!: user 
  message: any
  deleteMessage: any
  updateSubmit: any
  bookings: any
  deleteBMessage: any
  deleteSubmit: any

  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router,
    private userService: UserService , private bookingService: BookingService) { }

  ngOnInit(): void {
    this.updateSubmit = false
    this.deleteSubmit = false
    this.user = new user()

    /* EXTRACTING THE USER-ID */
    this.userId = this.route.snapshot.params['id']

    this.reloadData();
  }

  reloadData(){
    /* VIEW USER DETAILS SERVICE */
    this.userService.getUser(this.userId)
        .subscribe(data => {
          console.log(data),
          this.user = data
        }, (error : HttpErrorResponse) => {alert(error.error.message),
        this.router.navigate(['/login'])})
    
    /* GET BOOKING DETAILS FOR USER SERVICE */
    this.bookingService.getBookingByUserId(this.userId)
        .subscribe(data => {console.log(data),this.bookings = data;
        },error => alert("We may have some problems fetching your bookings, please try later!"))
  }

  deleteCheck(){
    this.deleteSubmit = true

  }
  
  /* DELETE USER ACCOUNT SERVICE */
  deleteUser(userId:number){
    this.deleteMessage = "Click on 'OK' to delete Account!"
    alert(this.deleteMessage)
    if(
    this.userService.deleteUser(userId)
    .subscribe(
      response => {this.message = response;this.reloadData();},
      (error : HttpErrorResponse) => {alert(error.error.message)})
    ){this.router.navigate(['/login'])}

  }

  /* CANCEL DELETE ACCOUNT */
  cancelDelete(){
    this.deleteSubmit = false
  }

  updateCheck(){
    this.updateSubmit = true
  }

  /* UPDATE USER SERVICE BY PASSING USER-ID */
  updateUser(userId: number){
    this.userService.updateUser(userId, this.user) 
        .subscribe(data => console.log(data), (error: HttpErrorResponse) => console.log(error.error.message))
    
    this.updateSubmit = false
        
  }

  cancelUpdate(){
    this.updateSubmit = false
  }

  /* NAVIGATE TO CREATE BOOKING SERVICE */
  createBooking(){
    this.router.navigate(['/create-booking',this.userId])
  }

/* ********************************** BOOKING ********************************* */

  /* CANCEL BOOKING SERVICE */
  deleteBooking(bookingId: number){
    this.deleteBMessage = "Click on 'OK' to delete Booking!"
    alert(this.deleteBMessage)
    if(
    this.bookingService.deleteBooking(bookingId)
    .subscribe(
      response => {this.message = response;},
      (error : HttpErrorResponse) => {alert(error)})
    ){
      this.router.navigate(['/userPanel',this.userId])
    }
  }

  /* VIEW BOOKING DESCRIPTION SERVICE */
  getBookingDesc(bookingId: number){
    this.router.navigate(['/cust-search-booking-desc',this.userId,bookingId]);
  }
}
