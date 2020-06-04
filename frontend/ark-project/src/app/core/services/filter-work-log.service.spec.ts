import {TestBed} from '@angular/core/testing';

import {FilterWorkLogService} from './filter-work-log.service';

describe('FilterWorkLogService', () => {
  let service: FilterWorkLogService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FilterWorkLogService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
