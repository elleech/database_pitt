import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpersoncreateComponent } from './spersoncreate.component';

describe('SpersoncreateComponent', () => {
  let component: SpersoncreateComponent;
  let fixture: ComponentFixture<SpersoncreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpersoncreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpersoncreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
