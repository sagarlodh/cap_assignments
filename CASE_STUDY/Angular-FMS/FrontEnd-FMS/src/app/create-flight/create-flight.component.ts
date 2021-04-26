import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from '../Models/flight.component';
import { FlightService } from '../Services/flight.service';

@Component({
  selector: 'app-create-flight',
  templateUrl: './create-flight.component.html',
  styleUrls: ['./create-flight.component.css']
})
export class CreateFlightComponent implements OnInit {

  /* DATA */
  flight: Flight = new Flight();
  submitted=false
  message:any
  id:any
  
  /* CONSTRUCTOR */
  constructor(private flightService: FlightService,private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    /* URL TO BE USED FOR THE SEARCHING OF FLIGHTS */
    this.id = this.route.snapshot.params['id']
  }
  
  newFlight(): void{
    this.submitted = false;
    this.flight = new Flight()
  }

  /* INIT FORM SUBMIT */
  onSubmit(){
    this.submitted=true;
    this.save();
  }

  save(){
    /*********** CREATE FLIGHT SERVICE **************/
    this.flightService.createFlight(this.flight)
    .subscribe(response => {this.message = response}, (error : HttpErrorResponse) => {alert(error.error.message)});
    this.flight = new Flight()
    this.response();
  }

  /* FOR RESPONSE SHOW */
  response(){
    this.router.navigate(['create-flight',this.id])
  }

  /* BACK */
  gotoList(){
    this.router.navigate(['/list-flights',this.id]);
  }

}
