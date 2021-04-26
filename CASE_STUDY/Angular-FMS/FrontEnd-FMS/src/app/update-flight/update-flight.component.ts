import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from '../Models/flight.component';
import { FlightService } from '../Services/flight.service';

@Component({
  selector: 'app-update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.css']
})
export class UpdateFlightComponent implements OnInit {

  /* DATA */
  id!: number
  uid: any
  flight!: Flight
  submitted: any
  
  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router, private flightService: FlightService) { }

  ngOnInit(): void {
    this.submitted = false
    this.flight = new Flight()

    /* EXTRACTING THE USER-ID & FLIGHT-UID */
    this.id = this.route.snapshot.params['id']
    this.uid = this.route.snapshot.params['uid']

    /* VIEW FLIGHT DETAILS SERVICE */
    this.flightService.getFlight(this.id)
        .subscribe(data => {
          console.log(data)
          this.flight = data
        }, error => console.log(error));
  }

  /* INIT ON SUBMIT */
  onSubmit(){
    this.submitted = true
    this.updateAirport()
  }

  
  /* UPDATE FLIGHT DETAILS SERVICE */
  updateAirport(){
    this.flightService.updateFlight(this.uid, this.flight)
        .subscribe(data => console.log(data), error => console.log(error));
        this.flight = new Flight()
        this.gotoList();
  }

  /* BACK */
  gotoList(){
    this.router.navigate(['/list-flights',this.id])
  }

}
