import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { user } from '../Models/user.component';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-search-user',
  templateUrl: './search-user.component.html',
  styleUrls: ['./search-user.component.css']
})
export class SearchUserComponent implements OnInit {

  /* DATA */
  uid: any
  id!: number
  user!: user

  /* CONSTRUCTOR */
  constructor(private route: ActivatedRoute, private router: Router,
    private userService: UserService) { }

  ngOnInit(): void {
    this.user = new user()
    this.uid = this.route.snapshot.params['uid']
    this.id = this.route.snapshot.params['id']

    /* VIEW USER DETAILS */
    this.userService.getUser(this.uid)
        .subscribe(data => {
          this.user = data;
        }, error => console.log(error));
  }

  /* BACK */
  goBackToList(){
    this.router.navigate(['/list-users',this.id])
  }

}
