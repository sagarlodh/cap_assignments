import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { user } from '../Models/user.component';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  /* USER SERVICE URL */
  private baseUrl='http://localhost:8081/users';
  constructor(private http: HttpClient) { }

  // create user
  createUser(user: Object): Observable<any> {
    return this.http.post(`${this.baseUrl}/create-user`,user,{responseType: 'text' as "json"});
  }
 
  // update user
  updateUser(userId: number, user: Object): Observable<any>{
    return this.http.put(`${this.baseUrl}/update-user/${userId}`,user,{responseType: 'text' as "json"});
  }

  // delete user
  deleteUser(userId: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/delete-user/${userId}`,{ responseType: 'text'});
  }

  // get all users
  getAllUsers(): Observable<any>{
    return this.http.get(`${this.baseUrl}/get-all-users`)
  }

  // search user by ID
  getUser(userId: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/search-user/${userId}`);
  } 

  // search by name
  getUserByName(firstName: string): Observable<any>{
    return this.http.get(`${this.baseUrl}/search-user-by-firstName/${firstName}`)
  }

  // search by user type
  getUserByType(userType: string): Observable<any>{
    return this.http.get(`${this.baseUrl}/search-user-by-type/${userType}`)
  }

}
