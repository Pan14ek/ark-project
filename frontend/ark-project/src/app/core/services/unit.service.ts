import {Injectable} from '@angular/core';
import {Service} from './service';

@Injectable({
  providedIn: 'root'
})
export class UnitService extends Service {

  getUnitById(unitId: number) {
    return this.serviceHttp.get(`${this.ENV_URL}/unit/${unitId}`, this.getOptions());
  }

}
