import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllAirportsComponent } from './get-all-airports.component';

describe('GetAllAirportsComponent', () => {
  let component: GetAllAirportsComponent;
  let fixture: ComponentFixture<GetAllAirportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllAirportsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllAirportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
