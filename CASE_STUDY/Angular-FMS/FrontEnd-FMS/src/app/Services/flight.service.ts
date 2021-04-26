import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  /* FLIGHT SERVICE URL */
  private baseUrl='http://localhost:8083/flights';
  constructor(private http: HttpClient) { }

  // create flight
  createFlight(flight: Object): Observable<any> {
    return this.http.post(`${this.baseUrl}/create-flight`,flight,{responseType: 'text' as 'json'})
  }

  // update flight
  updateFlight(flightId: number, flight: Object): Observable<any> {
    return this.http.put(`${this.baseUrl}/update-flight/${flightId}`,flight,{responseType: 'text' as "json"});
  }
  
  // delete flight
  deleteFlight(flightId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete-flight/${flightId}`,{ responseType: 'text'})
  }
  
  // get all flight
  getAllFlights(): Observable<any>{
    return this.http.get(`${this.baseUrl}/get-all-flights`)
  }

  // search flight by Id
  getFlight(flightId: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/search-flight/${flightId}`)
  } 
  
  // search flight by name
  getFlightsByCarrier(flightCarrierName: string): Observable<any>{
    return this.http.get(`${this.baseUrl}/search-flight-by-carrier/${flightCarrierName}`)
  }

  // get flight ROUTE info
  getFlightRouteDetails(flightId: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/flight-route/${flightId}`)
  }

  // searching flight option by customer
  searchFlightByCustomer(flightSearch: Object): Observable<any>{
    return this.http.post(`${this.baseUrl}/flight-search`,flightSearch,{responseType: 'text' as "json"})
  }
}
