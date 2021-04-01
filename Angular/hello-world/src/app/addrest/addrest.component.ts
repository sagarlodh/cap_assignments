import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

@Component({
  selector: 'app-addrest',
  template: `
  <h3>Fill in details of RESTAURANT to be added !</h3>
  <form action="/restAdded.html" method="get">
  <div>
      <label>Restaurant Name :</label>
      <input type="text" name="restName" required>
  </div><br><br>
  <div>
      <label>Restaurant Rating :</label>
      <input type="text" name="restRate" required>
  </div><br><br>
  <div>
      <label>Restaurant Location :</label>
      <input type="text" name="restLoc">
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
export class AddrestComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  cancel(){
    this.router.navigate(['/restaurant'])
}

}
