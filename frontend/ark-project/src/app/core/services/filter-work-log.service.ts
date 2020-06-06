import {Injectable} from '@angular/core';
import {Service} from './service';

@Injectable({
  providedIn: 'root'
})
export class FilterWorkLogService extends Service {

  getAllFilterWorkLog() {
    return this.serviceHttp.get(`${this.ENV_URL}/filter/worklog/all`, this.getOptions());
  }

}
