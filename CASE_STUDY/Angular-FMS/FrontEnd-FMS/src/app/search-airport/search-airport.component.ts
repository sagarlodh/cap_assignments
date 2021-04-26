import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Airport } from '../Models/airport.component';
import { user } from '../Models/user.component';
import { AirportService } from '../Services/airport.service';

@Component({
  selector: 'app-search-airport',
  templateUrl: './search-airport.component.html',
  styleUrls: ['./search-airport.component.css']
})
export class SearchAirportComponent implements OnInit {

  /* DATA */
  id!: number
  uid: any
  airport!: Airport

  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router,
    private airportService: AirportService) { }

  ngOnInit(): void {
    this.airport = new Airport()
    /* EXTRACTING THE ID AND UID */
    this.id = this.route.snapshot.params['id']
    this.uid = this.route.snapshot.params['uid']

    /* VIEW AIRPORT DETAILS API BY ID */
    this.airportService.getAirport(this.uid)
        .subscribe(data => {
          this.airport = data;
        }, error => console.log(error.error.message));
  }

  /* BACK */
  goBackToList(){
    this.router.navigate(['/list-airports',this.id])
  }
}
