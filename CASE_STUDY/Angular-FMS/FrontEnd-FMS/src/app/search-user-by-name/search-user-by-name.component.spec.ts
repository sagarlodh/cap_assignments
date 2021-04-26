import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchUserByNameComponent } from './search-user-by-name.component';

describe('SearchUserByNameComponent', () => {
  let component: SearchUserByNameComponent;
  let fixture: ComponentFixture<SearchUserByNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchUserByNameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchUserByNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
