import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-menudetail',
  template: `
  <h3>Perform Operations regarding '{{menuFood}}' with ID : {{menuId}}</h3>
  <nav>
    <a routerLink="/editfood" routerLinkActive="active">Edit Food</a>
    <a routerLink="/deletefood" routerLinkActive="active">Delete Food</a>
  </nav><br>
  <button (click)="back()">Back</button>
  `,
  styles: [
  ]
})
export class MenudetailComponent implements OnInit {

  public menuId:any;
  public menuFood:any;
  constructor(private route: ActivatedRoute,private router: Router) { }

  ngOnInit(){
        //comment not needed paramMap
        let id = this.route.snapshot.paramMap.get('id');
        let food = this.route.snapshot.paramMap.get('food');
        /* let id = params.get('id');
        let food = params.get('food'); */
        this.menuId = id;
        this.menuFood = food;
  }

 /*  back(){
    let backID = this.menuId - 1;
    this.router.navigate(['/menu',backID]);
  }

  next(){
    let nextId = this.menuId + 1;
    this.router.navigate(['/menu',nextId]);
  } */

  back(){
      let selectId = this.menuId ? this.menuId : null;
      this.router.navigate(['/menu',{id:selectId}]);
      //this.router.navigate(['../',{id:selectId}],{relativeTo: this.route});
  }
}
