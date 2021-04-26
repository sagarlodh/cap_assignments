import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchFlightByCarrierComponent } from './search-flight-by-carrier.component';

describe('SearchFlightByCarrierComponent', () => {
  let component: SearchFlightByCarrierComponent;
  let fixture: ComponentFixture<SearchFlightByCarrierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchFlightByCarrierComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchFlightByCarrierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
