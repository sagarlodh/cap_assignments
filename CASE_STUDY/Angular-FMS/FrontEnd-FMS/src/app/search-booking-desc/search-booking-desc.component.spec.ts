import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchBookingDescComponent } from './search-booking-desc.component';

describe('SearchBookingDescComponent', () => {
  let component: SearchBookingDescComponent;
  let fixture: ComponentFixture<SearchBookingDescComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchBookingDescComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchBookingDescComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
