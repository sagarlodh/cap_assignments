import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AirportService {

  /* AIRPORT SERVICE URL */
  private baseUrl='http://localhost:8082/airports';
  constructor(private http: HttpClient) { }

  // create airport
  createAirport(airport: Object): Observable<any> {
    return this.http.post(`${this.baseUrl}/create-airport`,airport,{responseType: 'text' as 'json'})
  }

  // update airport
  updateAirport(airportId: number, airport: Object): Observable<any> {
    return this.http.put(`${this.baseUrl}/update-airport/${airportId}`,airport,{responseType: 'text' as "json"});
  }
  
  // delete airport
  deleteAirport(airportId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete-airport/${airportId}`,{ responseType: 'text'})
  }
  
  // get all airports
  getAllAirports(): Observable<any>{
    return this.http.get(`${this.baseUrl}/get-all-airports`)
  }

  // search airport by Id
  getAirport(airportId: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/search-airport/${airportId}`)
  } 
  
  // search airport by name
  getAirportByName(airportName: string): Observable<any>{
    return this.http.get(`${this.baseUrl}/search-airport-by-name/${airportName}`)
  }
  
  // search airport by location
  getAirportsByLocation(airportLocation: string): Observable<any>{
    return this.http.get(`${this.baseUrl}/search-airport-by-loc/${airportLocation}`)
  }

  // for sending airport data for the search functionality
  searchAirportByLocationForCustomer(airportLoc: string): Observable<any>{
    return this.http.get(`${this.baseUrl}/airport-search-by-loc/${airportLoc}`,{responseType: 'text' as 'json'});
  }
}
