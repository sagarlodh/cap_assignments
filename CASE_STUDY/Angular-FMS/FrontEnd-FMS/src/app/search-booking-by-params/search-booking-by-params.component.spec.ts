import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchBookingByParamsComponent } from './search-booking-by-params.component';

describe('SearchBookingByParamsComponent', () => {
  let component: SearchBookingByParamsComponent;
  let fixture: ComponentFixture<SearchBookingByParamsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchBookingByParamsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchBookingByParamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
