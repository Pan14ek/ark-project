import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {FilterStatisticWorklogBarChartComponent} from './filter-statistic-worklog-bar-chart.component';

describe('FilterStatisticWorklogBarChartComponent', () => {
  let component: FilterStatisticWorklogBarChartComponent;
  let fixture: ComponentFixture<FilterStatisticWorklogBarChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FilterStatisticWorklogBarChartComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterStatisticWorklogBarChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
