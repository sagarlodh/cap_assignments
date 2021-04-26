import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllFlightsComponent } from './get-all-flights.component';

describe('GetAllFlightsComponent', () => {
  let component: GetAllFlightsComponent;
  let fixture: ComponentFixture<GetAllFlightsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllFlightsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllFlightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
