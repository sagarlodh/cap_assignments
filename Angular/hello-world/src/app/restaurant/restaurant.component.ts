import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-restaurant',
  template: `
  <h3>RESTAURANTS LISTED</h3>
  <nav>
    <a routerLink="/addrestaurant" routerLinkActive="active">Add Restauant</a> 
  </nav>
  <p class="items">
    <li class="items" (click)="onSelect(restaurant)" *ngFor="let restaurant of restaurants">
        <span class="badge">{{restaurant.id}}</span> {{restaurant.rest}}
    </li>
  </p>
  <button (click)="back()">Back</button>
  `,
  styles: []
})
export class RestaurantComponent implements OnInit {

  restaurants=[
    {"id": 1,"rest": "Italian Cooks"},
    {"id": 2,"rest": "Shalimaar"},
    {"id": 3,"rest": "Great Chefs"},
    {"id": 4,"rest": "Desi Cooks"},
    {"id": 5,"rest": "International"}
  ]
  
  constructor(private router: Router,private route: ActivatedRoute) { }
  ngOnInit(): void {
  }

  onSelect(option: { id: any;rest: string; }){
    this.router.navigate(['/restaurant',option.id,option.rest])
    //this.router.navigate([option.id,option.rest],{relativeTo: this.route});
  }
  
  back(){
    this.router.navigate(['/admin']);
  }
}
