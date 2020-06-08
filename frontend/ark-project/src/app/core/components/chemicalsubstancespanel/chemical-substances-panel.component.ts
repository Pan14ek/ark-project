import {Component, OnInit} from '@angular/core';
import {ChemicalSubstancesService} from '../../services/chemicalsubstances.service';
import {ChemicalSubstanceDto} from '../../../models/dto/ChemicalSubstanceDto';
import {ChemicalSubstance} from '../../../models/entity/ChemicalSubstance';

@Component({
  selector: 'app-chemicalsubstancespanel',
  templateUrl: './chemical-substances-panel.component.html',
  styleUrls: ['./chemical-substances-panel.component.css']
})
export class ChemicalSubstancesPanelComponent implements OnInit {

  title;
  formula;
  addFormFlag;
  updateFormFlag;
  showAllChemicalSubstancesFlag;
  chemicalSubstances;

  constructor(private chemicalSubstancesService: ChemicalSubstancesService) {
  }

  ngOnInit(): void {
    this.chemicalSubstancesService
      .getAllChemicalSubstances()
      .subscribe((chemicalSubstances) => this.chemicalSubstances = chemicalSubstances);
  }

  showAddForm() {
    this.addFormFlag = !this.addFormFlag;
  }

  showUpdateForm() {
    this.updateFormFlag = !this.updateFormFlag;
  }

  showAllFilters() {
    this.showAllChemicalSubstancesFlag = !this.showAllChemicalSubstancesFlag;
  }

  addChemicalSubstances() {
    const chemicalSubstanceDto = new ChemicalSubstanceDto(this.title, this.formula);
    this.chemicalSubstancesService.addChemicalSubstances(chemicalSubstanceDto).subscribe((chemicalSubstance: ChemicalSubstance) => {
        if (chemicalSubstance.id > 0) {
          alert('Chemical substance added success!');
        }
      },
      error => {
        console.log(error);
      });
  }

}
