import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UmenuComponent } from './umenu.component';

describe('UmenuComponent', () => {
  let component: UmenuComponent;
  let fixture: ComponentFixture<UmenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UmenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UmenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
