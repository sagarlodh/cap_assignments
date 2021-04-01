import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-umenu',
  template: `
  <h3>
    MENU options for this Restaurant
  </h3>
  <p class="items">
    <li class="items" (click)="onSelect(option)" *ngFor="let option of options">
        <span class="badge">{{option.id}}</span> {{option.food}}
    </li>
  </p>
  <button (click)="back()">Back</button>
  `,
  styles: [
  ]
})
export class UmenuComponent implements OnInit {

  options=[
    {"id": 1,"food": "Biriyani"},
    {"id": 2,"food": "Chicken Curry"},
    {"id": 3,"food": "Mojito"},
    {"id": 4,"food": "Crab Toast"},
    {"id": 5,"food": "Chocolate Cake"}
  ]
  
  constructor(private router: Router) { }
  ngOnInit(): void {
  }

  onSelect(option: { id: any; }){
    this.router.navigate(['/umenu',option.id])
  }  

  back(){
    this.router.navigate(['/user']);
  }

}
