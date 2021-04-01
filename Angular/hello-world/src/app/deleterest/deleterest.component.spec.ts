import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleterestComponent } from './deleterest.component';

describe('DeleterestComponent', () => {
  let component: DeleterestComponent;
  let fixture: ComponentFixture<DeleterestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleterestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleterestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
