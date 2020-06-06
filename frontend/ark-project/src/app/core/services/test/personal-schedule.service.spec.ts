import {TestBed} from '@angular/core/testing';

import {PersonalScheduleService} from '../personal-schedule.service';

describe('PersonalScheduleService', () => {
  let service: PersonalScheduleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PersonalScheduleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
