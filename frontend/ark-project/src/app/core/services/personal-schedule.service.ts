import {Injectable} from '@angular/core';
import {PersonalScheduleDto} from '../../models/dto/PersonalScheduleDto';
import {UserPersonalScheduleDto} from '../../models/dto/UserPersonalScheduleDto';
import {ConfirmDto} from '../../models/dto/ConfirmDto';
import {Service} from './service';

@Injectable({
  providedIn: 'root'
})
export class PersonalScheduleService extends Service {

  addPersonalSchedule(personalScheduleDto: PersonalScheduleDto) {
    return this.serviceHttp.post(`${this.ENV_URL}/personal/schedule/add`,
      personalScheduleDto, this.getOptionsWithJsonContent());
  }

  getAllSchedule() {
    return this.serviceHttp.get(`${this.ENV_URL}/personal/schedule/all`, this.getOptions());
  }

  addUserPersonalSchedule(userPersonalScheduleDto: UserPersonalScheduleDto) {
    return this.serviceHttp.post(`${this.ENV_URL}/user/person/schedule/add`,
      userPersonalScheduleDto, this.getOptionsWithJsonContent());
  }

  getAllSchedulesByUserId(userId: number) {
    return this.serviceHttp.get(`${this.ENV_URL}/user/person/schedule/${userId}`, this.getOptions());
  }

  confirmWorkDay(confirmDto: ConfirmDto) {
    return this.serviceHttp.post(`${this.ENV_URL}/user/person/schedule/confirm`,
      confirmDto, this.getOptionsWithJsonContent());
  }

}
