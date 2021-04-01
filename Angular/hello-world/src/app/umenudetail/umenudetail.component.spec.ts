import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UmenudetailComponent } from './umenudetail.component';

describe('UmenudetailComponent', () => {
  let component: UmenudetailComponent;
  let fixture: ComponentFixture<UmenudetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UmenudetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UmenudetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
