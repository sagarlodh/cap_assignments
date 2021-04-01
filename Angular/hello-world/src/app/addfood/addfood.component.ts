import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

@Component({
  selector: 'app-addfood',
  template: `
  <h3>Fill in details of DISH to be added !</h3>
  <form action="/foodAdded.html" method="get">
    <div>
        <label>Dish Name :</label>
        <input type="text" name="foodName" required>
    </div><br><br>
    <div>
        <label>Dish Price :</label>
        <input type="number" name="foodPrice" required>
    </div><br><br>
    <div>
        <label>Dish Style :</label>
        <input type="text" name="foodStyle">
    </div><br><br>
    <div>
        <input type="submit" value="Add">
    </div><br>
    <div>
      <input (click)="cancel()" type="submit" value="Cancel">
    </div>
    </form>
  `,
  styles: [
  ]
})
export class AddfoodComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  cancel(){
      this.router.navigate(['/menu'])
  }


}
