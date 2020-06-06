import {Injectable} from '@angular/core';
import {Service} from './service';

@Injectable({
  providedIn: 'root'
})
export class FilterService extends Service {

  getFilterById(filterId: number) {
    return this.serviceHttp.get(`${this.ENV_URL}/filter/${filterId}`, this.getOptions());
  }

}
