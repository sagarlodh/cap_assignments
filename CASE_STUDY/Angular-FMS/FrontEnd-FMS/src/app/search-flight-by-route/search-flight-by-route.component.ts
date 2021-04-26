import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightService } from '../Services/flight.service';

@Component({
  selector: 'app-search-flight-by-route',
  templateUrl: './search-flight-by-route.component.html',
  styleUrls: ['./search-flight-by-route.component.css']
})
export class SearchFlightByRouteComponent implements OnInit {

  /* DATA */
  id!: number
  uid: any
  flightRouteDetails: any

  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router, 
    private flightService: FlightService) { }

  ngOnInit(): void {
    /* EXTRACTING THE ID & UID */
    this.id = this.route.snapshot.params['id']
    this.uid = this.route.snapshot.params['uid']

    /* VIEW TO FLIGHT ROUTE DETAILS: CALLING IN INFO FROM AIRPORT SERVICE */
    this.flightService.getFlightRouteDetails(this.uid)
        .subscribe(data => {
          this.flightRouteDetails = data
        }, error => alert("It seems Flight-Route Service is down, please try again later!"));
  }

  /* BACK */
  goBackToFlightList(){
    this.router.navigate(['/list-flights',this.id])
  }

}
