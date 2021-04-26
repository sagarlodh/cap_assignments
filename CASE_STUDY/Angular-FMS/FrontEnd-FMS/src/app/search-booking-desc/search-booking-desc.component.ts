import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from '../Services/booking.service';

@Component({
  selector: 'app-search-booking-desc',
  templateUrl: './search-booking-desc.component.html',
  styleUrls: ['./search-booking-desc.component.css']
})
export class SearchBookingDescComponent implements OnInit {
  
  /* DATA */
  id!: number
  uid: any
  bookingDescription: any

  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router, 
    private bookingService: BookingService) { }

  ngOnInit(): void {
    /* EXTRACTING THE ID AND UID */
    this.id = this.route.snapshot.params['id']
    this.uid = this.route.snapshot.params['uid']

    /* VIEW BOOKING DESCRIPTION */
    this.bookingService.getBookingDescription(this.uid)
        .subscribe(data => {
          this.bookingDescription = data
        }, error => alert("It seems BOOKING-DESCRIPTION service is down, please try again later!"));
  }

  /* BACK */
  goToBookingsList(){
    this.router.navigate(['/list-bookings',this.id])
  }

}
