import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-editrest',
  template: `
  <p>
    editRestaurant form will prefilled values will be displayed here...
  </p>
  <form>
      <input type="submit" value="Save">
    </form>
  `,
  styles: [
  ]
})
export class EditrestComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
