import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-editfood',
  template: `
    <p>
      editFood form will prefilled values will be displayed here...
    </p>
    <form>
      <input type="submit" value="Save">
    </form>
  `,
  styles: [
  ]
})
export class EditfoodComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
