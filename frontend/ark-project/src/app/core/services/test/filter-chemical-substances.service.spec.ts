import {TestBed} from '@angular/core/testing';

import {FilterChemicalSubstancesService} from './filter-chemical-substances.service';

describe('FilterChemicalSubstancesService', () => {
  let service: FilterChemicalSubstancesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FilterChemicalSubstancesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
