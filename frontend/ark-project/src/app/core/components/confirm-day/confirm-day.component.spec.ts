import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ConfirmDayComponent} from './confirm-day.component';

describe('ConfirmDayComponent', () => {
  let component: ConfirmDayComponent;
  let fixture: ComponentFixture<ConfirmDayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ConfirmDayComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmDayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
