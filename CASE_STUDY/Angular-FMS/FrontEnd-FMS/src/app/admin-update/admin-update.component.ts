import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { user } from '../Models/user.component';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-admin-update',
  templateUrl: './admin-update.component.html',
  styleUrls: ['./admin-update.component.css']
})
export class AdminUpdateComponent implements OnInit {

  /* DATA */
  id: any
  user!: user
  submitted: any

  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) { }

  ngOnInit(): void {
    this.submitted = false
    this.user = new user()
    
    /* EXTRACTING THE ID FROM THE ROUTE */
    this.id = this.route.snapshot.params['id']
    
    /* GETTING THE USER BY RESPECTIVE ID */
    this.userService.getUser(this.id)
        .subscribe(data => {console.log(data)
          this.user = data
        }, (error: HttpErrorResponse) => console.log(error.error.message));
  }

  /***************** UPDATE USER SERVICE *****************/
  updateUser(){
    this.userService.updateUser(this.id, this.user)
        .subscribe(response => alert(response), 
        (error: HttpErrorResponse) => alert(error.error.message));
        this.user = new user()
        this.gotoList();
  }

  /* INIT ON SUBMIT OF DETAILS */
  onSubmit(){
    this.submitted = true
    this.updateUser()
  }

  /* NAVIGATE TO ADMIN, PASSING IN THE ID */
  gotoList(){
    this.router.navigate(['/adminPanel',this.id]).then(() => {
      window.location.reload();
    });
  }

}
