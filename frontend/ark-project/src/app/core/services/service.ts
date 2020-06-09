import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class Service {

  protected serviceHttp: HttpClient;
  protected ENV_URL = environment.apiHerokuBaseUrl;

  constructor(private http: HttpClient) {
    this.serviceHttp = http;
  }

  protected getOptions() {
    return {
      headers: new HttpHeaders({
        Authorization: localStorage.getItem('token')
      })
    };
  }

  protected getOptionsWithJsonContent() {
    return {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: localStorage.getItem('token')
      })
    };
  }

}
