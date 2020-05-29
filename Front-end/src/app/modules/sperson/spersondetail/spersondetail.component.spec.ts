import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpersondetailComponent } from './spersondetail.component';

describe('SpersondetailComponent', () => {
  let component: SpersondetailComponent;
  let fixture: ComponentFixture<SpersondetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpersondetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpersondetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
