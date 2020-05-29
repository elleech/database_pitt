import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CasecommentComponent } from './casecomment.component';

describe('CasecommentComponent', () => {
  let component: CasecommentComponent;
  let fixture: ComponentFixture<CasecommentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CasecommentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CasecommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
