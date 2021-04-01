import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-orderfood',
  template: `
    <h3>
      SUCCESS!! <small>Your dish hs been ordered.</small>
    </h3>
  `,
  styles: []
})
export class OrderfoodComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
