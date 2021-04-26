import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from '../Services/booking.service';

@Component({
  selector: 'app-cust-search-booking-desc',
  templateUrl: './cust-search-booking-desc.component.html',
  styleUrls: ['./cust-search-booking-desc.component.css']
})
export class CustSearchBookingDescComponent implements OnInit {

  /* DATA */
  id!: number
  uid: any
  bookingDescription: any

  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router, 
    private bookingService: BookingService) { }

  ngOnInit(): void {
    /* EXTRACTING THE USER AND UID*/
    this.id = this.route.snapshot.params['id']
    this.uid = this.route.snapshot.params['uid']

    /* VIEW FULL BOOKING DESCRIPTION SERVICE, TAKES IN DATA FROM ALL OTHER MICROSERVICES */
    this.bookingService.getBookingDescription(this.uid)
        .subscribe(data => {
          this.bookingDescription = data
        }, error => console.log(error.error.message));
  }

  /* BACK */
  goBackToUserPanel(){
    this.router.navigate(['/userPanel',this.id])
  }

}
