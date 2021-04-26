import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightSearch } from '../Models/flightSearch.component';
import { FlightService } from '../Services/flight.service';

@Component({
  selector: 'app-customer-search',
  templateUrl: './customer-search.component.html',
  styleUrls: ['./customer-search.component.css']
})
export class CustomerSearchComponent implements OnInit {

  srcAirport: any
  destAirport: any

  flightResponse: any
  flightSearch!: FlightSearch
  

  message: any
  constructor(private route: ActivatedRoute, private router: Router,private flightService: FlightService) { }

  ngOnInit(): void {
  }

  public customerSearchFlight(){
    this.flightService.searchFlightByCustomer(this.flightSearch)
    .subscribe(data => {this.flightResponse = data}, error => console.log(error.error))
  }



}
