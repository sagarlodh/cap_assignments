import { Component, OnInit } from '@angular/core';
import { ActivatedRoute , Router } from '@angular/router';

@Component({
  selector: 'app-restaurantdetail',
  template: `
  <h3>Perform operations regarding this restaurant '{{restName}}' with ID : {{restId}}</h3>
  <nav>
    <a routerLink="/editrestaurant" routerLinkActive="active">Edit Restaurant</a>
    <a routerLink="/deleterestaurant" routerLinkActive="active">Delete Restaurant</a> 
  </nav><br>
  <button (click)="back()">Back</button>
  `,
  styles: [
  ]
})
export class RestaurantdetailComponent implements OnInit {
  
  public restId:any;
  public restName:any;
  constructor(private route: ActivatedRoute,private router: Router) { }

  ngOnInit(){
    let id = this.route.snapshot.paramMap.get('id');
    this.restId = id;
    let rest = this.route.snapshot.paramMap.get('rest');
    this.restName = rest;
  }
  back(){
    let selectId = this.restId ? this.restId : null;
    this.router.navigate(['/restaurant',{id:selectId}]);
  }
}
