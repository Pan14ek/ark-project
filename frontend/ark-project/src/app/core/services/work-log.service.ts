import {Injectable} from '@angular/core';
import {Service} from './service';
import {WorkLogDto} from '../../models/dto/WorkLogDto';

@Injectable({
  providedIn: 'root'
})
export class WorkLogService extends Service {

  confirmWorkDay(workLogDto: WorkLogDto) {
    console.log(workLogDto);
    return this.serviceHttp.post(`${this.ENV_URL}/worklog/add`, workLogDto, this.getOptionsWithJsonContent());
  }

  findWorkLogByUserIdAndDate(userId, workDate) {
    return this.serviceHttp.get(`${this.ENV_URL}/worklog/user/${userId}/workDate/${workDate}`, this.getOptions());
  }

}
