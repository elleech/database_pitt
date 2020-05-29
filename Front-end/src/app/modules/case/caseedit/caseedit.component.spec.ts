import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseeditComponent } from './caseedit.component';

describe('CaseeditComponent', () => {
  let component: CaseeditComponent;
  let fixture: ComponentFixture<CaseeditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaseeditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaseeditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
