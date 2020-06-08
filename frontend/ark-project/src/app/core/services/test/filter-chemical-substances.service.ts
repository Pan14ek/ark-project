import {Injectable} from '@angular/core';
import {Service} from '../service';

@Injectable({
  providedIn: 'root'
})
export class FilterChemicalSubstancesService extends Service {

  findAllByFilterId(filterId) {
    return this.serviceHttp.get(`${this.ENV_URL}/filter/chemical/substances/all/filterId/${filterId}`, this.getOptions());
  }

}
