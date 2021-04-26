import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustSearchBookingDescComponent } from './cust-search-booking-desc.component';

describe('CustSearchBookingDescComponent', () => {
  let component: CustSearchBookingDescComponent;
  let fixture: ComponentFixture<CustSearchBookingDescComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustSearchBookingDescComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustSearchBookingDescComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
