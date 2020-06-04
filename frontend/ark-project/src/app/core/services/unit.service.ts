import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class UnitService {

  constructor(private http: HttpClient) {
  }

  getUnitById(unitId: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + localStorage.getItem('token')
      })
    };
    return this.http.get(`${environment.apiLocal}/unit/${unitId}`, httpOptions);
  }

}
