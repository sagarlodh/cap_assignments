import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  /* BOOKING SERVICE URL */
  private baseUrl='http://localhost:8084/bookings';
  constructor(private http: HttpClient) { }

  // create booking
  createBooking(booking: Object): Observable<any> {
    return this.http.post(`${this.baseUrl}/create-booking`,booking,{responseType: 'text' as "json"});
  }
 
  // update booking
  updateBooking(bookingId: number, booking: Object): Observable<any>{
    return this.http.put(`${this.baseUrl}/update-booking/${bookingId}`,booking,{responseType: 'text' as "json"});
  }

  // delete booking
  deleteBooking(bookingId: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/delete-booking/${bookingId}`,{ responseType: 'text'});
  }

  // get all bookings
  getAllBookings(): Observable<any>{
    return this.http.get(`${this.baseUrl}/get-all-bookings`)
  }

  // search booking by ID
  getBooking(bookingId: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/search-booking/${bookingId}`);
  } 

  // search by userId
  getBookingByUserId(userId: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/get-bookings-by-userId/${userId}`)
  }

  // get booking description
  getBookingDescription(bookingId: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/get-booking-desc/${bookingId}`)
  }
}






