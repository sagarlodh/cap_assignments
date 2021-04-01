import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  template: `
  <h3>
    MENU Options for each RESTAURANT
  </h3>
  <nav>
    <a routerLink="/addfood" routerLinkActive="active">Add Food</a> 
  </nav>
  <p class="items">
    <li class="items" (click)="onSelect(option)" *ngFor="let option of options">
        <span class="badge">{{option.id}}</span> {{option.food}}
    </li>
  </p>
  <button (click)="back()">Back</button>
  `,
  styles: []
})
export class MenuComponent implements OnInit {
  
  options=[
    {"id": 1,"food": "Biriyani"},
    {"id": 2,"food": "Chicken Curry"},
    {"id": 3,"food": "Mojito"},
    {"id": 4,"food": "Crab Toast"},
    {"id": 5,"food": "Chocolate Cake"}
  ]
  constructor(private router: Router,private route: ActivatedRoute) { }
  ngOnInit(): void {
  }

  onSelect(option: {id: any;food: string;}){
    this.router.navigate(['/menu',option.id,option.food]);
    //this.router.navigate([option.id,option.food],{relativeTo: this.route});
  }  
  back(){
    this.router.navigate(['/admin']);
  }
  
}
