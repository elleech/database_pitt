import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpersonComponent } from './sperson.component';

describe('SpersonComponent', () => {
  let component: SpersonComponent;
  let fixture: ComponentFixture<SpersonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpersonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpersonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
