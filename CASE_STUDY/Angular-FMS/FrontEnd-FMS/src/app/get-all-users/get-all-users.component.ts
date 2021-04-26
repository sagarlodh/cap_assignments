import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { user } from '../Models/user.component';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-get-all-users',
  templateUrl: './get-all-users.component.html',
  styleUrls: ['./get-all-users.component.css']
})
export class GetAllUsersComponent implements OnInit {
  
  /* DATA */
  id: any
  users: any;
  message: "" = "";

  /* CONSTRUCTOR */
  constructor(private userService: UserService, private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
    /* EXTRACTING THE USER ID */
    this.id = this.route.snapshot.params['id']
  }

  reloadData(){
    /* GET ALL USERS SERVICE API */
    let response = this.userService.getAllUsers();
    response.subscribe(data => {this.users = data}, error => alert(
      "It seems USER-SERVICE is down, please try again later!"
    ))
  }

  /* NAVIGATE TO ADDING USER */
  createUser(){
    this.router.navigate(['/create-user',this.id])
  }

  /* SEARCH USERS BY CRITERIAS */
  searchUserByParams(){
    this.router.navigate(['/search-user-by-name/',this.id])
  }

  /* REMOVE USER SERVICE */
  deleteUser(userId:number){
    this.userService.deleteUser(userId)
    .subscribe(
      response => {this.message = response;this.reloadData();},
      (error : HttpErrorResponse) => {alert(error)});
  }

  /* NAVIGATE TO THE UPDATE USER SERVICE BY USER-ID*/
  updateUser(userId: number){
    this.router.navigate(['/update-user',this.id,userId])
    .then(() => {
      window.location.reload();
    });
  }

  /* VIEW USER DETAILS */
  searchUser(userId: number){
    this.router.navigate(['/search-user',this.id,userId]);
  }

  /* OTHER BUTTON FUNCTIONS */
  goBackToAdmin(){
    this.router.navigate(['/adminPanel',this.id])
  }
  goToAirportList(){
    this.router.navigate(['/list-airports',this.id])
  }
  goToFlightList(){
    this.router.navigate(['/list-flights',this.id])
  }
  goToBookingList(){
    this.router.navigate(['/list-bookings',this.id])
  }
}
