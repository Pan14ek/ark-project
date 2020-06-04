import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class FilterWorkLogService {

  constructor(private http: HttpClient) {
  }

  getAllFilterWorkLog() {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.get(`${environment.apiHerokuBaseUrl}/filter/worklog/all`, httpOptions);
  }

}
