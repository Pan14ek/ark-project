import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ConfirmWorkdayComponent} from './confirm-workday.component';

describe('ConfirmWorkdayComponent', () => {
  let component: ConfirmWorkdayComponent;
  let fixture: ComponentFixture<ConfirmWorkdayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ConfirmWorkdayComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmWorkdayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
