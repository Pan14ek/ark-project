import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {PersonalScheduleDto} from '../../models/dto/PersonalScheduleDto';
import {environment} from '../../../environments/environment.prod';
import {UserPersonalScheduleDto} from '../../models/dto/UserPersonalScheduleDto';
import {ConfirmDto} from '../../models/dto/ConfirmDto';

@Injectable({
  providedIn: 'root'
})
export class PersonalScheduleService {

  constructor(private http: HttpClient) {
  }

  addPersonalSchedule(personalScheduleDto: PersonalScheduleDto) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.post(`${environment.apiHerokuBaseUrl}/personal/schedule/add`, personalScheduleDto, httpOptions);
  }

  getAllSchedule() {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.get(`${environment.apiHerokuBaseUrl}/personal/schedule/all`, httpOptions);
  }

  addUserPersonalSchedule(userPersonalScheduleDto: UserPersonalScheduleDto) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.post(`${environment.apiHerokuBaseUrl}/user/person/schedule/add`, userPersonalScheduleDto, httpOptions);
  }

  getAllSchedulesByUserId(userId: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.get(`${environment.apiHerokuBaseUrl}/user/person/schedule/${userId}`, httpOptions);
  }

  confirmWorkDay(confirmDto: ConfirmDto) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.post(`${environment.apiHerokuBaseUrl}/user/person/schedule/confirm`, confirmDto, httpOptions);
  }

}
