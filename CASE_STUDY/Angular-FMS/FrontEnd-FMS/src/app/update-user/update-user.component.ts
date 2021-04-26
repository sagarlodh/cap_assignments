import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { user } from '../Models/user.component';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  /* DATA */
  id: any
  uid!: number
  user!: user
  submitted: any
  
  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) { }

  ngOnInit(): void {
    this.submitted = false
    this.user = new user()

    /* EXTRACTING IDs */
    this.id = this.route.snapshot.params['id']
    this.uid = this.route.snapshot.params['uid']

    /* VIEW USER DETAILS SERVICE */
    this.userService.getUser(this.uid)
        .subscribe(data => {
          console.log(data)
          this.user = data
        }, error => console.log(error));
  }


  /* INIT ON SUBMIT */
  onSubmit(){
    this.submitted = true
    this.updateUser()
  }

  /* UPDATE USER DETAILS SERVICE */
  updateUser(){
    this.userService.updateUser(this.uid, this.user)
        .subscribe(data => console.log(data), error => console.log(error));
        this.user = new user()
        this.gotoList();
  }

  /* BACK */
  gotoList(){
    this.router.navigate(['/list-users',this.id])
  }

}
