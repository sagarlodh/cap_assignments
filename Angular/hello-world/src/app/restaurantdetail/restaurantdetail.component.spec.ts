import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantdetailComponent } from './restaurantdetail.component';

describe('RestaurantdetailComponent', () => {
  let component: RestaurantdetailComponent;
  let fixture: ComponentFixture<RestaurantdetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantdetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
