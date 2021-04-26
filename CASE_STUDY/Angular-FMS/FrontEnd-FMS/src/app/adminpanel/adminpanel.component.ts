import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-adminpanel',
  templateUrl: './adminpanel.component.html',
  styleUrls: ['./adminpanel.component.css']
})
export class AdminpanelComponent implements OnInit {

  /* DATA */
  userId: any
  user: any
  deleteMessage!: string;
  message: any
  deleteSubmit: any

  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) { }
  
  ngOnInit(): void {
    this.deleteSubmit = false 
    
    /* EXTRACTING THE ID FROM THE ROUTE */
    this.userId = this.route.snapshot.params['id']
    this.reloadData();

  }
  reloadData(){
    /* GETTING THE USER BY RESPECTIVE ID */
    this.userService.getUser(this.userId)
        .subscribe(data => {
          console.log(data),
          this.user = data
        }, error => {alert(error.error.message),this.router.navigate(['/login'])});
        /*  */
  }

  deleteCheck(){
    this.deleteSubmit = true
  }

  /********* DELETE USER SERVICE ***********/
  deleteUser(userId:number){
    this.deleteMessage = "Click on 'OK' to delete Account!"
    alert(this.deleteMessage)
    if(
      this.userService.deleteUser(userId)
      .subscribe(
        response => {this.message = response;this.reloadData();},
        (error : HttpErrorResponse) => {alert(error.error.message)})
    ){this.router.navigate(['/login'])}

  }

  cancelDelete(){
    this.deleteSubmit = false
  }

  /* NAVIGATE TO ADMIN UPDATE BY ID */
  updateAdminDetails(userId: number){
    this.router.navigate(['/adminUpdate',userId])
  }

  /* TO USERS LIST */
  goToUsersList(){
    this.router.navigate(['/list-users',this.userId])
  }

  /* TO AIRPORTS LIST */
  goToAirportsList(){
    this.router.navigate(['/list-airports',this.userId])
  }

  /* TO FLIGHTS LIST */
  goToFlightsList(){
    this.router.navigate(['/list-flights',this.userId])
  }

  /* TO BOOKINGS LIST */
  goToBookingsList(){
    this.router.navigate(['/list-bookings',this.userId])
  }

}
