import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarecommentcreateComponent } from './carecommentcreate.component';

describe('CarecommentcreateComponent', () => {
  let component: CarecommentcreateComponent;
  let fixture: ComponentFixture<CarecommentcreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarecommentcreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarecommentcreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
