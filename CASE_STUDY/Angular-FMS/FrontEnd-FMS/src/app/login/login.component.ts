import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../Services/login.service';
import { login } from '../Models/login.component'
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { user } from '../Models/user.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  /* DATA */
  email!: string
  password!: string
  login!: login
  user: any
  userId: any

  /* LOGIN SERVICE BASE URL */
  private baseUrl='http://localhost:8182/login';

  /* CONSTRUCTOR */
  constructor(private loginService: LoginService, private router: Router, private http: HttpClient) { }

  ngOnInit(): void {}

  onSubmit(){
    /* FETCHING THE DETAILS OF THE USER LOGIN IF PRESENT OR RETURNING THE ERROR MESSAGE */
    this.login = new login(this.email, this.password)
    this.http.post(`${this.baseUrl}`,this.login)
    .toPromise().then(data => this.user = data, (httpError : HttpErrorResponse) => 
    {alert(httpError.error.text);
    });
    

    /* CALLING THE VALIDATE FUNCTION */
    this.validateUser();
  }

  validateUser(){
    /* LOGGIN THE RESULT FETCHED AND ROUTING IF MATCHED DETAILS */
    console.log(this.user);
    this.routeToRespectivePage(this.user.userType)
    
  }

  /* ROUTING TO RESPECTIVE PAGE IF THE DETAILS ARE CORRECT */
  routeToRespectivePage(userType: string){
    if(userType == "ADMIN"){
      this.userId = this.user._id
      this.router.navigate(['/adminPanel',this.userId])
    } else {
      this.userId = this.user._id
      this.router.navigate(['/userPanel',this.userId])
    }
    /* MORE ENTITIES CAN BE CREATED LATER */
  }

}
