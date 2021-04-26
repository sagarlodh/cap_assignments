import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightService } from '../Services/flight.service';

@Component({
  selector: 'app-search-flight-by-carrier',
  templateUrl: './search-flight-by-carrier.component.html',
  styleUrls: ['./search-flight-by-carrier.component.css']
})
export class SearchFlightByCarrierComponent implements OnInit {

  /* DATA */
  carrier!: string
  flights: any
  message: "" = "";
  id:any

  /* CONSTRUCTOR */
  constructor(private router: Router, private flightService: FlightService, private route:ActivatedRoute) { }

  ngOnInit(): void {
    /* EXTRACTING THE ID */
    this.id = this.route.snapshot.params['id']
  }

  /* **************** SEARCH FLIGHTS BY CRITERIA ***************** */
  public findFlightsByCarrier(){
    let response = this.flightService.getFlightsByCarrier(this.carrier)
    response.subscribe(data => this.flights = data)
  }

  /* DELETE FLIGHT SERVICE */
  deleteFlight(flightId:number){
    this.flightService.deleteFlight(flightId)
    .subscribe(
      response => {this.message = response;},
      (error : HttpErrorResponse) => {alert(error)});
  }

  /* NAVIGATE TO THE UPDATE FLIGHT, PASSING IN THE FLIGHT-ID */
  updateFlight(flightId: number){
    this.router.navigate(['/update-flight',this.id,flightId])
    .then(() => {
      window.location.reload();
    });
  }

  /* VIEW FLIGHT DETAILS */
  searchFlight(flightId: number){
    this.router.navigate(['/search-flight',this.id,flightId])
  }

  /* NAVIGATE TO FLIGHT ROUTE DETAILS: CALLING IN INFO FROM AIRPORT SERVICE */
  searchFlightRouteDetails(flightId: number){
    this.router.navigate(['/get-flight-route-details',this.id,flightId])
  }

  /* BACK */
  goBackToFlightList(){
    this.router.navigate(['/list-flights',this.id])
  }

}
