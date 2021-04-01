import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  template: `
      <!-- HERE WE CAN INCLUDE A FORM FOR CHECKING THE CREDENTIALS FOR THE ADMIN 
           AND RETURN IT TO VALIDATE AGAINST PRE-STORED VALUES AND THEN PROVIDE THE ACCESS TO 
           ADMIN Page **not implemented -->

  <h3>Welcome ADMIN !!</h3>
  <nav>
    <a routerLink="/menu" routerLinkActive="active"><i><b>Menu</b></i></a>
    <a routerLink="/restaurant" routerLinkActive="active"><i><b>Restaurants</b></i></a>
  </nav>
  `,
  styles: [
  ]
})
export class AdminComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
