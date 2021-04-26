import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../Services/user.service';


@Component({
  selector: 'app-search-user-by-name',
  templateUrl: './search-user-by-name.component.html',
  styleUrls: ['./search-user-by-name.component.css']
})
export class SearchUserByNameComponent implements OnInit {

  /* DATA */
  id:any
  firstName!: string
  userType!: string
  users: any;
  usersByType: any
  message: "" = "";

  /* CONSTRUCTOR */
  constructor(private userService: UserService, private router: Router,
    private route:ActivatedRoute) { }

  ngOnInit(): void {
    /* EXTRACTING THE USER ID */
    this.id = this.route.snapshot.params['id']
  }

  /* ************** SEARCH USER BY CRITERIAS **************** */
  public findUserByFirstName(){
    let response = this.userService.getUserByName(this.firstName)
    response.subscribe(data => this.users = data)
  }
  public findUserByUserType(){
    let response = this.userService.getUserByType(this.userType)
    response.subscribe(data => this.usersByType = data)
  }

  /* REMOVE USER SERVICE */
  deleteUser(userId:number){
    this.userService.deleteUser(userId)
    .subscribe(
      response => {this.message = response;},
      (error : HttpErrorResponse) => {alert(error)});
  }

  /* NAVIGATE TO UPDATE USER BY ID */
  updateUser(userId: number){
    this.router.navigate(['/update-user',this.id,userId])
    .then(() => {
      window.location.reload();
    });
  }

  /* NAVIGATE TO VIEW DETAILS FOR USER BY ID */
  searchUser(userId: number){
    this.router.navigate(['/search-user',this.id,userId]);
  }


  /* BACK */
  goBackToList(){
    this.router.navigate(['/list-users',this.id])
  }

}
