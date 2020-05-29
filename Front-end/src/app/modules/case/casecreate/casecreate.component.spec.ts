import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CasecreateComponent } from './casecreate.component';

describe('CasecreateComponent', () => {
  let component: CasecreateComponent;
  let fixture: ComponentFixture<CasecreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CasecreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CasecreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
