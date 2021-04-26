import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Airport } from '../Models/airport.component';
import { AirportService } from '../Services/airport.service';

@Component({
  selector: 'app-search-airport-by-params',
  templateUrl: './search-airport-by-params.component.html',
  styleUrls: ['./search-airport-by-params.component.css']
})
export class SearchAirportByParamsComponent implements OnInit {

  /* DATA */
  id:any
  airportName!: string
  airportLocation!: string
  airport!: Airport;
  airportsByLocation: any
  message: "" = "";
  
  /* CONSTRUCTOR  */
  constructor(private airportService: AirportService, private router: Router,
    private route:ActivatedRoute) { }

  ngOnInit(): void {
    /* EXTRACTING THE ID AND UID */
    this.id = this.route.snapshot.params['id']
  }

  /* ***************************** SEARCH AIRPORTS BY CRITERIAS ****************************** */
  public findAirportByName(){
    let response = this.airportService.getAirportByName(this.airportName)
    response.subscribe(data => this.airport = data)
  }
  public findAirportByAirportLocation(){
    let response = this.airportService.getAirportsByLocation(this.airportLocation)
    response.subscribe(data => this.airportsByLocation = data)
  }

  
  /* DELETE AIRPORT FROM DATABASE */
  deleteAirport(airportId:number){
    this.airportService.deleteAirport(airportId)
    .subscribe(
      response => {this.message = response;},
      (error : HttpErrorResponse) => {alert(error.error.message)});
  }

  /* NAVIGATE TO UPDATE AIRPORT BY AIRPORT ID */
  updateAirport(airportId: number){
    this.router.navigate(['/update-airport',this.id,airportId])
    .then(() => {
      window.location.reload();
    });
  }

  /* VIEW DETAILS OF AIRPORT */
  searchAirport(airportId: number){
    this.router.navigate(['/search-airport',this.id,airportId]);
  }

  /* BACK */
  goBackToList(){
    this.router.navigate(['/list-airports',this.id])
  }

}
