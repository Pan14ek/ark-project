import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {FilterWorklogComponent} from './filter-worklog.component';

describe('FilterWorklogComponent', () => {
  let component: FilterWorklogComponent;
  let fixture: ComponentFixture<FilterWorklogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FilterWorklogComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterWorklogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
