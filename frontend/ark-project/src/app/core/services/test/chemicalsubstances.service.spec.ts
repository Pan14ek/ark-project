import {TestBed} from '@angular/core/testing';

import {ChemicalsubstancesService} from '../chemicalsubstances.service';

describe('ChemicalsubstancesService', () => {
  let service: ChemicalsubstancesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChemicalsubstancesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
