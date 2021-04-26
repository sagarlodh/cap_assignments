import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Airport } from '../Models/airport.component';
import { AirportService } from '../Services/airport.service';

@Component({
  selector: 'app-update-airport',
  templateUrl: './update-airport.component.html',
  styleUrls: ['./update-airport.component.css']
})
export class UpdateAirportComponent implements OnInit {

  /* DATA */
  id!: number
  uid: any
  airport!: Airport
  submitted: any
  
  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router, private airportService: AirportService) { }

  ngOnInit(): void {
    this.submitted = false
    this.airport = new Airport()
    /* EXTRACTING THE ID & UID */
    this.id = this.route.snapshot.params['id']
    this.uid = this.route.snapshot.params['uid']

    /* VIEW AIRPORT DETAILS BY ID */
    this.airportService.getAirport(this.id)
        .subscribe(data => {
          console.log(data)
          this.airport = data
        }, error => console.log(error));
  }

  /* INIT ON SUBMIT */
  onSubmit(){
    this.submitted = true
    this.updateAirport()
  }

  /* UPDATAE AIRPORT SERVICE */
  updateAirport(){
      this.airportService.updateAirport(this.id, this.airport)
          .subscribe(data => console.log(data), error => console.log(error));
          this.airport = new Airport()
          this.goBackToList();
  }

  /* BACK */
  goBackToList(){
    this.router.navigate(['/list-airports',this.id])
  }
}
