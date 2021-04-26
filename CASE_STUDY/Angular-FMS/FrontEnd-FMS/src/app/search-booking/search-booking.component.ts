import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../Models/booking.component';
import { BookingService } from '../Services/booking.service';

@Component({
  selector: 'app-search-booking',
  templateUrl: './search-booking.component.html',
  styleUrls: ['./search-booking.component.css']
})
export class SearchBookingComponent implements OnInit {

  /* DATA */
  id!: number
  uid:any
  booking!: Booking

  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router,
    private bookingService: BookingService) { }

  ngOnInit(): void {
    this.booking = new Booking()
    /* EXTRACTING THE ID & UID */
    this.id = this.route.snapshot.params['id']
    this.uid = this.route.snapshot.params['uid']

    /* VIEW BOOKING DETAILS BY ID */
    this.bookingService.getBooking(this.uid)
        .subscribe(data => {
          this.booking = data;
        }, error => console.log(error.error.message));
  }

  /* BACK */
  goToList(){
    this.router.navigate(['/list-bookings',this.id])
  }


}
