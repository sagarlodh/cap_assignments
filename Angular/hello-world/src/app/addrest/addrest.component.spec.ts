import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddrestComponent } from './addrest.component';

describe('AddrestComponent', () => {
  let component: AddrestComponent;
  let fixture: ComponentFixture<AddrestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddrestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddrestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
