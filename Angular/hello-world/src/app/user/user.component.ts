import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user',
  template: `
  <h2>Welcome USER !!</h2>
  <h3><i><b>RESTAURANTS LISTED</b></i></h3>
  <p class="items">
    <li class="items" (click)="onSelect(restaurant)" *ngFor="let restaurant of restaurants">
        <span class="badge">{{restaurant.id}}</span> {{restaurant.rest}}
    </li>
  </p>
  `,
  styles: []
})
export class UserComponent implements OnInit {
  restaurants=[
    {"id": 1,"rest": "Italian Cooks"},
    {"id": 2,"rest": "Shalimaar Spices"},
    {"id": 3,"rest": "Great Chefs"},
    {"id": 4,"rest": "Desi Cooks"},
    {"id": 5,"rest": "International"}
  ]
  constructor(private router: Router) { }
  ngOnInit(): void {
  }

  onSelect(option: { id: any; }){
    this.router.navigate(['/umenu'])
  }

}
