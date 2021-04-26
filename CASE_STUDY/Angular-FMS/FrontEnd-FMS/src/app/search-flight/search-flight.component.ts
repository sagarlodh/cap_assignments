import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from '../Models/flight.component';
import { FlightService } from '../Services/flight.service';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css']
})
export class SearchFlightComponent implements OnInit {

  /* DATA */
  id!: number
  flight!: Flight
  uid:any

  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router,
    private flightService: FlightService) { }

  ngOnInit(): void {
    this.flight = new Flight()
    /* EXTRACTING THE ID AND UID */
    this.id = this.route.snapshot.params['id']
    this.uid = this.route.snapshot.params['uid']

    /* VIEW DETAILS OF FLIGHT BY PASSING IN UID */
    this.flightService.getFlight(this.uid)
        .subscribe(data => {
          this.flight = data;
        }, error => console.log(error));
  }

  /* BACK */
  goBackToList(){
    this.router.navigate(['/list-flights',this.id])
  }

}
