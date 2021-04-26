import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Airport } from '../Models/airport.component';
import { AirportService } from '../Services/airport.service';

@Component({
  selector: 'app-create-airport',
  templateUrl: './create-airport.component.html',
  styleUrls: ['./create-airport.component.css']
})
export class CreateAirportComponent implements OnInit {
  
  /* DATA */
  id: any
  airport: Airport = new Airport();
  submitted=false
  message:any

  /* CONSTRUCTOR */
  constructor(private airportService: AirportService, private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    /* EXTRACTING THE ID FROM THE ROUTE */
    this.id = this.route.snapshot.params['id']
  }
  
  newUser(): void{
    this.submitted = false;
    this.airport = new Airport();
  }

  /* ON SUBMIT OF FORM */
  onSubmit(){
    this.submitted=true;
    this.save();
  }

  save(){
    /******* CREATE AIRPORT SERVICE ********/
    this.airportService.createAirport(this.airport)
    .subscribe(response => {this.message = response}, (error : HttpErrorResponse) => {alert(error)});
    this.airport = new Airport()
    this.responseList();
  }

  /* FOR THE RESPONSE */
  responseList(){
    this.router.navigate(['/create-airport',this.id]);
  }

  /* BACK */
  goBackToList(){
    this.router.navigate(['/list-airports',this.id]);
  }
}
