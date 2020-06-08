import {Injectable} from '@angular/core';
import {Service} from './service';
import {ChemicalSubstanceDto} from '../../models/dto/ChemicalSubstanceDto';

@Injectable({
  providedIn: 'root'
})
export class ChemicalSubstancesService extends Service {

  getAllChemicalSubstances() {
    return this.serviceHttp.get(`${this.ENV_URL}/chemical/substance/all`, this.getOptions());
  }

  addChemicalSubstances(chemicalSubstanceDto: ChemicalSubstanceDto) {
    return this.serviceHttp.post(`${this.ENV_URL}/chemical/substance/add`,
      chemicalSubstanceDto, this.getOptionsWithJsonContent());
  }

}
