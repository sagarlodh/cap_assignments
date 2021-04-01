import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletefoodComponent } from './deletefood.component';

describe('DeletefoodComponent', () => {
  let component: DeletefoodComponent;
  let fixture: ComponentFixture<DeletefoodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeletefoodComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletefoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
