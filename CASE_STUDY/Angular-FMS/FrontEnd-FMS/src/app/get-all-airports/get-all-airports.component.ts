import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AirportService } from '../Services/airport.service';

@Component({
  selector: 'app-get-all-airports',
  templateUrl: './get-all-airports.component.html',
  styleUrls: ['./get-all-airports.component.css']
})
export class GetAllAirportsComponent implements OnInit {

  /* DATA */
  id: any
  airports: any
  message: ""=""

  /* CONSTRUCTOR */
  constructor(private airportService: AirportService, private route: ActivatedRoute, private router:Router) { }
  
  ngOnInit(): void {
    /* EXTRACTING THE USER ID */
    this.id = this.route.snapshot.params['id']
    this.reloadData();

  }

  reloadData(){
    /* GET ALL AIRPORTS SERVICE API */
    let response = this.airportService.getAllAirports();
    response.subscribe(data => {this.airports = data},error => alert(
      "It seems AIRPORT-SERVICE is down, please try again later!"))
  }

  /* NAVIGATE TO CREATE AIRPORT */
  createAirport(){
    this.router.navigate(['create-airport',this.id])
  }

  /* NAVIGATE TO SEARCH AIRPORT BY CRITERIAS */
  searchAirportByParams(){
    this.router.navigate(['/search-airport-by-params',this.id])
  }

  /* DELETE AIRPORT SERVICE */
  deleteAirport(airportId:number){
    this.airportService.deleteAirport(airportId)
    .subscribe(
      response => {this.message = response;this.reloadData();},
      (error : HttpErrorResponse) => {alert(error)});
  }

  /* NAVIGATE TO UPDATE AIRPORT PASSING IN THE AIRPORT DETAILS */
  updateAirport(airportId: number){
    this.router.navigate(['/update-airport',this.id,airportId])
    .then(() => {
      window.location.reload();
    });
  }

  /* GET THE AIRPORT DETAILS:- SEARCH BY ID */
  searchAirport(airportId: number){
    this.router.navigate(['/search-airport',this.id,airportId]);
  }

  /* OTHER BUTTON FUNCTIONS */
  goBackToAdmin(){
    this.router.navigate(['/adminPanel',this.id])
  }
  goToUserList(){
    this.router.navigate(['/list-users',this.id])
  }
  goToFlightList(){
    this.router.navigate(['/list-flights',this.id])
  }
}
