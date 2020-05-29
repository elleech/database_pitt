import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuycreateComponent } from './buycreate.component';

describe('BuycreateComponent', () => {
  let component: BuycreateComponent;
  let fixture: ComponentFixture<BuycreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuycreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuycreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  }); 
}); 
