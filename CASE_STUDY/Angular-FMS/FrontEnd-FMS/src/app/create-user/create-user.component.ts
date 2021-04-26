import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { user } from '../Models/user.component';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  /* DATA */
  id:any
  user: user = new user();
  submitted=false
  message:any

  /* CONSTRUCTOR */
  constructor(private userService: UserService, private router:Router,private route:
    ActivatedRoute) { }

  ngOnInit(): void {
    /* EXTRACTING THE USER */
    this.id = this.route.snapshot.params['id']
  }
  
  newUser(): void{
    this.submitted=false;
    this.user=new user();
  }

  /* INIT SUBMIT */
  onSubmit(){
    this.submitted=true;
    this.save();
  }

  save(){
    /********* CREATE USER SERVICE ******** */
    this.userService.createUser(this.user)
    .subscribe(response => {this.message = response}, (error: HttpErrorResponse) => {alert(error.error.message)});
    this.user = new user();
    this.response();
  }

  response(){
    this.router.navigate(['/create-user',this.id]);
  }

  /* BACK */
  goBackToList(){
    this.router.navigate(['/list-users',this.id]);
  }
}
