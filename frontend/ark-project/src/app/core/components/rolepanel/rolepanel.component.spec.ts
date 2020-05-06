import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {RolepanelComponent} from './rolepanel.component';

describe('RolepanelComponent', () => {
  let component: RolepanelComponent;
  let fixture: ComponentFixture<RolepanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [RolepanelComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RolepanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
