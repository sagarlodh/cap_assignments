import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { login } from '../Models/login.component';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  /* LOGIN SERVICE URL */
  private baseUrl='http://localhost:8182/login';
  constructor(private http: HttpClient) { }

  // validate the user
  validateUser(login: Object): Observable<any>{
    return this.http.post(`${this.baseUrl}`,login,{responseType: 'text' as 'json'})
  }

}
