import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchAirportByParamsComponent } from './search-airport-by-params.component';

describe('SearchAirportByParamsComponent', () => {
  let component: SearchAirportByParamsComponent;
  let fixture: ComponentFixture<SearchAirportByParamsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchAirportByParamsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchAirportByParamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
