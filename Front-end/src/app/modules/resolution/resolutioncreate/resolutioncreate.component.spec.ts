import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResolutioncreateComponent } from './resolutioncreate.component';

describe('ResolutioncreateComponent', () => {
  let component: ResolutioncreateComponent;
  let fixture: ComponentFixture<ResolutioncreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResolutioncreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResolutioncreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
