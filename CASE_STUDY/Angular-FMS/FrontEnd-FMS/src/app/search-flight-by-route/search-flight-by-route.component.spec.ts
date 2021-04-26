import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchFlightByRouteComponent } from './search-flight-by-route.component';

describe('SearchFlightByRouteComponent', () => {
  let component: SearchFlightByRouteComponent;
  let fixture: ComponentFixture<SearchFlightByRouteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchFlightByRouteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchFlightByRouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
