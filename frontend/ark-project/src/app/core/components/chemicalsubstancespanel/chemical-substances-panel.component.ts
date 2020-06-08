import {Component, OnInit} from '@angular/core';
import {ChemicalSubstancesService} from '../../services/chemicalsubstances.service';

@Component({
  selector: 'app-chemicalsubstancespanel',
  templateUrl: './chemical-substances-panel.component.html',
  styleUrls: ['./chemical-substances-panel.component.css']
})
export class ChemicalSubstancesPanelComponent implements OnInit {

  addFormFlag;
  updateFormFlag;
  showAllFiltersFlag;

  constructor(private chemicalSubstancesService: ChemicalSubstancesService) {
  }

  ngOnInit(): void {
  }

  showAddForm() {

  }

  showUpdateForm() {

  }

  showAllFilters() {

  }

}
