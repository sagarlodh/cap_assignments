import { Component, OnInit } from '@angular/core';
import { ActivatedRoute , Router} from '@angular/router';

@Component({
  selector: 'app-umenudetail',
  template: `
  <h3>Click below to Order Food</h3>
  <nav>
  <a routerLink="/orderfood" routerLinkActive="active">Order Dish</a> 
  </nav><br>
  <button (click)="back()">Cancel</button>
  `,
  styles: [
  ]
})
export class UmenudetailComponent implements OnInit {

  public dishId:any;
  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(){
    let id = this.route.snapshot.paramMap.get('id');
    this.dishId = id;
  }

  back(){
    this.router.navigate(['/umenu']);
  }

}
