import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { user } from '../Models/user.component';
import { UserService } from '../Services/user.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  /* DATA */
  user: user = new user();
  submitted=false
  message:any

  /* CONSTRUCTOR */
  constructor(private userService: UserService, private router:Router) { }

  ngOnInit(): void {}
  
  newUser(): void{
    this.submitted=false;
    this.user=new user();
  }

  /* INIT ON SUBMIT */
  onSubmit(){
    this.submitted=true;
    this.save();
  }

  save(){
    /* CREATE USER SERVICE API */
    this.userService.createUser(this.user)
    .subscribe(response => {this.message = response}, error => {alert(error.error.message)});
    this.user = new user();
    this.gotoList();
  }

  /* FOR SHOWING THE RESPONSE */
  gotoList(){
    this.router.navigate(['/register']);
  }
}
