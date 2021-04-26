import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightService } from '../Services/flight.service';

@Component({
  selector: 'app-get-all-flights',
  templateUrl: './get-all-flights.component.html',
  styleUrls: ['./get-all-flights.component.css']
})
export class GetAllFlightsComponent implements OnInit {
  
  /* DATA */
  id: any
  flights: any
  message: ""=""
  
  /* CONSTRUCTOR */
  constructor(private flightService: FlightService, private route: ActivatedRoute, private router:Router) { }
  
  ngOnInit(): void {
    /* EXTRACTING THE USER ID */
    this.id = this.route.snapshot.params['id']
    this.reloadData();
  }

  reloadData(){
    /* GET ALL FLIGHTS SERVICE API */
    let response = this.flightService.getAllFlights();
    response.subscribe(data => {this.flights = data}, error => alert(
      "It seems FLIGHT-SERVICE is down, please try again later!"
    ));
  }

  /* NAVIGATE TO CREATING FLIGHT, PASSING IN THE USER-ID */
  createFlight(){
    this.router.navigate(['/create-flight',this.id])
  }

  /* SEARCH FLIGHTS BY CRITERIAS */
  searchFlightByParams(){
    this.router.navigate(['/search-flight-by-carrier',this.id])
  }

  /* DELETE FLIGHT SERVICE */
  deleteFlight(flightId: number){
    this.flightService.deleteFlight(flightId)
    .subscribe(
      response => {this.message = response;this.reloadData();},
      (error : HttpErrorResponse) => {alert(error)});
  }

  /* NAVIGATE TO THE UPDATE FLIGHT BY FLIGHT-ID */
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

  /* VIEW FLIGHT ROUTE DETAILS, TAKES IN DATA FROM AIRPORTS MICROSERVICE */
  searchFlightRouteDetails(flightId: number){
    this.router.navigate(['/get-flight-route-details',this.id,flightId])
  }

  /* OTHER BUTTON FUNCTIONS */
  goBackToAdmin(){
    this.router.navigate(['/adminPanel',this.id])
  }
  goToUserList(){
    this.router.navigate(['/list-users',this.id])
  }
  goToAirportList(){
    this.router.navigate(['/list-airports',this.id])
  }

}
