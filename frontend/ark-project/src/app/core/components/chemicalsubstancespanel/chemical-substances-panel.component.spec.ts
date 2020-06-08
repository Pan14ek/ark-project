import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ChemicalSubstancesPanelComponent} from './chemical-substances-panel.component';

describe('ChemicalsubstancespanelComponent', () => {
  let component: ChemicalSubstancesPanelComponent;
  let fixture: ComponentFixture<ChemicalSubstancesPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ChemicalSubstancesPanelComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChemicalSubstancesPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
